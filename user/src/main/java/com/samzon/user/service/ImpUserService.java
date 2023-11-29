package com.samzon.user.service;

import com.samzon.user.dto.LoginDto;
import com.samzon.user.dto.UpdateUserDto;
import com.samzon.user.dto.UserDto;
import com.samzon.user.entity.User;
import com.samzon.user.exceptions.UserExceptions;
import com.samzon.user.repository.IUserRepository;
import com.samzon.user.utils.CommonUtils;
import com.samzon.user.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;


@Service
public class ImpUserService implements IUserService{
    @Autowired
    private IUserRepository repo;
    @Autowired
    private User user;
    @Autowired
    private UserDto dtoUser;
    @Autowired
    private CommonUtils commUtils;
    @Autowired
    private UserUtils utils;

    private List<User> userList=new ArrayList<>();
    private List<UserDto>userDtoList=new ArrayList<>();



    @Override
    public UserDto newUser(UserDto userDto) {
        User obj=new User();

        if(!(repo.findByEmail(userDto.getEmail()).isEmpty())){
            throw new UserExceptions(UserExceptions.UserErrors.USER_ALREADY_EXISTS);
        }

        obj.setCode(userDto.getCode());
        obj.setName(userDto.getName());
        obj.setEmail(userDto.getEmail());
        obj.setPassword(utils.passwordEncryption(userDto.getPassword()));
        obj.setDob(utils.dateToLocaDate(userDto.getDob()))                                                                                                                          ;
        obj.setAge(userDto.getAge());
        obj=repo.save(obj);
        dtoUser=utils.entToDto(obj);
        return dtoUser;
    }

    @Override
    public UserDto getById(Long id) {
        user=repo.findById(id)
                .orElseThrow(()->new UserExceptions(UserExceptions.UserErrors.USER_NOT_FOUND));
        dtoUser=utils.entToDto(user);
        return dtoUser;
    }

    @Override
    public UserDto getByCode(String code) {
        user=repo.findByCode(code)
                .orElseThrow(()->new UserExceptions(UserExceptions.UserErrors.USER_NOT_FOUND));
        dtoUser=utils.entToDto(user);
        return dtoUser;
    }

    @Override
    public UserDto getByEmail(String email) {
        user=repo.findByEmail(email)
                .orElseThrow(()->new UserExceptions(UserExceptions.UserErrors.USER_NOT_FOUND));
        dtoUser=utils.entToDto(user);
        return dtoUser;
    }

    @Override
    public List<UserDto> getAll() {
        userList=repo.findAll();
        userDtoList=utils.listEntToDto(userList);
        return userDtoList;
    }

    @Override
    public List<UserDto> getByDob(String dob) {
        LocalDate date=commUtils.stringToDate(dob);
        userList=repo.findAllByDob(date);
        userDtoList=utils.listEntToDto(userList);
        return userDtoList;
    }

    @Override
    public List<UserDto> getByAge(int age) {
        userList=repo.findAllByAge(age);
        userDtoList=utils.listEntToDto(userList);
        return userDtoList;
    }

    @Override
    public UserDto login(LoginDto login) {
        user=repo.findByEmail(login.getEmail())
                .orElseThrow(()->new UserExceptions(UserExceptions.UserErrors.USER_NOT_FOUND));
        byte[] arr= Base64.getDecoder().decode(user.getPassword());
        String decrypted=new String(arr);
        if(!(decrypted.equals(login.getPassword()))){
            throw new UserExceptions(UserExceptions.UserErrors.INVALID_PASSWORD);
        }
        else{
            dtoUser=utils.entToDto(user);
        }
        return dtoUser;
    }

    @Override
    public UserDto updateUSer(UpdateUserDto updDto) {
        user=repo.findByEmail(updDto.getEmail())
                .orElseThrow(()->new UserExceptions(UserExceptions.UserErrors.USER_NOT_FOUND));
        user.setCode(updDto.getUserDto().getCode());
        user.setName(updDto.getUserDto().getName());
        user.setPassword(utils.passwordEncryption(updDto.getUserDto().getPassword()));
        user.setDob(utils.dateToLocaDate(updDto.getUserDto().getDob()));
        user.setAge(updDto.getUserDto().getAge());
        user=repo.save(user);
        dtoUser= utils.entToDto(user);
        return dtoUser;
    }

    @Override
    public void delUser(Long id) {
        repo.deleteById(id);

    }
}

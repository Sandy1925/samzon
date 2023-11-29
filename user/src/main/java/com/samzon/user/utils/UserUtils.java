package com.samzon.user.utils;

import com.samzon.user.dto.UserDto;
import com.samzon.user.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.awt.print.Book;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Date;
import java.util.stream.Collectors;
import java.time.LocalDate;

public class UserUtils {

    @Autowired
    private ModelMapper mapper;
    @Autowired
    private User result;
    @Autowired
    private UserDto resultDto;

    private List<UserDto> resultList=new ArrayList<>();

    public UserDto entToDto(User user){
        resultDto=mapper.map(user,UserDto.class);
        try {
            resultDto.setDob(new SimpleDateFormat("yyyy-MM-dd").parse(user.getDob().toString()));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        return resultDto;
    }

    public User dtoToEnt(UserDto userDto){
        result=mapper.map(userDto,User.class);
        return result;
    }

    public List<UserDto> listEntToDto(List<User>list){
        resultList=list.stream().map((u)->entToDto(u)).collect(Collectors.toList());
        return resultList;
    }

    public String passwordEncryption(String password){
        String encrypted=Base64.getEncoder().encodeToString(password.getBytes());
        return encrypted;
    }
    public LocalDate dateToLocaDate(Date dateToConvert){
        return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
}

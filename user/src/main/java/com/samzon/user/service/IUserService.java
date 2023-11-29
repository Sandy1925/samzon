package com.samzon.user.service;

import com.samzon.user.dto.LoginDto;
import com.samzon.user.dto.UpdateUserDto;
import com.samzon.user.dto.UserDto;

import java.util.List;

public interface IUserService {

    public UserDto newUser(UserDto userDto);
    public UserDto getById(Long id);
    public UserDto getByCode(String code);
    public UserDto getByEmail(String email);
    public List<UserDto> getAll();
    public List<UserDto> getByDob(String dob);
    public List<UserDto> getByAge(int age);
    public UserDto login(LoginDto login);
    public UserDto updateUSer(UpdateUserDto updDto);
    public void delUser(Long id);
}

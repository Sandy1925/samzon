package com.samzon.user.dto;

import com.samzon.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserDto {

    private String email;
    private UserDto userDto;
}

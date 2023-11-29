package com.samzon.user.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;
    private String code;
    private String name;
    private String email;
    private String password;
    @JsonFormat(shape= JsonFormat.Shape.STRING,pattern="yyyy-MM-dd")
    private Date dob;
    private int age;
}

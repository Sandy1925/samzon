package com.samzon.user.controller;

import com.samzon.user.dto.LoginDto;
import com.samzon.user.dto.UpdateUserDto;
import com.samzon.user.dto.UserDto;
import com.samzon.user.entity.User;
import com.samzon.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins={"http://localhost:4200","http://localhost:4201","http://localhost:4202","http://localhost:4203"} )
public class UserController {

    @Autowired
    private User result;
    @Autowired
    private UserDto resultDto;
    @Autowired
    private IUserService service;

    private List<UserDto> resultList=new ArrayList<>();

    @PostMapping("/newUser")
    public ResponseEntity newUser(@RequestBody UserDto userDto){
        resultDto=service.newUser(userDto);
        return new ResponseEntity(resultDto, HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity getById(@PathVariable Long id){
        resultDto=service.getById(id);
        return new ResponseEntity(resultDto,HttpStatus.OK);
    }

    @GetMapping("/getByCode/{code}")
    public ResponseEntity getByCode(@PathVariable String code){
        resultDto=service.getByCode(code);
        return new ResponseEntity(resultDto,HttpStatus.OK);
    }

    @GetMapping("/getByEmail/{email}")
    public ResponseEntity getByEmail(@PathVariable String email){
        resultDto=service.getByEmail(email);
        return new ResponseEntity(resultDto,HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity getAll(){
        resultList=service.getAll();
        return new ResponseEntity(resultList,HttpStatus.OK);
    }

    @GetMapping("/getByDob/{dob}")
    public ResponseEntity getByDob(@PathVariable String dob){
        resultList=service.getByDob(dob);
        return new ResponseEntity(resultList,HttpStatus.OK);
    }

    @GetMapping("/getByAge/{age}")
    public ResponseEntity getByAge(@PathVariable int age){
        resultList=service.getByAge(age);
        return new ResponseEntity(resultList,HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity loginUser(@RequestBody LoginDto loginDto){
        resultDto=service.login(loginDto);
        return new ResponseEntity(resultDto,HttpStatus.OK);
    }

    @PostMapping("/updateUser")
    public ResponseEntity updateUser(@RequestBody UpdateUserDto updDto){
        resultDto=service.updateUSer(updDto);
        return new ResponseEntity(resultDto,HttpStatus.OK);
    }

    @DeleteMapping("/delById/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id){
        service.delUser(id);
        return ResponseEntity.ok("Deleted Successfully");
    }

}

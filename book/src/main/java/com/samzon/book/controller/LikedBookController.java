package com.samzon.book.controller;

import com.samzon.book.dto.LikedBookDto;
import com.samzon.book.dto.UserLikeDto;
import com.samzon.book.entity.LikedBook;
import com.samzon.book.service.ILikedBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/likedBook")
public class LikedBookController {

    @Autowired
    private LikedBook result;
    @Autowired
    private LikedBookDto resultDto;
    @Autowired
    private ILikedBookService service;
    private List<LikedBookDto> resultList=new ArrayList<>();

    @PostMapping("/newLiked")
    public ResponseEntity newLikedBook(@RequestBody UserLikeDto userLike){
        resultDto=service.newLiked(userLike);
        return new ResponseEntity(resultDto, HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity getById(@PathVariable Long id){
        resultDto=service.getById(id);
        return new ResponseEntity(resultDto,HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity getAll(){
        resultList=service.getAll();
        return new ResponseEntity(resultList,HttpStatus.OK);
    }

    @GetMapping("/getByCode/{code}")
    public ResponseEntity getByCode(@PathVariable String code){
        resultList=service.getByCode(code);
        return new ResponseEntity(resultList,HttpStatus.OK);
    }

    @GetMapping("/getMyLikes/{email}")
    public ResponseEntity getMyLikes(@PathVariable String email){
        resultList=service.getMyLikes(email);
        return new ResponseEntity(resultList,HttpStatus.OK);
    }

    @GetMapping("getByLikedDate/{date}")
    public ResponseEntity getByLikedDate(@PathVariable String date){
        resultList=service.getByLikedDate(date);
        return new ResponseEntity(resultList,HttpStatus.OK);
    }
}

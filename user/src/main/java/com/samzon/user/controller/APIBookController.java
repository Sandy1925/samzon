package com.samzon.user.controller;

import com.samzon.user.api.IBookServiceAPI;
import com.samzon.user.dto.BookDto;
import com.samzon.user.dto.LikedBookDto;
import com.samzon.user.dto.UserLikeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user-books")
@CrossOrigin(origins="http://localhost:4203" )
public class APIBookController {

    @Autowired
    private IBookServiceAPI service;
    @Autowired
    private BookDto book;
    @Autowired
    private LikedBookDto likedBook;

    private List<BookDto> bookList=new ArrayList<>();
    private List<LikedBookDto> likedbookList=new ArrayList<>();

    @GetMapping("/getAll")
    public ResponseEntity getAll(){
        bookList=service.getAll();
        return new ResponseEntity(bookList, HttpStatus.OK);
    }

    @GetMapping("/getByAuthor/{author}")
    public ResponseEntity getByAuthor(@PathVariable String author){
        bookList=service.getByAuthor(author);
        return new ResponseEntity(bookList,HttpStatus.OK);
    }

    @GetMapping("/getByCategory/{category}")
    public ResponseEntity getByCategory(@PathVariable String category){
        bookList=service.getByCategory(category);
        return new ResponseEntity(bookList,HttpStatus.OK);
    }

    @GetMapping("/getByPublisher/{publisher}")
    public ResponseEntity getByPublisher(@PathVariable String publisher){
        bookList=service.getByPublisher(publisher);
        return new ResponseEntity(bookList,HttpStatus.OK);
    }

    @GetMapping("/getByPubDate/{pubDate}")
    public ResponseEntity getByPubDate(@PathVariable String pubDate){
        bookList=service.getByPubDate(pubDate);
        return new ResponseEntity(bookList,HttpStatus.OK);
    }

    @GetMapping("/getMyLikes/{email}")
    public ResponseEntity getMyLikes(@PathVariable String email){
        likedbookList=service.myLikes(email);
        return new ResponseEntity(likedbookList,HttpStatus.OK);
    }

    @PostMapping("/newLiked")
    public ResponseEntity newLiked(@RequestBody UserLikeDto userLike){
        likedBook=service.likeABook(userLike);
        return new ResponseEntity(likedBook,HttpStatus.OK);
    }

}

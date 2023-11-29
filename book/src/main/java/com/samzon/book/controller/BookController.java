package com.samzon.book.controller;

import com.samzon.book.dto.BookDto;
import com.samzon.book.dto.UpdateBookDto;
import com.samzon.book.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.config.RepositoryNameSpaceHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private IBookService service;
    @Autowired
    private BookDto dtoBook;

    private List<BookDto> result=new ArrayList<>();

    @PostMapping("/newBook")
    public ResponseEntity newBook(@RequestBody BookDto bookDto){
        dtoBook=service.newBook(bookDto);
        return new ResponseEntity(dtoBook, HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity getById(@PathVariable Long id){
        dtoBook=service.getById(id);
        return new ResponseEntity(dtoBook,HttpStatus.OK);
    }

    @GetMapping("/getByCode/{code}")
    public ResponseEntity getByCode(@PathVariable String code){
        dtoBook=service.getByCode(code);
        return new ResponseEntity(dtoBook,HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity getAll(){
        result=service.getAll();
        return new ResponseEntity(result,HttpStatus.OK);
    }

    @GetMapping("/getByAuthor/{author}")
    public ResponseEntity getByAuthor(@PathVariable String author){
        result=service.getByAuthor(author);
        return new ResponseEntity(result,HttpStatus.OK);
    }

    @GetMapping("/getByCategory/{category}")
    public ResponseEntity getByCategory(@PathVariable String category){
        result=service.getbyCategory(category);
        return new ResponseEntity(result,HttpStatus.OK);
    }

    @GetMapping("/getByPublisher/{publisher}")
    public ResponseEntity getByPublisher(@PathVariable String publisher){
        result=service.getByPublisher(publisher);
        return new ResponseEntity(result,HttpStatus.OK);
    }

    @GetMapping("/getByPubDate/{pubDate}")
    public ResponseEntity getByPubDate(@PathVariable String pubDate){
        result=service.getByPubDate(pubDate);
        return new ResponseEntity(result,HttpStatus.OK);
    }

    @PostMapping("/updateBook")
    public ResponseEntity updateBook(@RequestBody UpdateBookDto upd){
        dtoBook=service.updateBook(upd.getCode(),upd.getBookDto());
        return new ResponseEntity(dtoBook,HttpStatus.OK);
    }

    @DeleteMapping("/delBook/{id}")
    public ResponseEntity deleteBook(@PathVariable Long id){
        service.delBook(id);
        return ResponseEntity.ok("Deleted Successfully");
    }



}

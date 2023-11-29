package com.samzon.book.exception;

import com.samzon.book.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private String message="";
    private String code="";
    private HttpStatus status= HttpStatus.BAD_REQUEST;

    @Autowired
    private CommonUtils commUtils;
    ErrorDetails error=new ErrorDetails();


    @ExceptionHandler(BooksException.class)
    public ResponseEntity handleBooksException(BooksException be, WebRequest request){
        switch(be.getMessage()){
            case ("BOOK_NOT_FOUND"):{
                message="Book Not found for the given id or code";
                code="BOOK_NOT_FOUND";
                status=HttpStatus.NOT_FOUND;
                break;
            }
            case("BOOK_ALREADY_EXISTS"):{
                message="Book Already exists wih the given id or code";
                code="BOOK_ALREADY_EXISTS";
                status=HttpStatus.BAD_REQUEST;
                break;
            }
            case("LIKED_BOOK_NOT_FOUND"):{
                message="Likedbook not found with given id or code";
                code="LIKED_BOOK_NOT_FOUND";
                status=HttpStatus.NOT_FOUND;
                break;
            }
            case("ALREADY_LIKED"):{
                message="Already Liked this book";
                code="ALREADY_LIKED";
                status=HttpStatus.BAD_REQUEST;
                break;
            }
        }
        error=commUtils.getError(message,request.getDescription(false),code);
        return new ResponseEntity(error,status);
    }
}

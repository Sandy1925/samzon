package com.samzon.user.exceptions;

import com.samzon.user.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private ErrorDetails error;
    @Autowired
    private CommonUtils commUtils;

    private String message="";
    private String  path="";
    private HttpStatus status=HttpStatus.BAD_REQUEST;
    private String code="";


    @ExceptionHandler(UserExceptions.class)
    public ResponseEntity handleUserException(UserExceptions ex, WebRequest request){
        switch(ex.getMessage()){
            case ("INVALID_PASSWORD"):{
                message="Please Check Your Password";
                path=request.getDescription(false);
                status=HttpStatus.BAD_REQUEST;
                code="INVALID_USER";
                break;
            }

            case("USER_NOT_FOUND"):{
                message="User not found for the given email or code ";
                code="USER_NOT_FOUND";
                path=request.getDescription(false);
                status=HttpStatus.NOT_FOUND;
                break;
            }
            case("USER_ALREADY_EXISTS"):{
                message="USer Already Exists with teh given email or code";
                code="USER_ALREADY_EXISTS";
                path=request.getDescription(false);
                status=HttpStatus.BAD_REQUEST;
                break;
            }
        }
        error=commUtils.getError(message,path,code);
        return new ResponseEntity(error,status);
    }
}

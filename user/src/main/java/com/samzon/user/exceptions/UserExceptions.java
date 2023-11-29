package com.samzon.user.exceptions;

public class UserExceptions extends RuntimeException{

    public enum UserErrors{
        INVALID_PASSWORD,
        USER_NOT_FOUND,
        USER_ALREADY_EXISTS
    }

    public UserExceptions(UserErrors err){
        super(err.name());
    }
}

package com.samzon.book.exception;

public class BooksException extends RuntimeException{

    public enum BookErrors{
        BOOK_NOT_FOUND,
        BOOK_ALREADY_EXISTS,
        LIKED_BOOK_NOT_FOUND,
        ALREADY_LIKED
    }

    public BooksException(BookErrors err){
        super(err.name());
    }
}

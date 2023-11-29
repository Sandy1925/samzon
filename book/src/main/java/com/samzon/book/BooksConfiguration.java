package com.samzon.book;

import com.samzon.book.dto.BookDto;
import com.samzon.book.dto.LikedBookDto;
import com.samzon.book.entity.Book;
import com.samzon.book.entity.LikedBook;
import com.samzon.book.exception.ErrorDetails;
import com.samzon.book.utils.BookUtils;
import com.samzon.book.utils.CommonUtils;
import com.samzon.book.utils.LikedBookUtils;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BooksConfiguration {

    @Bean
    public Book getBook(){
        return new Book();
    }
    @Bean
    public BookDto getBookDto(){
        return new BookDto();
    }

    @Bean
    public ModelMapper getMapper(){
        return new ModelMapper();
    }

    @Bean
    public CommonUtils getCommUtils(){
        return new CommonUtils();
    }

    @Bean
    public BookUtils getBookUtils(){
        return new BookUtils();
    }

    @Bean
    public ErrorDetails getError(){
        return new ErrorDetails();
    }

    @Bean
    public LikedBook getLiked(){
        return new LikedBook();
    }

    @Bean
    public LikedBookDto getLikedDto(){
        return new LikedBookDto();
    }

    @Bean
    public LikedBookUtils getLikedUtils(){
        return new LikedBookUtils();
    }
}

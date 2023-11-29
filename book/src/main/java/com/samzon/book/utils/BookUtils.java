package com.samzon.book.utils;

import com.samzon.book.dto.BookDto;
import com.samzon.book.entity.Book;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookUtils {

    @Autowired
    private ModelMapper mapper;
    @Autowired
    private Book result;
    @Autowired
    private BookDto resultDto;

    private List<BookDto> resultList=new ArrayList<>();

    public BookDto entToDto(Book book){
        resultDto=mapper.map(book,BookDto.class);
        return resultDto;
    }

    public Book dtoToEnt(BookDto bookDto){
        result=mapper.map(bookDto,Book.class);
        return result;
    }

    public List<BookDto> listEntToDto(List<Book> data){
        resultList=data.stream().map((b)->mapper.map(b,BookDto.class)).collect(Collectors.toList());
        return resultList;
    }

    public boolean checkAlreadyExists(String code,List<String> list){
        boolean result=false;
        try {
            result = true ? (list.contains(code)) : false;
        }catch (Exception e){
            result=false;
        }
       return result;
    }

}

package com.samzon.book.utils;

import com.samzon.book.dto.BookDto;
import com.samzon.book.dto.LikedBookDto;
import com.samzon.book.dto.UserLikeDto;
import com.samzon.book.entity.Book;
import com.samzon.book.entity.LikedBook;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LikedBookUtils {

    @Autowired
    private ModelMapper mapper;
    @Autowired
    private LikedBook result;
    @Autowired
    private LikedBookDto resultDto;
    @Autowired
    private BookUtils bookUtils;
    @Autowired
    private BookDto bookDto;
    @Autowired
    private Book book;

    private List<LikedBookDto>resultlist=new ArrayList<>();

    public LikedBookDto entToDto(LikedBook data){
        bookDto=bookUtils.entToDto(data.getBook());
        resultDto=mapper.map(data,LikedBookDto.class);
        resultDto.setBookDto(bookDto);
        return resultDto;
    }

    public LikedBook dtoToEnt(LikedBookDto data){
        book=bookUtils.dtoToEnt(data.getBookDto());
        result=mapper.map(data,LikedBook.class);
        result.setBook(book);
        return result;
    }

    public List<LikedBookDto> listEntToDto(List<LikedBook>list){
        resultlist=list.stream()
                .map((lb)->entToDto(lb))
                .collect(Collectors.toList());
        return resultlist;
    }

    public boolean isAlreadyLiked(String bookCode,List<LikedBook>list){
        boolean result=false;
        for(LikedBook lb:list){
            if(lb.getBook().getCode().equals(bookCode)){
                result=true;
                break;
            }
        }
        return result;

    }
}

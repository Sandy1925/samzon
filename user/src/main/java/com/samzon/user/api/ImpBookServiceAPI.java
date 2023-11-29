package com.samzon.user.api;

import com.samzon.user.dto.BookDto;
import com.samzon.user.dto.LikedBookDto;
import com.samzon.user.dto.UserLikeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.awt.print.Book;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ImpBookServiceAPI implements IBookServiceAPI {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private BookDto bookDto;
    @Autowired
    private LikedBookDto likedBookDto;

    private List<BookDto> bookList=new ArrayList<>();
    private List<LikedBookDto> likedBookList=new ArrayList<>();
    private BookDto[] bookArr;
    private LikedBookDto[] likedArr;

    private String bookUrl="http://localhost:8989/books/";
    private String likedBookUrl="http://localhost:8989/likedBook/";


    @Override
    public List<BookDto> getAll() {
        bookArr=restTemplate.getForObject(bookUrl+"getAll",BookDto[].class);
        bookList= Arrays.asList(bookArr);
        return bookList;
    }

    @Override
    public List<BookDto> getByAuthor(String author) {

        bookArr = restTemplate.getForObject(bookUrl+"getByAuthor/"+author, BookDto[].class);
        bookList = Arrays.asList(bookArr);
        return bookList;
    }

    @Override
    public List<BookDto> getByCategory(String category) {
        bookArr=restTemplate.getForObject(bookUrl+"getByCategory/"+category,BookDto[].class);
        bookList=Arrays.asList(bookArr);
        return bookList;
    }

    @Override
    public List<BookDto> getByPublisher(String publisher) {
        bookArr=restTemplate.getForObject(bookUrl+"getByPublisher/"+publisher,BookDto[].class);
        bookList=Arrays.asList(bookArr);
        return bookList;
    }

    @Override
    public List<BookDto> getByPubDate(String pubDate) {
        bookArr=restTemplate.getForObject(bookUrl+"getByPubDate/"+pubDate,BookDto[].class);
        bookList=Arrays.asList(bookArr);
        return bookList;
    }

    @Override
    public LikedBookDto likeABook(UserLikeDto userLike) {
        likedBookDto=restTemplate.postForEntity(likedBookUrl+"newLiked",userLike,LikedBookDto.class).getBody();
        return likedBookDto;
    }

    @Override
    public List<LikedBookDto> myLikes(String email) {
        likedArr=restTemplate.getForObject(likedBookUrl+"getMyLikes/"+email,LikedBookDto[].class);
        likedBookList=Arrays.asList(likedArr);
        return likedBookList;
    }
}

package com.samzon.book.service;

import com.samzon.book.dto.LikedBookDto;
import com.samzon.book.dto.UserLikeDto;
import com.samzon.book.entity.Book;
import com.samzon.book.entity.LikedBook;
import com.samzon.book.exception.BooksException;
import com.samzon.book.repository.IBookRepository;
import com.samzon.book.repository.ILikedBookRepository;
import com.samzon.book.utils.CommonUtils;
import com.samzon.book.utils.LikedBookUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ImpLikedBookService implements ILikedBookService{
@Autowired
private LikedBook result;
@Autowired
private LikedBookDto resultDto;
@Autowired
private CommonUtils commUtils;
@Autowired
private LikedBookUtils utils;
@Autowired
private ILikedBookRepository repo;
@Autowired
private Book book;
@Autowired
private IBookRepository bookRepo;

private List<LikedBook> likedList=new ArrayList<>();
private List<LikedBookDto>likedDtoList=new ArrayList<>();


    @Override
    public LikedBookDto newLiked(UserLikeDto userLike) {
        LikedBook obj =new LikedBook();
        book=bookRepo.findByCode(userLike.getBookCode())
                .orElseThrow(()->new BooksException(BooksException.BookErrors.BOOK_NOT_FOUND));
        List<LikedBook> list=repo.findAllByUserEmail(userLike.getUserEmail());
        if(utils.isAlreadyLiked(userLike.getBookCode(),list)){
            throw new BooksException(BooksException.BookErrors.ALREADY_LIKED);
        }
        obj.setCode("L-"+userLike.getBookCode());
        obj.setBook(book);
        obj.setUserEmail(userLike.getUserEmail());
        obj.setLikedDate(LocalDate.now());
        obj=repo.save(obj);
        resultDto=utils.entToDto(obj);
        return resultDto;
    }

    @Override
    public LikedBookDto getById(Long id) {

        result=repo.findById(id).orElseThrow(()->new BooksException(BooksException.BookErrors.LIKED_BOOK_NOT_FOUND));
        resultDto=utils.entToDto(result);
        return resultDto;
    }

    @Override
    public List<LikedBookDto> getAll() {
        likedList=repo.findAll();
        likedDtoList=utils.listEntToDto(likedList);
        return likedDtoList;
    }

    @Override
    public List<LikedBookDto> getByCode(String code) {
        likedList=repo.findAllByCode(code);
        likedDtoList=utils.listEntToDto(likedList);
        return likedDtoList;
    }

    @Override
    public List<LikedBookDto> getMyLikes(String email) {
        likedList=repo.findAllByUserEmail(email);
        likedDtoList=utils.listEntToDto(likedList);
        return likedDtoList;
    }

    @Override
    public List<LikedBookDto> getByLikedDate(String likedOn) {
        LocalDate date=commUtils.stringToDate(likedOn);
        likedList=repo.findAllByLikedDate(date);
        likedDtoList=utils.listEntToDto(likedList);
        return likedDtoList;
    }
}

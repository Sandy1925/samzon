package com.samzon.book.service;

import com.samzon.book.dto.BookDto;
import com.samzon.book.entity.Book;
import com.samzon.book.exception.BooksException;
import com.samzon.book.repository.IBookRepository;
import com.samzon.book.utils.BookUtils;
import com.samzon.book.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImpBookService implements IBookService{

    @Autowired
    private Book book;
    @Autowired
    private BookDto dtoBook;
    @Autowired
    private IBookRepository repo;
    @Autowired
    private CommonUtils commUtils;
    @Autowired
    private BookUtils utils;

    private List<Book> bookList=new ArrayList<>();
    private List<BookDto> bookDtoList=new ArrayList<>();

    @Override
    public BookDto newBook(BookDto bookDto) {
        if(utils.checkAlreadyExists(bookDto.getCode(),repo.findAll()
                .stream().map((b)->b.getCode())
                .collect(Collectors.toList()))){
            throw new BooksException(BooksException.BookErrors.BOOK_ALREADY_EXISTS);
        }
        Book obj=new Book();
        obj.setTitle(bookDto.getTitle());
        obj.setAuthor(bookDto.getAuthor());
        obj.setCode(bookDto.getCode());
        obj.setCategory(bookDto.getCategory());
        obj.setPublisher(bookDto.getPublisher());
        obj.setPubDate(bookDto.getPubDate());
        obj.setFare(bookDto.getFare());
        obj=repo.save(obj);
        dtoBook=utils.entToDto(obj);
        return dtoBook;
    }

    @Override
    public BookDto getById(Long id) {
        book=repo.findById(id).orElseThrow(()->new BooksException(BooksException.BookErrors.BOOK_NOT_FOUND));
        dtoBook=utils.entToDto(book);
        return dtoBook;
    }

    @Override
    public BookDto getByCode(String code) {
        book=repo.findByCode(code).orElseThrow(()->new BooksException(BooksException.BookErrors.BOOK_NOT_FOUND));
        dtoBook=utils.entToDto(book);
        return dtoBook;
    }

    @Override
    public List<BookDto> getAll() {
        bookList=repo.findAll();
        bookDtoList=utils.listEntToDto(bookList);
        return bookDtoList;
    }

    @Override
    public List<BookDto> getByAuthor(String author) {
        bookList=repo.findAllByAuthor(author);
        bookDtoList=utils.listEntToDto(bookList);
        return bookDtoList;
    }

    @Override
    public List<BookDto> getbyCategory(String category) {
        bookList=repo.findAllByCategory(category);
        bookDtoList=utils.listEntToDto(bookList);
        return bookDtoList;
    }

    @Override
    public List<BookDto> getByPublisher(String publisher) {
        bookList=repo.findAllByPublisher(publisher);
        bookDtoList=utils.listEntToDto(bookList);
        return bookDtoList;
    }

    @Override
    public List<BookDto> getByPubDate(String date) {
        LocalDate pubDate=commUtils.stringToDate(date);
        bookList=repo.findAllByPubDate(pubDate);
        bookDtoList=utils.listEntToDto(bookList);
        return bookDtoList;
    }

    @Override
    public BookDto updateBook(String code, BookDto bookDto) {
        book=repo.findByCode(code).orElseThrow(()->new BooksException(BooksException.BookErrors.BOOK_NOT_FOUND));
        book.setTitle(bookDto.getTitle());
        book.setCode(bookDto.getCode());
        book.setCategory(bookDto.getCategory());
        book.setAuthor(bookDto.getAuthor());
        book.setPublisher(bookDto.getPublisher());
        book.setPubDate(bookDto.getPubDate());
        book.setFare(bookDto.getFare());
        book.setImgUrl("./assets/"+book.getCode()+".jpeg");
        book=repo.save(book);
        dtoBook=utils.entToDto(book);
        return dtoBook;
    }

    @Override
    public void delBook(Long id) {
        repo.deleteById(id);
    }
}

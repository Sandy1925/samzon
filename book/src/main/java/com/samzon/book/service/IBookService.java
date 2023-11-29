package com.samzon.book.service;

import com.samzon.book.dto.BookDto;

import java.util.List;

public interface IBookService {

    public BookDto newBook(BookDto bookDto);
    public BookDto getById(Long id);
    public BookDto getByCode(String code);
    public List<BookDto>getAll();
    public List<BookDto> getByAuthor(String author);
    public List<BookDto> getbyCategory(String category);
    public List<BookDto>getByPublisher(String publisher);
    public List<BookDto>getByPubDate(String date);
    public BookDto updateBook(String code,BookDto bookDto);
    public void delBook(Long id);
}

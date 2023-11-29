package com.samzon.book.repository;

import com.samzon.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface IBookRepository extends JpaRepository<Book,Long> {

    public Optional<Book> findByCode(String code);
    public List<Book> findAllByAuthor(String author);
    public List<Book> findAllByCategory(String category);
    public List<Book> findAllByPublisher(String publisher);
    public List<Book> findAllByPubDate(LocalDate date);
}

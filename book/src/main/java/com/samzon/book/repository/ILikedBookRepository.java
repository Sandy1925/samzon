package com.samzon.book.repository;

import com.samzon.book.entity.LikedBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ILikedBookRepository extends JpaRepository<LikedBook,Long> {

    public List<LikedBook> findAllByUserEmail(String email);
    public List<LikedBook> findAllByCode(String code);
    public List<LikedBook> findAllByLikedDate(LocalDate likedDate);
}

package com.samzon.book.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable=true)
    private String title;
    @Column(nullable=true)
    private String code;
    @Column(nullable=true)
    private String author;
    @Column(nullable=true)
    private String category;
    @Column(nullable=true)
    private String publisher;
    @Column(nullable=true)
    private LocalDate pubDate;
    @Column(nullable=true)
    private double fare;
    @Column
    private String imgUrl;
}

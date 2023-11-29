package com.samzon.book.entity;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LikedBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable=true)
    private String code;
    @Column(nullable=true)
    private String userEmail;
    @OneToOne(cascade = CascadeType.MERGE)
    private Book book;
    @Column(nullable=true)
    private LocalDate likedDate;
}

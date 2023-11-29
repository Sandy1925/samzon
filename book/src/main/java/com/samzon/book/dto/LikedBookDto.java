package com.samzon.book.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.samzon.book.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LikedBookDto {

    private Long id;
    private String code;
    private String userEmail;
    private BookDto bookDto;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern="yyyy-MM-dd")
    private LocalDate likedDate;
}

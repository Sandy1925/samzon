package com.samzon.book.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {


    private Long id;

    private String title;

    private String code;

    private String author;

    private String category;

    private String publisher;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyy-MM-dd")
    private LocalDate pubDate;

    private double fare;
    private String imgUrl;
}

package com.samzon.user.api;

import com.samzon.user.dto.BookDto;
import com.samzon.user.dto.LikedBookDto;
import com.samzon.user.dto.UserLikeDto;

import java.awt.print.Book;
import java.util.List;

public interface IBookServiceAPI {

    public List<BookDto> getAll();
    public List<BookDto> getByAuthor(String author);
    public List<BookDto> getByCategory(String category);
    public List<BookDto> getByPublisher(String publisher);
    public List<BookDto>getByPubDate(String pubDate);
    public LikedBookDto likeABook(UserLikeDto userLike);
    public List<LikedBookDto> myLikes(String email);

}

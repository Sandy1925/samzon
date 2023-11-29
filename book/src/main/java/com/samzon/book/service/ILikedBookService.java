package com.samzon.book.service;

import com.samzon.book.dto.LikedBookDto;
import com.samzon.book.dto.UserLikeDto;

import java.util.List;

public interface ILikedBookService {

    public LikedBookDto newLiked(UserLikeDto userLike);
    public LikedBookDto getById(Long id);
    public List<LikedBookDto> getAll();
    public List<LikedBookDto> getByCode(String code);
    public List<LikedBookDto> getMyLikes(String email);
    public List<LikedBookDto> getByLikedDate(String likedOn);
}

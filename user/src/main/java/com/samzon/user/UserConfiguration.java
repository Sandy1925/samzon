package com.samzon.user;


import com.samzon.user.dto.BookDto;
import com.samzon.user.dto.LikedBookDto;
import com.samzon.user.dto.UserDto;
import com.samzon.user.dto.UserLikeDto;
import com.samzon.user.entity.User;
import com.samzon.user.exceptions.ErrorDetails;
import com.samzon.user.utils.CommonUtils;
import com.samzon.user.utils.UserUtils;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class UserConfiguration {

    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }

    @Bean
    public ErrorDetails getError(){
        return new ErrorDetails();
    }
    @Bean
    public CommonUtils getCommUtils(){
        return new CommonUtils();
    }

    @Bean
    public User getUser(){
        return new User();
    }

    @Bean
    public UserDto getUserDto(){
        return new UserDto();
    }

    @Bean
    public UserUtils getUserUtils(){
        return new UserUtils();
    }

    @Bean
    public BookDto getBookDto(){
        return new BookDto();
    }

    @Bean
    public LikedBookDto getLikedBookDto(){
        return new LikedBookDto();
    }

    @Bean
    public UserLikeDto getUserLikeDto(){
        return new UserLikeDto();
    }

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}

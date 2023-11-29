package com.samzon.user.utils;

import com.samzon.user.exceptions.ErrorDetails;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class CommonUtils {

    @Autowired
    private ErrorDetails error;
    public LocalDate stringToDate(String date){
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
        LocalDate retDate= LocalDate.parse(date,formatter);
        return retDate;
    }

    public ErrorDetails getError(String message,String path,String code){
        error.setMessage(message);
        error.setCode(code);
        error.setPath(path);
        error.setTimeStamp(LocalDateTime.now());
        return error;

    }
}

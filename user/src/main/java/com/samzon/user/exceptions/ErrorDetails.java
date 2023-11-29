package com.samzon.user.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetails {

    private String message;
    private String path;
    private String code;
    private LocalDateTime timeStamp;
}

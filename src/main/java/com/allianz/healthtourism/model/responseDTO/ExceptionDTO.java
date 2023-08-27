package com.allianz.healthtourism.model.responseDTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ExceptionDTO {
    private LocalDateTime timeStamp;
    private Integer statusCode;
    private String message;
    private String exceptionName;
}

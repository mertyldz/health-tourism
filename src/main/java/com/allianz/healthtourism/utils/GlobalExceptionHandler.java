package com.allianz.healthtourism.utils;

import com.allianz.healthtourism.exceptions.RecordNotFoundException;
import com.allianz.healthtourism.model.responseDTO.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<ExceptionDTO> handleNullPointer(RecordNotFoundException exception) {
        ExceptionDTO exceptionDTO = new ExceptionDTO();
        exceptionDTO.setExceptionName("Record Not Found");
        exceptionDTO.setStatusCode(HttpStatus.NOT_FOUND.value());
        exceptionDTO.setMessage(exception.getMessage());
        exceptionDTO.setTimeStamp(LocalDateTime.now());
        return new ResponseEntity<>(exceptionDTO, HttpStatus.INTERNAL_SERVER_ERROR);

    }
}

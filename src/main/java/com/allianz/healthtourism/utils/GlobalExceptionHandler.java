package com.allianz.healthtourism.utils;

import com.allianz.healthtourism.exceptions.CapacityException;
import com.allianz.healthtourism.exceptions.OrderException;
import com.allianz.healthtourism.exceptions.PaymentException;
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

    @ExceptionHandler(CapacityException.class)
    public ResponseEntity<ExceptionDTO> handleCapacity(CapacityException exception) {
        ExceptionDTO exceptionDTO = new ExceptionDTO();
        exceptionDTO.setExceptionName("Full Capacity!");
        exceptionDTO.setStatusCode(HttpStatus.BAD_REQUEST.value());
        exceptionDTO.setMessage(exception.getMessage());
        exceptionDTO.setTimeStamp(LocalDateTime.now());
        return new ResponseEntity<>(exceptionDTO, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(OrderException.class)
    public ResponseEntity<ExceptionDTO> handleOrder(OrderException exception) {
        ExceptionDTO exceptionDTO = new ExceptionDTO();
        exceptionDTO.setExceptionName("Order Exception!");
        exceptionDTO.setStatusCode(HttpStatus.BAD_REQUEST.value());
        exceptionDTO.setMessage(exception.getMessage());
        exceptionDTO.setTimeStamp(LocalDateTime.now());
        return new ResponseEntity<>(exceptionDTO, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(PaymentException.class)
    public ResponseEntity<ExceptionDTO> handlePayment(PaymentException exception) {
        ExceptionDTO exceptionDTO = new ExceptionDTO();
        exceptionDTO.setExceptionName("Payment Exception!");
        exceptionDTO.setStatusCode(HttpStatus.BAD_REQUEST.value());
        exceptionDTO.setMessage(exception.getMessage());
        exceptionDTO.setTimeStamp(LocalDateTime.now());
        return new ResponseEntity<>(exceptionDTO, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

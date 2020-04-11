package com.example.demo.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class AnswerValidationExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(WrongAnswerFoundException.class)
    public ResponseEntity<CustomErrorResponse> wrongAnswerHandleFound(Exception ex, WebRequest request) {

        CustomErrorResponse errors = new CustomErrorResponse();
        errors.setTimestamp(LocalDateTime.now());
        errors.setError("Question and answer is not matching please try with other answer");
        errors.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());
        return new ResponseEntity<>(errors, HttpStatus.UNPROCESSABLE_ENTITY);

    }

}
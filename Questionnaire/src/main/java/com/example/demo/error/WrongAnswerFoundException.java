package com.example.demo.error;

public class WrongAnswerFoundException  extends RuntimeException {

    public WrongAnswerFoundException(Long id) {
        super("Not a valid answer");
    }

}

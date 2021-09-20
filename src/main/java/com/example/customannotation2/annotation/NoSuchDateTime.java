package com.example.customannotation2.annotation;

public class NoSuchDateTime extends RuntimeException {
    public NoSuchDateTime(String message) {
        super(message);
    }
}

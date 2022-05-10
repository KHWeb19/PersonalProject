package com.example.demo.exceptions;

public class ProductNotExistsException extends IllegalArgumentException{
    public ProductNotExistsException(String msg) {
        super(msg);
    }
}

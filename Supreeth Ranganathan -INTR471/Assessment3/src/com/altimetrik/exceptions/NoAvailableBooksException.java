package com.altimetrik.exceptions;

public class NoAvailableBooksException extends Exception {
    String message;

    public NoAvailableBooksException(String message) {
        this.message = message;
        System.out.println(message);
    }
}

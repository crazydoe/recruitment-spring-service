package com.michal.simpleCrudApplication.exception;

public class InvalidOperationException extends RuntimeException {

    public InvalidOperationException(String mssg) {
        super(mssg);
    }
}

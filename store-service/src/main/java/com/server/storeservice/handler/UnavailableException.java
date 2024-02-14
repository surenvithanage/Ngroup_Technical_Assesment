package com.server.storeservice.handler;

public class UnavailableException extends RuntimeException {
    public UnavailableException(String message) {
        super(message);
    }
}
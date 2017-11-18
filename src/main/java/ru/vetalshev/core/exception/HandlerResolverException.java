package ru.vetalshev.core.exception;

public class HandlerResolverException extends RuntimeException {

    public HandlerResolverException(String message) {
        super(message);
    }

    public HandlerResolverException(String message, Throwable cause) {
        super(message, cause);
    }
}

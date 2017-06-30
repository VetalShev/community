package ru.vetalshev.view.exception;

public class ViewResolverException extends RuntimeException {

    public ViewResolverException(String message) {
        super(message);
    }

    public ViewResolverException(String message, Throwable cause) {
        super(message, cause);
    }
}

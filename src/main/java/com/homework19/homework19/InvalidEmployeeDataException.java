package com.homework19.homework19;

public class InvalidEmployeeDataException extends RuntimeException{
    public InvalidEmployeeDataException() {
    }

    public InvalidEmployeeDataException(String message) {
        super(message);
    }

    public InvalidEmployeeDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidEmployeeDataException(Throwable cause) {
        super(cause);
    }

    public InvalidEmployeeDataException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

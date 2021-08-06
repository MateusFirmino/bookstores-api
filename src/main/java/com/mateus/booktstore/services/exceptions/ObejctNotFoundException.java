package com.mateus.booktstore.services.exceptions;

public class ObejctNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ObejctNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ObejctNotFoundException(String cause) {
        super(cause);
    }
}

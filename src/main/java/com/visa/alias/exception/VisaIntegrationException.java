package com.visa.alias.exception;

public class VisaIntegrationException
        extends RuntimeException {

    public VisaIntegrationException(String message) {
        super(message);
    }

    public VisaIntegrationException(
            String message,
            Throwable cause) {

        super(message, cause);
    }
}
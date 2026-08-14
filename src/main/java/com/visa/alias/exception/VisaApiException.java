package com.visa.alias.exception;

import java.util.List;

public class VisaApiException extends RuntimeException {

    private final int status;
    private final String errorCode;
    private final List<String> errorMessages;

    public VisaApiException(
            int status,
            String errorCode,
            List<String> errorMessages) {

        super(
                errorMessages != null && !errorMessages.isEmpty()
                        ? errorMessages.getFirst()
                        : "Visa API Error");

        this.status = status;
        this.errorCode = errorCode;
        this.errorMessages = errorMessages;
    }

    public int getStatus() {
        return status;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public List<String> getErrorMessages() {
        return errorMessages;
    }
}
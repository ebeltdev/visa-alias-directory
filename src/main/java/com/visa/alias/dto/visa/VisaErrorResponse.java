package com.visa.alias.dto.visa;

import java.util.List;

public record VisaErrorResponse(
        String errorCode,
        List<String> errorMessages) {
}
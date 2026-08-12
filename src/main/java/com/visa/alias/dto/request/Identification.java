package com.visa.alias.dto.request;

import jakarta.validation.Valid;

public record Identification(

        String type,

        String value,

        @Valid
        VerificationDetails verificationDetails
) {
}
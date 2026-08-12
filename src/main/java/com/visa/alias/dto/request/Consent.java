package com.visa.alias.dto.request;

import jakarta.validation.constraints.NotBlank;

public record Consent(

        @NotBlank(message = "consent.presenter is required")
        String presenter,

        @NotBlank(message = "consent.validFromDateTime is required")
        String validFromDateTime,

        @NotBlank(message = "consent.version is required")
        String version,

        String expiryDateTime,

        java.util.List<String> intermediaries
) {
}
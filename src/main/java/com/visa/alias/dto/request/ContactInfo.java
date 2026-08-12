package com.visa.alias.dto.request;

import jakarta.validation.constraints.NotBlank;

public record ContactInfo(

        @NotBlank(message = "contactInfo.type is required")
        String type,

        @NotBlank(message = "contactInfo.value is required")
        String value
) {
}
package com.visa.alias.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record UpdateAliasStatusRequest(

        @NotBlank(message = "status is required")
        @Pattern(
                regexp = "^(ACTIVE|DISABLED)$",
                message = "status must be ACTIVE or DISABLED"
        )
        String status

) {
}
package com.visa.alias.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record UpdateAliasRequest(

        @NotNull(message = "consent is required")
        @Valid
        Consent consent,

        @NotNull(message = "profile is required")
        @Valid
        Profile profile,

        @Valid
        Identification identification

) {
}
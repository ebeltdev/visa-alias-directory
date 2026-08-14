package com.visa.alias.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record CreateAliasRequest(

        @NotBlank(message = "aliasType is required")
        String aliasType,

        @NotBlank(message = "aliasValue is required")
        String aliasValue,

        @NotNull(message = "consent is required")
        @Valid
        Consent consent,

        @NotEmpty(message = "paymentCredentials is required")
        List<@Valid PaymentCredential> paymentCredentials,

        @NotNull(message = "profile is required")
        @Valid
        Profile profile,

        String externalId,

        @Valid
        Identification identification
) {
}
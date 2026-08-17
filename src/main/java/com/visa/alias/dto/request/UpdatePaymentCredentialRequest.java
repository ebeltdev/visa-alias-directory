package com.visa.alias.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.List;

public record UpdatePaymentCredentialRequest(

        @NotNull(message = "billingAddress is required")
        @Valid
        BillingAddress billingAddress,

        @NotBlank(message = "expirationDate is required")
        @Pattern(
                regexp = "^\\d{4}-\\d{2}$",
                message = "expirationDate must use YYYY-MM format"
        )
        String expirationDate,

        @NotBlank(message = "nameOnCard is required")
        @Size(
                min = 1,
                max = 120,
                message = "nameOnCard must have between 1 and 120 characters"
        )
        String nameOnCard,

        @NotBlank(message = "type is required")
        String type,

        @Size(min = 1, max = 70)
        String cardType,

        @Size(min = 3, max = 3)
        String currencyCode,

        @Size(min = 1, max = 100)
        String externalId,

        @Size(min = 1, max = 150)
        String issuerName,

        List<@Valid PreferredFor> preferredFor

) {
}
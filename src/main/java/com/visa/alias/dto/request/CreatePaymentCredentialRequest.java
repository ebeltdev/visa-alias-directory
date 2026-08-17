package com.visa.alias.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.List;

public record CreatePaymentCredentialRequest(

        @NotBlank(message = "accountNumber is required")
        @Size(min = 12, max = 19, message = "accountNumber must have between 12 and 19 characters")
        @Pattern(regexp = "^\\d*$", message = "accountNumber must contain only digits")
        String accountNumber,

        @NotNull(message = "billingAddress is required")
        @Valid
        BillingAddress billingAddress,

        @NotBlank(message = "cardType is required")
        @Size(min = 1, max = 70)
        String cardType,

        @NotBlank(message = "expirationDate is required")
        String expirationDate,

        @NotBlank(message = "issuerName is required")
        @Size(min = 1, max = 150)
        String issuerName,

        @NotBlank(message = "nameOnCard is required")
        @Size(min = 1, max = 120)
        String nameOnCard,

        @NotBlank(message = "type is required")
        String type,

        @Size(min = 3, max = 3)
        String currencyCode,

        @Size(min = 1, max = 100)
        String externalId,

        List<@Valid PreferredFor> preferredFor
) {
}
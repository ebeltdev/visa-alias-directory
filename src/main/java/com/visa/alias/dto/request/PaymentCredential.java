package com.visa.alias.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PaymentCredential(

        @NotBlank(message = "paymentCredentials.accountNumber is required")
        String accountNumber,

        @NotNull(message = "paymentCredentials.billingAddress is required")
        @Valid
        BillingAddress billingAddress,

        @NotBlank(message = "paymentCredentials.cardType is required")
        String cardType,

        @NotBlank(message = "paymentCredentials.expirationDate is required")
        String expirationDate,

        @NotBlank(message = "paymentCredentials.issuerName is required")
        String issuerName,

        @NotBlank(message = "paymentCredentials.nameOnCard is required")
        String nameOnCard,

        @NotBlank(message = "paymentCredentials.type is required")
        String type,

        String externalId,

        java.util.List<@Valid PreferredFor> preferredFor
) {
}
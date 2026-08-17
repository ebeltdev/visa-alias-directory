package com.visa.alias.integration.visa.alias.dto;

import java.util.List;

public record VisaCreatePaymentCredentialRequest(

        String accountNumber,

        VisaBillingAddress billingAddress,

        String cardType,

        String expirationDate,

        String issuerName,

        String nameOnCard,

        String type,

        String currencyCode,

        String externalId,

        List<VisaPreferredFor> preferredFor
) {
}
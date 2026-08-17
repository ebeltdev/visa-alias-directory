package com.visa.alias.integration.visa.alias.dto;

import java.util.List;

public record VisaGetPaymentCredentialResponse(

        String id,
        String type,
        String accountNumber,
        String accountNumberType,
        VisaBillingAddress billingAddress,
        String cardType,
        String createdOn,
        String currencyCode,
        String expirationDate,
        String externalId,
        String issuerName,
        String lastFourDigits,
        String lastUpdatedOn,
        String nameOnCard,
        List<VisaPreferredForResponse> preferredFor,
        String status
) {
}
package com.visa.alias.dto.response;

import java.util.List;

public record GetPaymentCredentialResponse(

        String id,
        String type,
        String accountNumber,
        String accountNumberType,
        BillingAddressResponse billingAddress,
        String cardType,
        String createdOn,
        String currencyCode,
        String expirationDate,
        String externalId,
        String issuerName,
        String lastFourDigits,
        String lastUpdatedOn,
        String nameOnCard,
        List<PreferredForResponse> preferredFor,
        String status
) {
}
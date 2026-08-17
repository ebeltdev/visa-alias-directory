package com.visa.alias.integration.visa.alias.dto;

import java.util.List;

public record VisaUpdatePaymentCredentialRequest(

        VisaBillingAddress billingAddress,

        String expirationDate,

        String nameOnCard,

        String type,

        String cardType,

        String currencyCode,

        String externalId,

        String issuerName,

        List<VisaPreferredFor> preferredFor

) {
}
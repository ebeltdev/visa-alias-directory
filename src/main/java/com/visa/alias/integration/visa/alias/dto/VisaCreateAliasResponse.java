package com.visa.alias.integration.visa.alias.dto;

import java.util.List;

public record VisaCreateAliasResponse(

        String id,

        String externalId,

        List<VisaPaymentCredentialResponse> paymentCredentials
) {
}
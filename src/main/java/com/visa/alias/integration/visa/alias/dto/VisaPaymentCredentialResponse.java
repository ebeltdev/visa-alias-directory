package com.visa.alias.integration.visa.alias.dto;

public record VisaPaymentCredentialResponse(

        String id,

        String type,

        String externalId
) {
}
package com.visa.alias.integration.visa.alias.dto;

public record VisaCreatePaymentCredentialResponse(

        String id,

        String type,

        String externalId
) {
}
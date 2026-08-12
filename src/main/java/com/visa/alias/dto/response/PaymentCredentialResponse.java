package com.visa.alias.dto.response;

public record PaymentCredentialResponse(

        String id,

        String type,

        String externalId
) {
}
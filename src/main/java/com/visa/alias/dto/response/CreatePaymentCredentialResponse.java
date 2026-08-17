package com.visa.alias.dto.response;

public record CreatePaymentCredentialResponse(

        String id,

        String type,

        String externalId
) {
}
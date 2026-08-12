package com.visa.alias.dto.response;

import java.util.List;

public record CreateAliasResponse(

        String id,

        String externalId,

        List<PaymentCredentialResponse> paymentCredentials
) {
}
package com.visa.alias.dto.request;

public record VerificationDetails(

        Boolean verifiedPhone,

        String authMethodReference,

        String authDateTime,

        Boolean verifiedEmail,

        String creationDateTime
) {
}
package com.visa.alias.integration.visa.alias.dto;

public record VisaVerificationDetails(

        String authDateTime,

        String authMethodReference,

        String creationDateTime,

        Boolean verifiedEmail,

        Boolean verifiedPhone

) {
}
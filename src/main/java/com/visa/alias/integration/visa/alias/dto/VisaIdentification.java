package com.visa.alias.integration.visa.alias.dto;

public record VisaIdentification(

        String type,

        String value,

        VisaVerificationDetails verificationDetails

) {
}
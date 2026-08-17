package com.visa.alias.integration.visa.alias.dto;

public record VisaUpdateAliasRequest(

        VisaConsent consent,

        VisaProfile profile,

        VisaIdentification identification

) {
}
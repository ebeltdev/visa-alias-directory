package com.visa.alias.integration.visa.alias.dto;

import java.util.List;

public record VisaConsent(

        String presenter,

        String validFromDateTime,

        String version,

        String expiryDateTime,

        List<String> intermediaries

) {
}
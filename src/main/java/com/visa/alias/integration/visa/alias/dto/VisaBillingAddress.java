package com.visa.alias.integration.visa.alias.dto;

public record VisaBillingAddress(

        String country,

        String addressLine1,

        String addressLine2,

        String buildingNumber,

        String city,

        String minorSubdivisionCode,

        String postalCode,

        String state,

        String streetName
) {
}
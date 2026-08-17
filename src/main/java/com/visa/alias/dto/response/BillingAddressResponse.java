package com.visa.alias.dto.response;

public record BillingAddressResponse(

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
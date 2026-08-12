package com.visa.alias.dto.request;

import jakarta.validation.constraints.NotBlank;

public record BillingAddress(

        @NotBlank(message = "billingAddress.country is required")
        String country,

        String addressLine1,

        String addressLine2,

        String buildingNumber,

        String streetName,

        String city,

        String state,

        String postalCode,

        String minorSubdivisionCode
) {
}
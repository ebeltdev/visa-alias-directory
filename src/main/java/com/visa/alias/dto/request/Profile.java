package com.visa.alias.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record Profile(

        @NotBlank(message = "profile.firstName is required")
        String firstName,

        @NotBlank(message = "profile.lastName is required")
        String lastName,

        String firstNameLocal,

        String lastNameLocal,

        String middleName,

        String middleNameLocal,

        String preferredName,

        String dateOfBirth,

        @Valid
        List<ContactInfo> contactInfo
) {
}
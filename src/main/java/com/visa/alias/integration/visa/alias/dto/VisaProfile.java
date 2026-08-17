package com.visa.alias.integration.visa.alias.dto;

import java.util.List;

public record VisaProfile(

        String firstName,

        String lastName,

        List<VisaContactInfo> contactInfo,

        String dateOfBirth,

        String firstNameLocal,

        String lastNameLocal,

        String middleName,

        String middleNameLocal,

        String preferredName

) {
}
package com.visa.alias.integration.visa.alias.mapper;

import com.visa.alias.dto.request.Consent;
import com.visa.alias.dto.request.CreateAliasRequest;
import com.visa.alias.dto.request.Identification;
import com.visa.alias.dto.request.Profile;
import com.visa.alias.dto.request.UpdateAliasRequest;
import com.visa.alias.dto.response.CreateAliasResponse;
import com.visa.alias.dto.response.PaymentCredentialResponse;
import com.visa.alias.integration.visa.alias.dto.VisaConsent;
import com.visa.alias.integration.visa.alias.dto.VisaContactInfo;
import com.visa.alias.integration.visa.alias.dto.VisaCreateAliasRequest;
import com.visa.alias.integration.visa.alias.dto.VisaCreateAliasResponse;
import com.visa.alias.integration.visa.alias.dto.VisaIdentification;
import com.visa.alias.integration.visa.alias.dto.VisaProfile;
import com.visa.alias.integration.visa.alias.dto.VisaUpdateAliasRequest;
import com.visa.alias.integration.visa.alias.dto.VisaVerificationDetails;

import java.util.List;

public final class VisaAliasMapper {

        private VisaAliasMapper() {
        }

        public static VisaCreateAliasRequest toVisaRequest(
                        CreateAliasRequest request) {

                return new VisaCreateAliasRequest(
                                request.aliasType(),
                                request.aliasValue(),
                                request.consent(),
                                request.paymentCredentials(),
                                request.profile(),
                                request.externalId(),
                                request.identification());
        }

        public static VisaUpdateAliasRequest toVisaRequest(
                        UpdateAliasRequest request) {

                return new VisaUpdateAliasRequest(
                                toVisaConsent(request.consent()),
                                toVisaProfile(request.profile()),
                                toVisaIdentification(request.identification()));
        }

        public static CreateAliasResponse toResponse(
                        VisaCreateAliasResponse response) {

                List<PaymentCredentialResponse> credentials = response.paymentCredentials() == null
                                ? List.of()
                                : response.paymentCredentials()
                                                .stream()
                                                .map(credential -> new PaymentCredentialResponse(
                                                                credential.id(),
                                                                credential.type(),
                                                                credential.externalId()))
                                                .toList();

                return new CreateAliasResponse(
                                response.id(),
                                response.externalId(),
                                credentials);
        }

        private static VisaConsent toVisaConsent(
                        Consent consent) {

                if (consent == null) {
                        return null;
                }

                return new VisaConsent(
                                consent.presenter(),
                                consent.validFromDateTime(),
                                consent.version(),
                                consent.expiryDateTime(),
                                consent.intermediaries());
        }

        private static VisaProfile toVisaProfile(
                        Profile profile) {

                if (profile == null) {
                        return null;
                }

                var contactInfo = profile.contactInfo() == null
                                ? null
                                : profile.contactInfo()
                                                .stream()
                                                .map(contact -> new VisaContactInfo(
                                                                contact.type(),
                                                                contact.value()))
                                                .toList();

                return new VisaProfile(
                                profile.firstName(),
                                profile.lastName(),
                                contactInfo,
                                profile.dateOfBirth(),
                                profile.firstNameLocal(),
                                profile.lastNameLocal(),
                                profile.middleName(),
                                profile.middleNameLocal(),
                                profile.preferredName());
        }

        private static VisaIdentification toVisaIdentification(
                        Identification identification) {

                if (identification == null) {
                        return null;
                }

                VisaVerificationDetails verificationDetails = null;

                if (identification.verificationDetails() != null) {

                        var details = identification.verificationDetails();

                        verificationDetails = new VisaVerificationDetails(
                                        details.authDateTime(),
                                        details.authMethodReference(),
                                        details.creationDateTime(),
                                        details.verifiedEmail(),
                                        details.verifiedPhone());
                }

                return new VisaIdentification(
                                identification.type(),
                                identification.value(),
                                verificationDetails);
        }
}
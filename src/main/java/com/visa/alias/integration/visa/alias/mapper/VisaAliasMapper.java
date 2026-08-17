package com.visa.alias.integration.visa.alias.mapper;

import com.visa.alias.dto.request.Consent;
import com.visa.alias.dto.request.CreateAliasRequest;
import com.visa.alias.dto.request.CreatePaymentCredentialRequest;
import com.visa.alias.dto.request.Identification;
import com.visa.alias.dto.request.Profile;
import com.visa.alias.dto.request.UpdateAliasRequest;
import com.visa.alias.dto.request.UpdatePaymentCredentialRequest;
import com.visa.alias.dto.response.BillingAddressResponse;
import com.visa.alias.dto.response.CreateAliasResponse;
import com.visa.alias.dto.response.CreatePaymentCredentialResponse;
import com.visa.alias.dto.response.GetPaymentCredentialResponse;
import com.visa.alias.dto.response.PaymentCredentialResponse;
import com.visa.alias.dto.response.PreferredForResponse;
import com.visa.alias.integration.visa.alias.dto.VisaBillingAddress;
import com.visa.alias.integration.visa.alias.dto.VisaConsent;
import com.visa.alias.integration.visa.alias.dto.VisaContactInfo;
import com.visa.alias.integration.visa.alias.dto.VisaCreateAliasRequest;
import com.visa.alias.integration.visa.alias.dto.VisaCreateAliasResponse;
import com.visa.alias.integration.visa.alias.dto.VisaCreatePaymentCredentialRequest;
import com.visa.alias.integration.visa.alias.dto.VisaCreatePaymentCredentialResponse;
import com.visa.alias.integration.visa.alias.dto.VisaGetPaymentCredentialResponse;
import com.visa.alias.integration.visa.alias.dto.VisaIdentification;
import com.visa.alias.integration.visa.alias.dto.VisaPreferredFor;
import com.visa.alias.integration.visa.alias.dto.VisaProfile;
import com.visa.alias.integration.visa.alias.dto.VisaUpdateAliasRequest;
import com.visa.alias.integration.visa.alias.dto.VisaUpdatePaymentCredentialRequest;
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

        public static VisaCreatePaymentCredentialRequest toVisaRequest(
                        CreatePaymentCredentialRequest request) {

                VisaBillingAddress billingAddress = request.billingAddress() == null
                                ? null
                                : new VisaBillingAddress(
                                                request.billingAddress().country(),
                                                request.billingAddress().addressLine1(),
                                                request.billingAddress().addressLine2(),
                                                request.billingAddress().buildingNumber(),
                                                request.billingAddress().city(),
                                                request.billingAddress().minorSubdivisionCode(),
                                                request.billingAddress().postalCode(),
                                                request.billingAddress().state(),
                                                request.billingAddress().streetName());

                var preferredFor = request.preferredFor() == null
                                ? null
                                : request.preferredFor()
                                                .stream()
                                                .map(item -> new VisaPreferredFor(item.type()))
                                                .toList();

                return new VisaCreatePaymentCredentialRequest(
                                request.accountNumber(),
                                billingAddress,
                                request.cardType(),
                                request.expirationDate(),
                                request.issuerName(),
                                request.nameOnCard(),
                                request.type(),
                                request.currencyCode(),
                                request.externalId(),
                                preferredFor);
        }

        public static VisaUpdateAliasRequest toVisaRequest(
                        UpdateAliasRequest request) {

                return new VisaUpdateAliasRequest(
                                toVisaConsent(request.consent()),
                                toVisaProfile(request.profile()),
                                toVisaIdentification(request.identification()));
        }

        public static VisaUpdatePaymentCredentialRequest toVisaRequest(
                        UpdatePaymentCredentialRequest request) {

                VisaBillingAddress billingAddress = request.billingAddress() == null
                                ? null
                                : new VisaBillingAddress(
                                                request.billingAddress().country(),
                                                request.billingAddress().addressLine1(),
                                                request.billingAddress().addressLine2(),
                                                request.billingAddress().buildingNumber(),
                                                request.billingAddress().city(),
                                                request.billingAddress().minorSubdivisionCode(),
                                                request.billingAddress().postalCode(),
                                                request.billingAddress().state(),
                                                request.billingAddress().streetName());

                var preferredFor = request.preferredFor() == null
                                ? null
                                : request.preferredFor()
                                                .stream()
                                                .map(item -> new VisaPreferredFor(
                                                                item.type()))
                                                .toList();

                return new VisaUpdatePaymentCredentialRequest(
                                billingAddress,
                                request.expirationDate(),
                                request.nameOnCard(),
                                request.type(),
                                request.cardType(),
                                request.currencyCode(),
                                request.externalId(),
                                request.issuerName(),
                                preferredFor);
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

        public static CreatePaymentCredentialResponse toResponse(
                        VisaCreatePaymentCredentialResponse response) {

                return new CreatePaymentCredentialResponse(
                                response.id(),
                                response.type(),
                                response.externalId());
        }

        public static GetPaymentCredentialResponse toResponse(
                        VisaGetPaymentCredentialResponse response) {

                BillingAddressResponse billingAddress = null;

                if (response.billingAddress() != null) {
                        billingAddress = new BillingAddressResponse(
                                        response.billingAddress().country(),
                                        response.billingAddress().addressLine1(),
                                        response.billingAddress().addressLine2(),
                                        response.billingAddress().buildingNumber(),
                                        response.billingAddress().city(),
                                        response.billingAddress().minorSubdivisionCode(),
                                        response.billingAddress().postalCode(),
                                        response.billingAddress().state(),
                                        response.billingAddress().streetName());
                }

                var preferredFor = response.preferredFor() == null
                                ? null
                                : response.preferredFor()
                                                .stream()
                                                .map(item -> new PreferredForResponse(
                                                                item.type(),
                                                                item.date()))
                                                .toList();

                return new GetPaymentCredentialResponse(
                                response.id(),
                                response.type(),
                                response.accountNumber(),
                                response.accountNumberType(),
                                billingAddress,
                                response.cardType(),
                                response.createdOn(),
                                response.currencyCode(),
                                response.expirationDate(),
                                response.externalId(),
                                response.issuerName(),
                                response.lastFourDigits(),
                                response.lastUpdatedOn(),
                                response.nameOnCard(),
                                preferredFor,
                                response.status());
        }

        public static List<GetPaymentCredentialResponse> toResponse(
                        List<VisaGetPaymentCredentialResponse> responses) {

                if (responses == null) {
                        return List.of();
                }

                return responses.stream()
                                .map(VisaAliasMapper::toResponse)
                                .toList();
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
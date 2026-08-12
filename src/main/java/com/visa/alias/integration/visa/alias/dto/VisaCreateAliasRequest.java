package com.visa.alias.integration.visa.alias.dto;

import com.visa.alias.dto.request.Consent;
import com.visa.alias.dto.request.Identification;
import com.visa.alias.dto.request.PaymentCredential;
import com.visa.alias.dto.request.Profile;

import java.util.List;

public record VisaCreateAliasRequest(

                String aliasType,

                String aliasValue,

                Consent consent,

                List<PaymentCredential> paymentCredentials,

                Profile profile,

                String externalId,

                Identification identification) {
}
package com.visa.alias.integration.visa.alias.mapper;

import com.visa.alias.dto.request.CreateAliasRequest;
import com.visa.alias.dto.response.CreateAliasResponse;
import com.visa.alias.dto.response.PaymentCredentialResponse;
import com.visa.alias.integration.visa.alias.dto.VisaCreateAliasRequest;
import com.visa.alias.integration.visa.alias.dto.VisaCreateAliasResponse;

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
}
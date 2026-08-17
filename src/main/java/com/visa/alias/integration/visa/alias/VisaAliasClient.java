package com.visa.alias.integration.visa.alias;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.visa.alias.client.VisaAliasRestClient;
import com.visa.alias.dto.visa.VisaErrorResponse;
import com.visa.alias.exception.VisaApiException;
import com.visa.alias.exception.VisaIntegrationException;
import com.visa.alias.integration.visa.alias.dto.VisaCreateAliasRequest;
import com.visa.alias.integration.visa.alias.dto.VisaCreateAliasResponse;
import com.visa.alias.integration.visa.alias.dto.VisaCreatePaymentCredentialRequest;
import com.visa.alias.integration.visa.alias.dto.VisaCreatePaymentCredentialResponse;
import com.visa.alias.integration.visa.alias.dto.VisaGetPaymentCredentialResponse;
import com.visa.alias.integration.visa.alias.dto.VisaUpdateAliasRequest;
import com.visa.alias.integration.visa.common.dto.VisaEncryptedPayload;
import com.visa.alias.integration.visa.crypto.MleDecryptionService;
import com.visa.alias.integration.visa.crypto.MleEncryptionService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;

import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class VisaAliasClient {

        @Inject
        @RestClient
        VisaAliasRestClient restClient;

        @Inject
        ObjectMapper objectMapper;

        @Inject
        MleEncryptionService mleEncryptionService;

        @Inject
        MleDecryptionService mleDecryptionService;

        public List<VisaGetPaymentCredentialResponse> getAllPaymentCredentials(
                        String aliasId) {

                try (Response response = restClient.getAllPaymentCredentials(aliasId)) {

                        int status = response.getStatus();

                        if (status >= 200 && status < 300) {

                                String responseBody = response.readEntity(String.class);

                                VisaEncryptedPayload encryptedResponse = objectMapper.readValue(
                                                responseBody,
                                                VisaEncryptedPayload.class);

                                String decryptedJson = mleDecryptionService.decrypt(
                                                encryptedResponse.encData());

                                return objectMapper.readValue(
                                                decryptedJson,
                                                objectMapper.getTypeFactory()
                                                                .constructCollectionType(
                                                                                List.class,
                                                                                VisaGetPaymentCredentialResponse.class));
                        }

                        handleVisaError(response);

                        throw new VisaIntegrationException(
                                        "Unexpected response from Visa Alias Directory");

                } catch (VisaApiException e) {
                        throw e;

                } catch (VisaIntegrationException e) {
                        throw e;

                } catch (Exception e) {
                        throw new VisaIntegrationException(
                                        "Unable to get payment credentials from Visa Alias Directory",
                                        e);
                }
        }

        public VisaCreateAliasResponse createAlias(
                        VisaCreateAliasRequest request) {

                try {
                        String requestJson = objectMapper.writeValueAsString(request);

                        String encryptedRequest = mleEncryptionService.encrypt(requestJson);

                        VisaEncryptedPayload encryptedPayload = new VisaEncryptedPayload(encryptedRequest);

                        try (Response response = restClient.createAlias(encryptedPayload)) {

                                int status = response.getStatus();

                                if (status >= 200 && status < 300) {

                                        String responseBody = response.readEntity(String.class);

                                        VisaEncryptedPayload encryptedResponse = objectMapper.readValue(
                                                        responseBody,
                                                        VisaEncryptedPayload.class);

                                        String decryptedJson = mleDecryptionService.decrypt(
                                                        encryptedResponse.encData());

                                        return objectMapper.readValue(
                                                        decryptedJson,
                                                        VisaCreateAliasResponse.class);
                                }

                                handleVisaError(response);

                                // Nunca debería alcanzarse porque handleVisaError lanza excepción.
                                throw new VisaIntegrationException(
                                                "Unexpected response from Visa Alias Directory");
                        }

                } catch (VisaApiException e) {
                        throw e;

                } catch (VisaIntegrationException e) {
                        throw e;

                } catch (Exception e) {
                        throw new VisaIntegrationException(
                                        "Unable to create alias in Visa Alias Directory",
                                        e);
                }
        }

        public VisaCreatePaymentCredentialResponse createPaymentCredential(
                        String aliasId,
                        VisaCreatePaymentCredentialRequest request) {

                try {
                        String requestJson = objectMapper.writeValueAsString(request);

                        String encryptedRequest = mleEncryptionService.encrypt(requestJson);

                        VisaEncryptedPayload encryptedPayload = new VisaEncryptedPayload(encryptedRequest);

                        try (Response response = restClient.createPaymentCredential(
                                        aliasId,
                                        encryptedPayload)) {

                                int status = response.getStatus();

                                if (status >= 200 && status < 300) {

                                        String responseBody = response.readEntity(String.class);

                                        VisaEncryptedPayload encryptedResponse = objectMapper.readValue(
                                                        responseBody,
                                                        VisaEncryptedPayload.class);

                                        String decryptedJson = mleDecryptionService.decrypt(
                                                        encryptedResponse.encData());

                                        return objectMapper.readValue(
                                                        decryptedJson,
                                                        VisaCreatePaymentCredentialResponse.class);
                                }

                                handleVisaError(response);

                                throw new VisaIntegrationException(
                                                "Unexpected response from Visa Alias Directory");
                        }

                } catch (VisaApiException e) {
                        throw e;

                } catch (VisaIntegrationException e) {
                        throw e;

                } catch (Exception e) {
                        throw new VisaIntegrationException(
                                        "Unable to create payment credential in Visa Alias Directory",
                                        e);
                }
        }

        public void updateAlias(
                        String aliasId,
                        VisaUpdateAliasRequest request) {

                try {
                        String requestJson = objectMapper.writeValueAsString(request);

                        String encryptedRequest = mleEncryptionService.encrypt(requestJson);

                        VisaEncryptedPayload encryptedPayload = new VisaEncryptedPayload(encryptedRequest);

                        try (Response response = restClient.updateAlias(
                                        aliasId,
                                        encryptedPayload)) {

                                int status = response.getStatus();

                                if (status >= 200 && status < 300) {
                                        return;
                                }

                                handleVisaError(response);
                        }

                } catch (VisaApiException e) {
                        throw e;

                } catch (VisaIntegrationException e) {
                        throw e;

                } catch (Exception e) {
                        throw new VisaIntegrationException(
                                        "Unable to update alias in Visa Alias Directory",
                                        e);
                }
        }

        public void deleteAlias(String aliasId) {

                try (Response response = restClient.deleteAlias(aliasId)) {

                        int status = response.getStatus();

                        if (status >= 200 && status < 300) {
                                return;
                        }

                        handleVisaError(response);

                } catch (VisaApiException e) {
                        throw e;

                } catch (VisaIntegrationException e) {
                        throw e;

                } catch (Exception e) {
                        throw new VisaIntegrationException(
                                        "Unable to delete alias in Visa Alias Directory",
                                        e);
                }
        }

        private void handleVisaError(Response response) {

                try {
                        String responseBody = response.readEntity(String.class);

                        VisaEncryptedPayload encryptedResponse = objectMapper.readValue(
                                        responseBody,
                                        VisaEncryptedPayload.class);

                        String decryptedJson = mleDecryptionService.decrypt(
                                        encryptedResponse.encData());

                        VisaErrorResponse visaError = objectMapper.readValue(
                                        decryptedJson,
                                        VisaErrorResponse.class);

                        throw new VisaApiException(
                                        response.getStatus(),
                                        visaError.errorCode(),
                                        visaError.errorMessages());

                } catch (VisaApiException e) {
                        throw e;

                } catch (Exception e) {
                        throw new VisaIntegrationException(
                                        "Unable to process Visa error response",
                                        e);
                }
        }
}
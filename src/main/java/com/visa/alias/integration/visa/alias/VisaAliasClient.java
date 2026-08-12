package com.visa.alias.integration.visa.alias;

import com.visa.alias.client.VisaAliasRestClient;
import com.visa.alias.integration.visa.alias.dto.VisaCreateAliasRequest;
import com.visa.alias.integration.visa.alias.dto.VisaCreateAliasResponse;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class VisaAliasClient {

    @Inject
    @RestClient
    VisaAliasRestClient restClient;

    public VisaCreateAliasResponse createAlias(
            VisaCreateAliasRequest request) {

        return restClient.createAlias(request);
    }
}
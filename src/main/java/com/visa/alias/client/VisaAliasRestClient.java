package com.visa.alias.client;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import com.visa.alias.integration.visa.alias.dto.VisaCreateAliasRequest;
import com.visa.alias.integration.visa.alias.dto.VisaCreateAliasResponse;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/aliasdirectory/v1")
@RegisterRestClient(configKey = "visa-api")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface VisaAliasRestClient {

    @POST
    @Path("/aliases")
    VisaCreateAliasResponse createAlias(
            VisaCreateAliasRequest request
    );
}

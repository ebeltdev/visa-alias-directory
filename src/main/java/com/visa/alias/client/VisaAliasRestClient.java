package com.visa.alias.client;

import com.visa.alias.integration.visa.VisaAuthenticationFilter;
import com.visa.alias.integration.visa.common.dto.VisaEncryptedPayload;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/aliasdirectory/v1")
@RegisterRestClient(configKey = "visa-api")
@RegisterProvider(VisaAuthenticationFilter.class)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface VisaAliasRestClient {

        @POST
        @Path("/aliases")
        Response createAlias(
                        VisaEncryptedPayload request);

        @PUT
        @Path("/aliases/{aliasId}")
        Response updateAlias(
                        @PathParam("aliasId") String aliasId,
                        VisaEncryptedPayload request);

        @DELETE
        @Path("/aliases/{aliasId}")
        Response deleteAlias(
                        @PathParam("aliasId") String aliasId);
}
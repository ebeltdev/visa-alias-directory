package com.visa.alias.controller;

import com.visa.alias.dto.request.CreateAliasRequest;
import com.visa.alias.dto.request.CreatePaymentCredentialRequest;
import com.visa.alias.dto.request.UpdateAliasRequest;
import com.visa.alias.dto.response.CreateAliasResponse;
import com.visa.alias.dto.response.CreatePaymentCredentialResponse;
import com.visa.alias.service.AliasService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/v1/aliases")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AliasController {

        @Inject
        AliasService aliasService;

        @POST
        public Response createAlias(@Valid CreateAliasRequest request) {

                CreateAliasResponse response = aliasService.createAlias(request);

                return Response
                                .status(Response.Status.CREATED)
                                .entity(response)
                                .build();
        }

        @PUT
        @Path("/{aliasId}")
        public Response updateAlias(

                        @PathParam("aliasId") @Size(min = 36, max = 36, message = "aliasId must have 36 characters") String aliasId,

                        @Valid UpdateAliasRequest request) {

                aliasService.updateAlias(
                                aliasId,
                                request);

                return Response
                                .noContent()
                                .build();
        }

        @DELETE
        @Path("/{aliasId}")
        public Response deleteAlias(

                        @PathParam("aliasId") @Size(min = 36, max = 36, message = "aliasId must have 36 characters") String aliasId) {

                aliasService.deleteAlias(aliasId);

                return Response
                                .noContent()
                                .build();
        }

        @POST
        @Path("/{aliasId}/paymentCredentials")
        public Response createPaymentCredential(

                        @PathParam("aliasId") @Size(min = 36, max = 36, message = "aliasId must have 36 characters") String aliasId,

                        @Valid CreatePaymentCredentialRequest request) {

                CreatePaymentCredentialResponse response = aliasService.createPaymentCredential(
                                aliasId,
                                request);

                return Response
                                .ok(response)
                                .build();
        }
}
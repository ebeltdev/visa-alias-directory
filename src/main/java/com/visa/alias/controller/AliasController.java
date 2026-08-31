package com.visa.alias.controller;

import java.util.List;

import com.visa.alias.dto.request.CreateAliasRequest;
import com.visa.alias.dto.request.CreatePaymentCredentialRequest;
import com.visa.alias.dto.request.UpdateAliasRequest;
import com.visa.alias.dto.request.UpdateAliasStatusRequest;
import com.visa.alias.dto.request.UpdatePaymentCredentialRequest;
import com.visa.alias.dto.response.CreateAliasResponse;
import com.visa.alias.dto.response.CreatePaymentCredentialResponse;
import com.visa.alias.dto.response.GetPaymentCredentialResponse;
import com.visa.alias.service.AliasService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/v1")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AliasController {

        @Inject
        AliasService aliasService;

        @POST
        @Path("/aliases")
        public Response createAlias(@Valid CreateAliasRequest request) {

                CreateAliasResponse response = aliasService.createAlias(request);

                return Response
                                .status(Response.Status.CREATED)
                                .entity(response)
                                .build();
        }

        @PUT
        @Path("/aliases/{aliasId}")
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
        @Path("/aliases/{aliasId}")
        public Response deleteAlias(

                        @PathParam("aliasId") @Size(min = 36, max = 36, message = "aliasId must have 36 characters") String aliasId) {

                aliasService.deleteAlias(aliasId);

                return Response
                                .noContent()
                                .build();
        }

        @POST
        @Path("/aliases/{aliasId}/paymentCredentials")
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

        @GET
        @Path("/aliases/{aliasId}/paymentCredentials")
        public Response getAllPaymentCredentials(

                        @PathParam("aliasId") @Size(min = 36, max = 36, message = "aliasId must have 36 characters") String aliasId) {

                List<GetPaymentCredentialResponse> response = aliasService.getAllPaymentCredentials(
                                aliasId);

                return Response
                                .ok(response)
                                .build();
        }

        @PUT
        @Path("/paymentCredentials/{paymentCredentialId}")
        public Response updatePaymentCredential(

                        @PathParam("paymentCredentialId") @Size(min = 36, max = 36, message = "paymentCredentialId must have 36 characters") String paymentCredentialId,

                        @Valid UpdatePaymentCredentialRequest request) {

                aliasService.updatePaymentCredential(
                                paymentCredentialId,
                                request);

                return Response
                                .noContent()
                                .build();
        }

        @DELETE
        @Path("/paymentCredentials/{paymentCredentialId}")
        public Response deletePaymentCredential(

                        @PathParam("paymentCredentialId") @Size(min = 36, max = 36, message = "paymentCredentialId must have 36 characters") String paymentCredentialId) {

                aliasService.deletePaymentCredential(
                                paymentCredentialId);

                return Response
                                .noContent()
                                .build();
        }

        @PUT
        @Path("/aliases/{aliasId}/status")
        public Response updateAliasStatus(

                        @PathParam("aliasId") @Size(min = 36, max = 36, message = "aliasId must have 36 characters") String aliasId,

                        @Valid UpdateAliasStatusRequest request) {

                aliasService.updateAliasStatus(
                                aliasId,
                                request);

                return Response
                                .noContent()
                                .build();
        }

}
package com.visa.alias.controller;

import com.visa.alias.dto.request.CreateAliasRequest;
import com.visa.alias.dto.response.CreateAliasResponse;
import com.visa.alias.service.AliasService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
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
}
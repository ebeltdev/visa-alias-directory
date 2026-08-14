package com.visa.alias.exception;

import com.visa.alias.dto.response.ErrorResponse;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.util.List;

@Provider
public class VisaIntegrationExceptionMapper
        implements ExceptionMapper<VisaIntegrationException> {

    @Override
    public Response toResponse(
            VisaIntegrationException exception) {

        ErrorResponse response =
                new ErrorResponse(
                        "VISA_INTEGRATION_ERROR",
                        List.of(
                                "Unable to process the request with Visa Alias Directory"
                        )
                );

        return Response
                .status(Response.Status.BAD_GATEWAY)
                .type(MediaType.APPLICATION_JSON)
                .entity(response)
                .build();
    }
}
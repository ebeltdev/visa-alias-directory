package com.visa.alias.exception;

import com.visa.alias.dto.response.ErrorResponse;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class VisaApiExceptionMapper
                implements ExceptionMapper<VisaApiException> {

        @Override
        public Response toResponse(VisaApiException exception) {

                ErrorResponse errorResponse = new ErrorResponse(
                                exception.getErrorCode(),
                                exception.getErrorMessages());

                return Response
                                .status(exception.getStatus())
                                .type(MediaType.APPLICATION_JSON)
                                .entity(errorResponse)
                                .build();
        }
}
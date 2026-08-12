package com.visa.alias.integration.visa.alias;

import com.visa.alias.config.VisaConfig;
import jakarta.annotation.Priority;
import jakarta.inject.Inject;
import jakarta.ws.rs.Priorities;
import jakarta.ws.rs.client.ClientRequestContext;
import jakarta.ws.rs.client.ClientRequestFilter;
import jakarta.ws.rs.ext.Provider;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Provider
@Priority(Priorities.AUTHENTICATION)
public class VisaAuthenticationFilter implements ClientRequestFilter {

        @Inject
        VisaConfig visaConfig;

        @Override
        public void filter(ClientRequestContext requestContext) {

                String credentials = visaConfig.userId() + ":" + visaConfig.password();

                String encodedCredentials = Base64
                                .getEncoder()
                                .encodeToString(
                                                credentials.getBytes(StandardCharsets.UTF_8));

                requestContext.getHeaders().putSingle(
                                "Authorization",
                                "Basic " + encodedCredentials);
        }
}
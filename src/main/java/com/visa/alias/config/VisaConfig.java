package com.visa.alias.config;

import io.smallrye.config.ConfigMapping;

@ConfigMapping(prefix = "visa")
public interface VisaConfig {

    String baseUrl();

    String userId();

    String password();

    String clientKeyStore();

    String clientKeyStorePassword();

    String mleKeyId();

    String mleServerCertificate();

    String mlePrivateKey();
}
package com.visa.alias.integration.visa.crypto;

import com.nimbusds.jose.EncryptionMethod;
import com.nimbusds.jose.JWEAlgorithm;
import com.nimbusds.jose.JWEHeader;
import com.nimbusds.jose.JWEObject;
import com.nimbusds.jose.Payload;
import com.nimbusds.jose.crypto.RSAEncrypter;
import com.visa.alias.config.VisaConfig;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.security.interfaces.RSAPublicKey;
import java.time.Instant;

@ApplicationScoped
public class MleEncryptionService {

        @Inject
        VisaConfig visaConfig;

        @Inject
        PemKeyLoader pemKeyLoader;

        public String encrypt(String payload) {

                try {
                        var certificate = pemKeyLoader.loadCertificate(
                                        visaConfig.mleServerCertificate());

                        RSAPublicKey publicKey = (RSAPublicKey) certificate.getPublicKey();

                        JWEHeader header = new JWEHeader.Builder(
                                        JWEAlgorithm.RSA_OAEP_256,
                                        EncryptionMethod.A256GCM)
                                        .keyID(visaConfig.mleKeyId())
                                        .customParam(
                                                        "iat",
                                                        Instant.now().toEpochMilli())
                                        .build();

                        JWEObject jweObject = new JWEObject(
                                        header,
                                        new Payload(payload));

                        jweObject.encrypt(
                                        new RSAEncrypter(publicKey));

                        return jweObject.serialize();

                } catch (Exception e) {
                        throw new IllegalStateException(
                                        "Unable to encrypt Visa MLE payload",
                                        e);
                }
        }
}
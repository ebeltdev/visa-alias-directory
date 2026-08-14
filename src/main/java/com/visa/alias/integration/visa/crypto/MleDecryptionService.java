package com.visa.alias.integration.visa.crypto;

import com.nimbusds.jose.JWEObject;
import com.nimbusds.jose.crypto.RSADecrypter;
import com.visa.alias.config.VisaConfig;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.security.interfaces.RSAPrivateKey;

@ApplicationScoped
public class MleDecryptionService {

        @Inject
        VisaConfig visaConfig;

        @Inject
        PemKeyLoader pemKeyLoader;

        public String decrypt(String encryptedPayload) {

                try {
                        RSAPrivateKey privateKey = (RSAPrivateKey) pemKeyLoader.loadPrivateKey(
                                        visaConfig.mlePrivateKey());

                        JWEObject jweObject = JWEObject.parse(encryptedPayload);

                        jweObject.decrypt(
                                        new RSADecrypter(privateKey));

                        return jweObject
                                        .getPayload()
                                        .toString();

                } catch (Exception e) {
                        throw new IllegalStateException(
                                        "Unable to decrypt Visa MLE payload",
                                        e);
                }
        }
}
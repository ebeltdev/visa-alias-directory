package com.visa.alias.integration.visa.crypto;

import jakarta.enterprise.context.ApplicationScoped;

import java.io.ByteArrayInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

@ApplicationScoped
public class PemKeyLoader {

        public X509Certificate loadCertificate(String path) {
                try {
                        byte[] bytes = Files.readAllBytes(Path.of(path));

                        CertificateFactory factory = CertificateFactory.getInstance("X.509");

                        return (X509Certificate) factory.generateCertificate(
                                        new ByteArrayInputStream(bytes));

                } catch (Exception e) {
                        throw new IllegalStateException(
                                        "Unable to load MLE certificate: " + path,
                                        e);
                }
        }

        public PrivateKey loadPrivateKey(String path) {
                try {
                        String pem = Files.readString(Path.of(path));

                        String normalized = pem
                                        .replace("-----BEGIN PRIVATE KEY-----", "")
                                        .replace("-----END PRIVATE KEY-----", "")
                                        .replaceAll("\\s", "");

                        byte[] keyBytes = Base64.getDecoder().decode(normalized);

                        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);

                        return KeyFactory
                                        .getInstance("RSA")
                                        .generatePrivate(spec);

                } catch (Exception e) {
                        throw new IllegalStateException(
                                        "Unable to load MLE private key: " + path,
                                        e);
                }
        }
}
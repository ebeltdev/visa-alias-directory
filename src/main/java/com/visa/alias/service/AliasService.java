package com.visa.alias.service;

import java.util.List;

import com.visa.alias.dto.request.CreateAliasRequest;
import com.visa.alias.dto.request.CreatePaymentCredentialRequest;
import com.visa.alias.dto.request.UpdateAliasRequest;
import com.visa.alias.dto.request.UpdatePaymentCredentialRequest;
import com.visa.alias.dto.response.CreateAliasResponse;
import com.visa.alias.dto.response.CreatePaymentCredentialResponse;
import com.visa.alias.dto.response.GetPaymentCredentialResponse;

public interface AliasService {

        CreateAliasResponse createAlias(
                        CreateAliasRequest request);

        void updateAlias(
                        String aliasId,
                        UpdateAliasRequest request);

        void deleteAlias(
                        String aliasId);

        CreatePaymentCredentialResponse createPaymentCredential(
                        String aliasId,
                        CreatePaymentCredentialRequest request);

        List<GetPaymentCredentialResponse> getAllPaymentCredentials(
                        String aliasId);

        void updatePaymentCredential(
                        String paymentCredentialId,
                        UpdatePaymentCredentialRequest request);

        void deletePaymentCredential(
                        String paymentCredentialId);
}
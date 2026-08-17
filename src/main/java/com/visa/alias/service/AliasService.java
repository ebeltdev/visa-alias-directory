package com.visa.alias.service;

import com.visa.alias.dto.request.CreateAliasRequest;
import com.visa.alias.dto.request.CreatePaymentCredentialRequest;
import com.visa.alias.dto.request.UpdateAliasRequest;
import com.visa.alias.dto.response.CreateAliasResponse;
import com.visa.alias.dto.response.CreatePaymentCredentialResponse;

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
}
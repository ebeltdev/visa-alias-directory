package com.visa.alias.service;

import com.visa.alias.dto.request.CreateAliasRequest;
import com.visa.alias.dto.request.UpdateAliasRequest;
import com.visa.alias.dto.response.CreateAliasResponse;

public interface AliasService {

        CreateAliasResponse createAlias(
                        CreateAliasRequest request);

        void updateAlias(
                        String aliasId,
                        UpdateAliasRequest request);

        void deleteAlias(
                        String aliasId);
}
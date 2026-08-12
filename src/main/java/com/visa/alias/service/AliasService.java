package com.visa.alias.service;

import com.visa.alias.dto.request.CreateAliasRequest;
import com.visa.alias.dto.response.CreateAliasResponse;

public interface AliasService {

    CreateAliasResponse createAlias(CreateAliasRequest request);
}
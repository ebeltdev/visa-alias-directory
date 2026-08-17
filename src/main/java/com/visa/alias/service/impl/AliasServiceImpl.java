package com.visa.alias.service.impl;

import com.visa.alias.dto.request.CreateAliasRequest;
import com.visa.alias.dto.request.UpdateAliasRequest;
import com.visa.alias.dto.response.CreateAliasResponse;
import com.visa.alias.integration.visa.alias.VisaAliasClient;
import com.visa.alias.integration.visa.alias.dto.VisaCreateAliasRequest;
import com.visa.alias.integration.visa.alias.dto.VisaCreateAliasResponse;
import com.visa.alias.integration.visa.alias.dto.VisaUpdateAliasRequest;
import com.visa.alias.integration.visa.alias.mapper.VisaAliasMapper;
import com.visa.alias.service.AliasService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class AliasServiceImpl implements AliasService {

        @Inject
        VisaAliasClient visaAliasClient;

        @Override
        public CreateAliasResponse createAlias(
                        CreateAliasRequest request) {

                VisaCreateAliasRequest visaRequest = VisaAliasMapper.toVisaRequest(request);

                VisaCreateAliasResponse visaResponse = visaAliasClient.createAlias(visaRequest);

                return VisaAliasMapper.toResponse(visaResponse);
        }

        @Override
        public void updateAlias(
                        String aliasId,
                        UpdateAliasRequest request) {

                VisaUpdateAliasRequest visaRequest = VisaAliasMapper.toVisaRequest(request);

                visaAliasClient.updateAlias(
                                aliasId,
                                visaRequest);
        }

        @Override
        public void deleteAlias(String aliasId) {
                visaAliasClient.deleteAlias(aliasId);
        }
}
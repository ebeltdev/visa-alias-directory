package com.visa.alias.dto.response;

import java.util.List;

public record ErrorResponse(
        String code,
        List<String> messages
) {
}
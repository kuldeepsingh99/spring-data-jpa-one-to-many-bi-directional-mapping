package com.portal.jpa.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record EmployeeResponseDTO(

        @JsonProperty("id")
        Long id,
        @JsonProperty("name")
        String name
) {
}


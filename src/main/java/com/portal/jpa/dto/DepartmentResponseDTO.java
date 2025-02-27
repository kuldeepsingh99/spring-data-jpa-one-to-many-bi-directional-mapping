package com.portal.jpa.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record DepartmentResponseDTO(

        @JsonProperty("id")
        Long id,

        @JsonProperty("department_name")
        String name,

        @JsonProperty("department_code")
        String code
) {
}

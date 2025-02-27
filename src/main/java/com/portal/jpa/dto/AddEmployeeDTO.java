package com.portal.jpa.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AddEmployeeDTO(
    @JsonProperty("employee_name")
    String name,
    @JsonProperty("department_id")
    Long departmentId
) {
}

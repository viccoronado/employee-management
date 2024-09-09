package com.employee.management.application.dto.request;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.time.LocalDate;

public class EmployeeHoursRequestDtoDeserializer extends JsonDeserializer<EmployeeHoursRequestDto> {

    @Override
    public EmployeeHoursRequestDto deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        JsonNode node = jp.getCodec().readTree(jp);
        Long employeeId = node.get("employeeId").asLong();
        LocalDate startDate = LocalDate.parse(node.get("startDate").asText());
        LocalDate endDate = LocalDate.parse(node.get("endDate").asText());

        return EmployeeHoursRequestDto.builder()
                .employeeId(employeeId)
                .startDate(startDate)
                .endDate(endDate)
                .build();
    }
}

package com.tepsivo.pv.report.web.api.dto;

import lombok.Data;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Map;

@Data
public class NewReportRequest {
    private String reporterName;
    private String productName;
    private String description;
    private String timestamp;
    private String reportStatus;


    // Validation ( improvement - use @javax.validation.constraints in a real app)
    public Map<String, String> isValid() {
        String errorMessage = "Invalid report request.  Please check the following fields:";
        boolean hasErrors = false;


        if (reporterName == null || reporterName.isEmpty()) {
            errorMessage += " reporterName";
            hasErrors = true;
        }
        if (productName == null || productName.isEmpty()) {
            errorMessage += " productName";
            hasErrors = true;
        }
        if (description == null || description.isEmpty()) {
            errorMessage += " description";
            hasErrors = true;
        }
        if (timestamp == null || timestamp.isEmpty()) {
            errorMessage += " timestamp";
            hasErrors = true;
        }
        try {
            OffsetDateTime.parse(timestamp, DateTimeFormatter.ISO_DATE_TIME);
        } catch (DateTimeParseException e) {
            errorMessage += " timestamp (invalid format)";
            hasErrors = true;
        }

        if (hasErrors) {
            return Map.of("message", errorMessage);
        }
        return null; // Return null for no errors,  Spring prefers null for empty Optionals
    }
}

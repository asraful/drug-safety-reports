package com.tepsivo.pv.report.web.api.dto;

import lombok.Data;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Data
public class NewReportRequest {
    private String reporterName;
    private String productName;
    private String description;
    private String timestamp;
    private String reportStatus;


    // Validation ( improvement - use @javax.validation.constraints in a real app)
    public boolean isValid() {
        if (reporterName == null || reporterName.isEmpty() ||
                productName == null || productName.isEmpty() ||
                description == null || description.isEmpty() ||
                timestamp == null || timestamp.isEmpty()) {
            return false;
        }
        try {
            OffsetDateTime.parse(timestamp, DateTimeFormatter.ISO_DATE_TIME);
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }
}

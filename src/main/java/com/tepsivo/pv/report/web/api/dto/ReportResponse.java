package com.tepsivo.pv.report.web.api.dto;

import lombok.Data;

@Data
public class ReportResponse {
    private String id;
    private String reporterName;
    private String productName;
    private String description;
    private String timestamp;
    private ReportStatus status;
}

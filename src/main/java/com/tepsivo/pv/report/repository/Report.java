package com.tepsivo.pv.report.repository;

import com.tepsivo.pv.report.web.api.dto.ReportStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Report {
    @Id
    private String id;
    private String reporterName;
    private String productName;
    private String description;
    private String timestamp;
    private ReportStatus status;

    public Report(String reporterName, String productName, String description, String timestamp) {
        this.reporterName = reporterName;
        this.productName = productName;
        this.description = description;
        this.timestamp = timestamp;
        this.status = ReportStatus.NEW;
    }

}

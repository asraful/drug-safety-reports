package com.tepsivo.pv.report.web.api.dto;

import com.tepsivo.pv.report.repository.Report;

import org.springframework.stereotype.Component;


@Component
public class ReportMapperImpl implements ReportMapper {
    @Override
    public ReportResponse toReportResponse(Report report) {
        ReportResponse reportResponse = new ReportResponse();
        reportResponse.setId(report.getId());
        reportResponse.setReporterName(report.getReporterName());
        reportResponse.setDescription(report.getDescription());
        reportResponse.setProductName(report.getProductName());
        reportResponse.setTimestamp(report.getTimestamp());

        reportResponse.setStatus(ReportStatus.fromCode(report.getStatus().getCode()));

        return reportResponse;
    }
}

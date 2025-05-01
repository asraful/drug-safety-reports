package com.tepsivo.pv.report.web.api.dto;

import com.tepsivo.pv.report.repository.Report;


import java.util.List;


public interface ReportMapper {
    ReportResponse toReportResponse(Report report);

    List<ReportResponse> toReportResponseList(List<Report> reports);
}

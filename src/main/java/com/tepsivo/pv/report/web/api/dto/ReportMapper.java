package com.tepsivo.pv.report.web.api.dto;

import com.tepsivo.pv.report.repository.Report;

import org.hibernate.annotations.Comment;

import org.mapstruct.factory.Mappers;


public interface ReportMapper {
    ReportResponse toReportResponse(Report report);
}

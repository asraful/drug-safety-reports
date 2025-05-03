package com.tepsivo.pv.report.web.api.dto;

import com.tepsivo.pv.report.repository.Report;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ReportMapperImplTest {
    @InjectMocks
    private ReportMapperImpl reportMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize Mockito mocks
    }

    @Test
    void testToReportResponse() {

        Report report = new Report();
        report.setId("123");
        report.setReporterName("Tepsivo Test Report-001");
        report.setDescription("Test report");
        report.setProductName("Product A");
        report.setTimestamp("2025-05-01T10:00:00Z");
        report.setStatus(ReportStatus.NEW);

        // When
        ReportResponse reportResponse = reportMapper.toReportResponse(report);

        // Then
        assertNotNull(reportResponse);
        assertEquals(report.getId(), reportResponse.getId());
        assertEquals(report.getReporterName(), reportResponse.getReporterName());
        assertEquals(report.getDescription(), reportResponse.getDescription());
        assertEquals(report.getProductName(), reportResponse.getProductName());
        assertEquals(report.getTimestamp(), reportResponse.getTimestamp());
        assertEquals(ReportStatus.NEW, reportResponse.getStatus());
    }


    @Test
    void stToReportResponseList() {
        // Given
        Report report1 = new Report();
        report1.setId("123");
        report1.setReporterName("Tepsivo Test Report-001");
        report1.setDescription("Test report");
        report1.setProductName("Product A");
        report1.setTimestamp("2025-05-01T10:00:00Z");
        report1.setStatus(ReportStatus.NEW);

        Report report2 = new Report();
        report2.setId("2");
        report2.setReporterName("Jane Smith");
        report2.setDescription("Test report 2");
        report2.setProductName("Product B");
        report1.setTimestamp("2025-05-01T09:00:00Z");
        report2.setStatus(ReportStatus.CLOSED);

        List<Report> reports = Arrays.asList(report1, report2);

        // When
        List<ReportResponse> reportResponses = reportMapper.toReportResponseList(reports);

        // Then
        assertNotNull(reportResponses);
        assertEquals(2, reportResponses.size());

        ReportResponse response1 = reportResponses.get(0);
        assertEquals(report1.getId(), response1.getId());
        assertEquals(report1.getReporterName(), response1.getReporterName());
        assertEquals(report1.getDescription(), response1.getDescription());
        assertEquals(report1.getProductName(), response1.getProductName());
        assertEquals(report1.getTimestamp(), response1.getTimestamp());
        assertEquals(ReportStatus.NEW, response1.getStatus());

        ReportResponse response2 = reportResponses.get(1);
        assertEquals(report2.getId(), response2.getId());
        assertEquals(report2.getReporterName(), response2.getReporterName());
        assertEquals(report2.getDescription(), response2.getDescription());
        assertEquals(report2.getProductName(), response2.getProductName());
        assertEquals(report2.getTimestamp(), response2.getTimestamp());
        assertEquals(ReportStatus.CLOSED, response2.getStatus());
    }
}

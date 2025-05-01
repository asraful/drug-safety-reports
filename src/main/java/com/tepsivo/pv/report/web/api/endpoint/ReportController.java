package com.tepsivo.pv.report.web.api.endpoint;


import com.tepsivo.pv.report.repository.Report;
import com.tepsivo.pv.report.service.ReportingService;
import com.tepsivo.pv.report.web.api.dto.NewReportRequest;
import com.tepsivo.pv.report.web.api.dto.ReportMapper;
import com.tepsivo.pv.report.web.api.dto.ReportResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/reports")
public class ReportController {
    private final ReportingService reportingService;

    public ReportController(ReportingService reportingService) {
        this.reportingService = reportingService;
    }


    @PostMapping // Map to POST /reports
    public ResponseEntity<Object> createReport(@RequestBody NewReportRequest newReportRequest) {
        if (!newReportRequest.isValid()) {
            return ResponseEntity.badRequest().build(); // 400 Bad Request
        }

        Report report = new Report(
                newReportRequest.getReporterName(),
                newReportRequest.getProductName(),
                newReportRequest.getDescription(),
                newReportRequest.getTimestamp()
        );

        String generatedId = java.util.UUID.randomUUID().toString();
        report.setId(generatedId);
        reportingService.saveReport(report);

        Map<String, Object> response = new HashMap<>();
        response.put("id", generatedId);
        response.put("message", "Report created successfully");

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Autowired
    ReportMapper reportMapper;

    @GetMapping("/{reportId}") // Map to GET /reports/{reportId}
    public ResponseEntity<ReportResponse> getReportById(@PathVariable String reportId) {

        System.out.println(reportId);
        Optional<Report> reportOptional = reportingService.findById(reportId);
        if (reportOptional.isPresent()) {
            Report report = reportOptional.get();
            ReportResponse reportResponse = reportMapper.toReportResponse(report);
            return ResponseEntity.ok(reportResponse); // 200 OK
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }

}

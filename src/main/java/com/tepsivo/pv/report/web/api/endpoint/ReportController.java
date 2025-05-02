package com.tepsivo.pv.report.web.api.endpoint;


import com.tepsivo.pv.report.repository.Report;
import com.tepsivo.pv.report.service.ReportingService;
import com.tepsivo.pv.report.web.api.dto.NewReportRequest;
import com.tepsivo.pv.report.web.api.dto.ReportMapper;
import com.tepsivo.pv.report.web.api.dto.ReportResponse;
import com.tepsivo.pv.report.web.api.dto.ReportStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("/reports")
public class ReportController {

    private Logger logger = LoggerFactory.getLogger(ReportController.class);

    private final ReportingService reportingService;

    public ReportController(ReportingService reportingService) {
        this.reportingService = reportingService;
    }


    @PostMapping
    public ResponseEntity<Object> createReport(@RequestBody NewReportRequest newReportRequest) {
        var error = newReportRequest.isValid();
        if (error != null) {
            return ResponseEntity.badRequest().body(error);
        }

        try {
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
        } catch (Exception e) {
            throw new APIException("Failed to create new report", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Autowired
    ReportMapper reportMapper;

    @GetMapping("/{reportId}")
    public ResponseEntity<ReportResponse> getReportById(@PathVariable String reportId) {
        try {
            Optional<Report> reportOptional = reportingService.findById(reportId);
            if (reportOptional.isPresent()) {
                Report report = reportOptional.get();
                ReportResponse reportResponse = reportMapper.toReportResponse(report);
                return ResponseEntity.ok(reportResponse);
            } else {
                Map<String, String> response = new HashMap<>();
                response.put("message", "Report Not Found");
                return new ResponseEntity(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            throw new APIException("Failed to get report", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping
    public ResponseEntity<List<ReportResponse>> getReports(
            @RequestParam(value = "status", required = true) String status) {


        if (status == null || status.isEmpty()) {
            Map<String, String> error = new HashMap<>();
            error.put("message", "status is required");

            return new ResponseEntity(error, HttpStatus.NOT_FOUND);
        }
        try {


            List<ReportResponse> reportResponses =
                    reportMapper.toReportResponseList(reportingService.getReportsByStatus(ReportStatus.valueOf(status)));

            if (reportResponses.isEmpty()) {
                Map<String, String> response = new HashMap<>();
                response.put("message", "Reports not available");
                return new ResponseEntity(response, HttpStatus.NOT_FOUND);
            }
            return ResponseEntity.ok(reportResponses);

        } catch (IllegalArgumentException e) {
            logger.error("Invalid status value: {}", status, e);
            Map<String, String> error = new HashMap<>();
            error.put("message", "Invalid status value: " + status);
            return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            throw new APIException("Failed to get reports", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

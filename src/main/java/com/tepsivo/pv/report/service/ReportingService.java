package com.tepsivo.pv.report.service;

import com.tepsivo.pv.report.repository.DrugSafetyReportRepository;
import com.tepsivo.pv.report.repository.Report;
import com.tepsivo.pv.report.web.api.dto.ReportStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReportingService {

    private final DrugSafetyReportRepository repository;

    public ReportingService(DrugSafetyReportRepository repository) {
        this.repository = repository;
    }

    public void saveReport(Report report) {
        repository.save(report);
    }

    public Optional<Report> findById(String id) {
        return repository.findById(id);
    }

    public List<Report> getReportsByStatus(ReportStatus status) {
        return repository.findByStatus(status);
    }
}

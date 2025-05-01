package com.tepsivo.pv.report.service;

import com.tepsivo.pv.report.repository.DrugSafetyReportRepository;
import com.tepsivo.pv.report.repository.Report;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReportingService {

    private DrugSafetyReportRepository repository;

    public ReportingService(DrugSafetyReportRepository repository) {
        this.repository = repository;
    }

    public void saveReport(Report report) {
        repository.save(report);
    }

    public Optional<Report> findById(String id) {
        return repository.findById(id);
    }
}

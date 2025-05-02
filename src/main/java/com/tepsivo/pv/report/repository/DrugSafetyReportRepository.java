package com.tepsivo.pv.report.repository;

import com.tepsivo.pv.report.web.api.dto.ReportStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DrugSafetyReportRepository extends JpaRepository<Report, Long> {
    Optional<Report> findById(String id);

    List<Report> findByStatus(ReportStatus status);
}

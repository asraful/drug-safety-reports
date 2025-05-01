package com.tepsivo.pv.report.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DrugSafetyReportRepository extends CrudRepository<Report,Long> {
    Optional<Report> findById(String id);
}

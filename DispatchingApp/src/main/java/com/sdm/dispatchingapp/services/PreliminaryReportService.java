package com.sdm.dispatchingapp.services;

import com.sdm.dispatchingapp.domain.PreliminaryReport;
import com.sdm.dispatchingapp.repositories.PreliminaryReportRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PreliminaryReportService {
    private final PreliminaryReportRepository preliminaryReportRepository;

    public PreliminaryReportService(PreliminaryReportRepository preliminaryReportRepository) {
        this.preliminaryReportRepository = preliminaryReportRepository;
    }

    public void save(PreliminaryReport report) {
        preliminaryReportRepository.save(report);
    }

    public List<PreliminaryReport> findReports(){
        List<PreliminaryReport> reports = preliminaryReportRepository.findAll();
        return reports;
    }

    public PreliminaryReport findReport(Long id){
        Optional<PreliminaryReport> report = preliminaryReportRepository.findById(id);
        return report.orElse(null);
    }


}

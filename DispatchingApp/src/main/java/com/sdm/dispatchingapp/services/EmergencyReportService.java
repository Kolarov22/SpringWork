package com.sdm.dispatchingapp.services;

import com.sdm.dispatchingapp.domain.EmergencyReport;
import com.sdm.dispatchingapp.repositories.EmergencyCallRepository;
import com.sdm.dispatchingapp.repositories.EmergencyReportRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmergencyReportService {
    private final EmergencyReportRepository emergencyReportRepository;

    public EmergencyReportService(EmergencyReportRepository emergencyReportRepository) {
        this.emergencyReportRepository = emergencyReportRepository;
    }

    public void save(EmergencyReport report){
        emergencyReportRepository.save(report);
    }


    public List<EmergencyReport> findAll() {
        return emergencyReportRepository.findAll();
    }
}

package com.sdm.dispatchingapp.repositories;

import com.sdm.dispatchingapp.domain.EmergencyReport;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.Month;
import java.util.List;

@Repository
public interface EmergencyReportRepository extends CrudRepository<EmergencyReport, Long> {
    List<EmergencyReport> findAll();
}

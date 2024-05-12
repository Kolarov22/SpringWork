package com.sdm.dispatchingapp.repositories;

import com.sdm.dispatchingapp.domain.PreliminaryReport;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PreliminaryReportRepository extends CrudRepository<PreliminaryReport, Long> {
    List<PreliminaryReport> findAll();
}

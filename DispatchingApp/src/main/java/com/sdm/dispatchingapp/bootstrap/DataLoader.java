package com.sdm.dispatchingapp.bootstrap;

import com.sdm.dispatchingapp.domain.Dispatcher;
import com.sdm.dispatchingapp.domain.EmergencyCall;
import com.sdm.dispatchingapp.domain.PreliminaryReport;
import com.sdm.dispatchingapp.repositories.DispatcherRepository;
import com.sdm.dispatchingapp.repositories.EmergencyCallRepository;
import com.sdm.dispatchingapp.services.PreliminaryReportService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final PreliminaryReportService reportService;
    private final DispatcherRepository dispatcherRepository;
    private final EmergencyCallRepository emergencyCallRepository;

    public DataLoader(PreliminaryReportService reportService, DispatcherRepository dispatcherRepository, EmergencyCallRepository emergencyCallRepository) {
        this.reportService = reportService;
        this.dispatcherRepository = dispatcherRepository;
        this.emergencyCallRepository = emergencyCallRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        Dispatcher d1 = new Dispatcher("John");
        dispatcherRepository.save(d1);
        EmergencyCall call1 = new EmergencyCall("0723688809", "Bucharest", "fire");
        call1.setDispatcher(d1);
        emergencyCallRepository.save(call1);
        PreliminaryReport prelRep1 = new PreliminaryReport("Bucharest", "High");
        prelRep1.setEmergencyCall(call1);

        reportService.save(prelRep1);
    }
}

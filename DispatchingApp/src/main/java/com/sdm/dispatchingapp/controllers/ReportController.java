package com.sdm.dispatchingapp.controllers;

import com.sdm.dispatchingapp.domain.Dispatcher;
import com.sdm.dispatchingapp.domain.EmergencyCall;
import com.sdm.dispatchingapp.domain.EmergencyReport;
import com.sdm.dispatchingapp.domain.PreliminaryReport;
import com.sdm.dispatchingapp.services.EmergencyReportService;
import com.sdm.dispatchingapp.services.PreliminaryReportService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/reports")
public class ReportController {

    private final PreliminaryReportService preliminaryService;
    private final EmergencyReportService emergencyService;


    public ReportController(PreliminaryReportService preliminaryService, EmergencyReportService emergencyService) {
        this.preliminaryService = preliminaryService;
        this.emergencyService = emergencyService;
    }

    @GetMapping
    public String getAllReports(Model model) {
        model.addAttribute("reports", preliminaryService.findReports());
        return "preliminaryReports";
    }

    @GetMapping("/{id}")
    public String getReportById(@PathVariable Long id, Model model) {
        PreliminaryReport report = preliminaryService.findReport(id);
        model.addAttribute("report", report);
        return "reportDetails";
    }

    @PostMapping("emergencyReports")
    public String createEmergencyReport(@RequestParam Long preliminaryReportId, @RequestParam LocalDateTime issueDate, @RequestParam("status") String status, HttpSession session) {
        PreliminaryReport preliminaryReport = preliminaryService.findReport(preliminaryReportId);
        Dispatcher dispatcher = (Dispatcher) session.getAttribute("dispatcher");
        EmergencyCall emergencyCall = preliminaryReport.getEmergencyCall();
        emergencyCall.setDispatcher(dispatcher);
        preliminaryReport.setEmergencyCall(emergencyCall);
        EmergencyReport emergencyReport = new EmergencyReport(preliminaryReport, issueDate, status);
        emergencyService.save(emergencyReport);
        return "redirect:/reports/emergencyReports";
    }

    @GetMapping("emergencyReports")
    public String getAllEmergencyReports(Model model) {
        List<EmergencyReport> emergencyReports = emergencyService.findAll();
        model.addAttribute("emergencyReports", emergencyReports);
        return "emergencyReports";
    }
}

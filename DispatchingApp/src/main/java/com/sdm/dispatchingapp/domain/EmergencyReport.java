package com.sdm.dispatchingapp.domain;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class EmergencyReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private PreliminaryReport preliminaryReport;

    private LocalDateTime issueDate;
    private String status;

    public EmergencyReport() {
    }

    public EmergencyReport(LocalDateTime issueDate, String status) {
        this.issueDate = issueDate;
        this.status = status;
    }

    public EmergencyReport(PreliminaryReport preliminaryReport, LocalDateTime issueDate, String status) {
        this.preliminaryReport = preliminaryReport;
        this.issueDate = issueDate;
        this.status = status;
    }

    @Override
    public String toString() {
        return "EmergencyReport{" +
                "id=" + id +
                ", preliminaryReport=" + preliminaryReport +
                ", issueDate=" + issueDate +
                ", status='" + status + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PreliminaryReport getPreliminaryReport() {
        return preliminaryReport;
    }

    public void setPreliminaryReport(PreliminaryReport preliminaryReport) {
        this.preliminaryReport = preliminaryReport;
    }

    public LocalDateTime getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDateTime issueDate) {
        this.issueDate = issueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
package com.sdm.dispatchingapp.domain;
import jakarta.persistence.*;
@Entity
public class PreliminaryReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String location;
    private String priority;

    @OneToOne
    private EmergencyCall emergencyCall;

    public PreliminaryReport(String location, String priority) {
        this.location = location;
        this.priority = priority;
    }

    public PreliminaryReport() {

    }

    @Override
    public String toString() {
        return "PreliminaryReport{" +
                "id=" + id +
                ", location='" + location + '\'' +
                ", priority='" + priority + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public EmergencyCall getEmergencyCall() {
        return emergencyCall;
    }

    public void setEmergencyCall(EmergencyCall emergencyCall) {
        this.emergencyCall = emergencyCall;
    }
}

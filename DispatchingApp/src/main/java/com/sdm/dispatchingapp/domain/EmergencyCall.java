package com.sdm.dispatchingapp.domain;
import jakarta.persistence.*;

@Entity
public class EmergencyCall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String phoneNumber;
    private String location;
    private String description;
    @ManyToOne
    private Dispatcher dispatcher;

    public EmergencyCall(String phoneNumber, String location, String description) {
        this.phoneNumber = phoneNumber;
        this.location = location;
        this.description = description;
    }

    public EmergencyCall() {

    }


    @Override
    public String toString() {
        return "EmergencyCall{" +
                "id=" + id +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Dispatcher getDispatcher() {
        return dispatcher;
    }

    public void setDispatcher(Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }
}

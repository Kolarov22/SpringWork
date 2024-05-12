package com.sdm.dispatchingapp.domain;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
public class Dispatcher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "dispatcher")
    List<EmergencyCall> emergencyCalls = new ArrayList<>();

    public Dispatcher(String name) {
        this.name = name;
    }

    public Dispatcher() {

    }

    @Override
    public String toString() {
        return "Dispatcher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<EmergencyCall> getEmergencyCalls() {
        return emergencyCalls;
    }

    public void setEmergencyCalls(List<EmergencyCall> emergencyCalls) {
        this.emergencyCalls = emergencyCalls;
    }
}

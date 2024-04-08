package com.wad.firstmvc.bootstrap;

import com.wad.firstmvc.domain.*;
import com.wad.firstmvc.repositories.PatientRepository;
import com.wad.firstmvc.services.*;
import org.hibernate.TransientPropertyValueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;


@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    CareProviderService careProviderService;
    @Autowired
    HealthIssueService healthIssueService;
    @Autowired
    HealthServiceService healthServiceService;
    @Autowired
    MedicalEncounterService medicalEncounterService;
    @Autowired
    PatientService patientService;

    @Autowired
    PatientRepository patientRepository;

    @Override
    public void run(String... args) throws Exception {
        Patient john = new Patient("John");

        HealthIssue diabet = new HealthIssue("diabet zaharat");

        HealthService floreasca = new HealthService("insulina", "spital general");
        HealthService bucuresti_urgente = new HealthService("urgente", "spital urgente");

        CareProvider drJohn = new CareProvider("dr John", "cardiolog");
        CareProvider drEinstein = new CareProvider("dr. Einstein", "terapie intensiva");

        MedicalEncounter Encounter1 = new MedicalEncounter(john, LocalDate.parse("2022-11-21"));
        MedicalEncounter Encounter2 = new MedicalEncounter(john, LocalDate.parse("2013-03-21"));

        drJohn.addMedicalEncounter(Encounter1);
        Encounter1.addHealthService(floreasca);

        drEinstein.addMedicalEncounter(Encounter2);
        Encounter2.addHealthService(bucuresti_urgente);

        john.addMedicalEncounter(Encounter1);
        john.addMedicalEncounter(Encounter2);

        diabet.addHealthService(floreasca);
        diabet.addHealthService(bucuresti_urgente);

        john.addHealthIssue(diabet);

        careProviderService.save(drJohn);
        careProviderService.save(drEinstein);
        patientService.save(john);
        medicalEncounterService.save(Encounter1);
        medicalEncounterService.save(Encounter2);
        healthIssueService.save(diabet);
        healthServiceService.save(floreasca);
        healthServiceService.save(bucuresti_urgente);

        System.out.println("\n");

        System.out.println("All Patients");
        List<Patient> patients = patientService.findAll();
        patients.forEach(System.out::println);

        System.out.println("\n");

        System.out.println("all health issues");
        List<HealthIssue> healthIssuesByPatient = healthIssueService.findHealthIssuesByPatientName("John");
        //List<HealthIssue> healthIssuesByPatient = healthIssueService.findHealthIssuesByPatientName("Gion");
        healthIssuesByPatient.forEach(System.out::println);

        System.out.println("\n");


        System.out.println("Patients who had an accident on \"2022-11-21\"");
        List<Patient> patientsByDate = patientService.findPatientsByAccidentDate(LocalDate.parse("2022-11-21"));
        patientsByDate.forEach(System.out::println);

        System.out.println("\n");

        System.out.println("Patients who had an accident on \"2000-10-24\"");
        List<Patient> patientsByWrongDate = patientService.findPatientsByAccidentDate(LocalDate.parse("2000-10-24"));
        patientsByWrongDate.forEach(System.out::println);

        System.out.println("\n");

        System.out.println("Patients who had einstein as care provider");
        List<Patient> patientsMetEinstein = patientService.findPatientsByCareProvider("dr. Einstein");
        patientsMetEinstein.forEach(System.out::println);

        System.out.println("\n");

        System.out.println("Care providers who had patients with diabetes");
        List<CareProvider> careProvidersByHealthIssue = careProviderService.findCareProvidersByHistory("diabet zaharat");
        careProvidersByHealthIssue.forEach(System.out::println);

        System.out.println("\n");


    }
}

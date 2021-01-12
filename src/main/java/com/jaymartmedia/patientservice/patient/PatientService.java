package com.jaymartmedia.patientservice.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> getAllPatients() {
        List<Patient> patients = new ArrayList<>();
        patientRepository.findAll()
                .forEach(patients::add);
        return patients;
    }

    public Patient getPatient(UUID id) {
        return patientRepository.findById(id).orElse(null);
    }

    public void addPatient(Patient patient){
        patientRepository.save(patient);
    }

    public void updatePatient(UUID id, Patient patient){
        patientRepository.save(patient);
    }

    public void deletePatient(UUID id){
        patientRepository.deleteById(id);
    }
}
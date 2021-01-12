package com.jaymartmedia.patientservice.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;

    @RequestMapping("/patient")
    public List<Patient> getAllPatients(){
        return patientService.getAllPatients();
    }

    @RequestMapping("/patient/{id}")
    public Patient getPatient(@PathVariable UUID id){
        return patientService.getPatient(id);
    }

    @RequestMapping(method=RequestMethod.POST, value="/patient")
    public void addPatient(@RequestBody Patient patient){
        patientService.addPatient(patient);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/patient/{id}")
    public void updatePatient(@RequestBody Patient patient, @PathVariable UUID id){
        patientService.updatePatient(id, patient);
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/patient/{id}")
    public void deletePatient(@PathVariable UUID id){
        patientService.deletePatient(id);
    }
}
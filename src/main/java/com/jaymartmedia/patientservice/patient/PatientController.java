package com.jaymartmedia.patientservice.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class PatientController {

    private final String API_PATH = "/api/v1";

    @Autowired
    private PatientService patientService;

    @RequestMapping(API_PATH + "/patient")
    @PreAuthorize("hasAuthority('patient:read')")
    public List<Patient> getAllPatients(){
        return patientService.getAllPatients();
    }

    @RequestMapping(API_PATH + "/patient/{id}")
    @PreAuthorize("hasAuthority('patient:read')")
    public Patient getPatient(@PathVariable UUID id){
        return patientService.getPatient(id);
    }

    @RequestMapping(method=RequestMethod.POST, value=API_PATH + "/patient")
    @PreAuthorize("hasAuthority('patient:write')")
    public void addPatient(@RequestBody Patient patient){
        patientService.addPatient(patient);
    }

    @RequestMapping(method=RequestMethod.PUT, value=API_PATH + "/patient/{id}")
    @PreAuthorize("hasAuthority('patient:write')")
    public void updatePatient(@RequestBody Patient patient, @PathVariable UUID id){
        patientService.updatePatient(id, patient);
    }

    @RequestMapping(method=RequestMethod.DELETE, value=API_PATH + "/patient/{id}")
    @PreAuthorize("hasAuthority('patient:write')")
    public void deletePatient(@PathVariable UUID id){
        patientService.deletePatient(id);
    }
}
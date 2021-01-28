package com.jaymartmedia.patientservice.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;

    @RequestMapping("/patient")
    @PreAuthorize("hasAuthority('patient:read')")
    public List<Patient> getAllPatients(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(auth.getName());
        System.out.println(auth.getAuthorities());
        return patientService.getAllPatients();
    }

    @RequestMapping("/patient/{id}")
    @PreAuthorize("hasAuthority('patient:read')")
    public Patient getPatient(@PathVariable UUID id){
        return patientService.getPatient(id);
    }

    @RequestMapping(method=RequestMethod.POST, value="/patient")
    @PreAuthorize("hasAuthority('patient:write')")
    public void addPatient(@RequestBody Patient patient){
        patientService.addPatient(patient);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/patient/{id}")
    @PreAuthorize("hasAuthority('patient:write')")
    public void updatePatient(@RequestBody Patient patient, @PathVariable UUID id){
        patientService.updatePatient(id, patient);
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/patient/{id}")
    @PreAuthorize("hasAuthority('patient:write')")
    public void deletePatient(@PathVariable UUID id){
        patientService.deletePatient(id);
    }
}
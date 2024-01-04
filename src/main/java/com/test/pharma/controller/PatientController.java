package com.test.pharma.controller;

import com.test.pharma.model.Patient;
import com.test.pharma.service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/patients")
@AllArgsConstructor
public class PatientController {

    @Autowired
    PatientService patientService;

    @GetMapping
    public Iterable<Patient> getAllPatients() {
        return patientService.getAllPatient();
    }

    @PostMapping
    public Patient addNewPatient(@RequestBody Patient patient) {
        return patientService.addPatient(patient);
    }

    @PutMapping("/{id}")
    public Optional<Patient> updatePatientById(@PathVariable Long id, @RequestBody Patient patient){
        return patientService.updatePatient(id, patient);
    }

    @GetMapping("/{id}")
    public Optional<Patient> patientById(@PathVariable Long id){return patientService.getPatientById(id);}

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable Long id){
        patientService.deletePatient(id);
    }

}

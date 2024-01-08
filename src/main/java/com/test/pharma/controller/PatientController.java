package com.test.pharma.controller;

import com.test.pharma.DTO.PatientDTO;
import com.test.pharma.model.Patient;
import com.test.pharma.service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/find-dto/{socialSecurityNumber}")
    public ResponseEntity<PatientDTO> findPatientDTOBySocialSecurityNumber(@PathVariable String socialSecurityNumber) {
        PatientDTO patientDTO = patientService.findPatientDTOBySocialSecurityNumber(socialSecurityNumber);

        if (patientDTO != null) {
            return new ResponseEntity<>(patientDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

package com.test.pharma.service;

import com.test.pharma.DTO.PatientDTO;
import com.test.pharma.model.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientService {

    Patient addPatient(Patient patient);

    List<Patient> getAllPatient();

    Optional<Patient> getPatientById(Long id);

    void deletePatient(Long id);

    Optional<Patient> updatePatient(Long id, Patient patient);

    PatientDTO findPatientDTOBySocialSecurityNumber(String socialSecurityNumber);
}

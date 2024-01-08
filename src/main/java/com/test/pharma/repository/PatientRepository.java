package com.test.pharma.repository;

import com.test.pharma.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    Patient findBySocialSecurityNumber(String socialSecurityNumber);
}

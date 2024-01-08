package com.test.pharma.service;

import com.test.pharma.DTO.PatientDTO;
import com.test.pharma.model.Mutuelle;
import com.test.pharma.model.Patient;
import com.test.pharma.repository.MutuelleRepository;
import com.test.pharma.repository.PatientRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService{

    @Autowired
    PatientRepository patientRepository;
    @Autowired
    private MutuelleRepository mutuelleRepository;


    @Override
    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public List<Patient> getAllPatient() {
        return patientRepository.findAll();
    }

    @Override
    public Optional<Patient> getPatientById(Long id) {
        return patientRepository.findById(id);
    }

    @Override
    public void deletePatient(Long id) {
       patientRepository.deleteById(id);
    }

    @Override
    public Optional<Patient> updatePatient(Long id, Patient patient) {
        return patientRepository.findById(id).map(p->{
            p.setFirstName(patient.getFirstName());
            p.setLastName(patient.getLastName());
            p.setAddress(patient.getAddress());
            p.setSocialSecurityNumber(patient.getSocialSecurityNumber());
            p.setPrimaryHealthInsurance(patient.getPrimaryHealthInsurance());
            p.setMutuelleId(patient.getMutuelleId());
            return patientRepository.save(p);
        });
    }

    @Override
    public PatientDTO findPatientDTOBySocialSecurityNumber(String socialSecurityNumber) {
        Patient patient = patientRepository.findBySocialSecurityNumber(socialSecurityNumber);

        if (patient != null) {
            PatientDTO patientDTO = new PatientDTO();
            BeanUtils.copyProperties(patient, patientDTO);

            // Fetch Mutuelle information using mutuelleId from patient
            Mutuelle mutuelle = mutuelleRepository.findById(patient.getMutuelleId())
                    .orElse(new Mutuelle());  // Handle the case if mutuelle not found

            // Copy relevant Mutuelle properties to PatientDTO
            patientDTO.setMutuelleName(mutuelle.getName());
            patientDTO.setTeletransmissionNumber(mutuelle.getTeletransmissionNumber());

            return patientDTO;
        }

        return null;  // Handle the case if patient not found
    }

}

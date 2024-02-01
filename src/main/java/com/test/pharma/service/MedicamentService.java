package com.test.pharma.service;

import com.test.pharma.model.Medicament;

import java.util.List;
import java.util.Optional;

public interface MedicamentService {
    Medicament addMedicament(Medicament medicament);

    List<Medicament> getMedicaments();

    Optional<Medicament> getMedicamentById(Long id);

    void deleteMedicament(Long id);

    Optional<Medicament> updateMedicament(Long id, Medicament medicament);
}

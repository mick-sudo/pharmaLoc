package com.test.pharma.service;

import com.test.pharma.model.Mutuelle;
import com.test.pharma.model.Patient;

import java.util.List;
import java.util.Optional;

public interface MutuelleService {

    Mutuelle addMutuelle(Mutuelle mutuelle);

    List<Mutuelle> getMutuelle();

    Optional<Mutuelle> getMutuelleById(Long id);

    void deleteMutuelle(Long id);
}

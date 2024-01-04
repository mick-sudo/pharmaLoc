package com.test.pharma.service;

import com.test.pharma.model.Mutuelle;
import com.test.pharma.model.Patient;
import com.test.pharma.repository.MutuelleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MutuelleServiceImpl implements MutuelleService{
    @Autowired
    MutuelleRepository mutuelleRepository;

    @Override
    public Mutuelle addMutuelle(Mutuelle mutuelle) {
        return mutuelleRepository.save(mutuelle);
    }

    @Override
    public List<Mutuelle> getMutuelle() {
        return mutuelleRepository.findAll();
    }

    @Override
    public Optional<Mutuelle> getMutuelleById(Long id) {
        return mutuelleRepository.findById(id);
    }

    @Override
    public void deleteMutuelle(Long id) {
        mutuelleRepository.deleteById(id);
    }

    @Override
    public Optional<Mutuelle> updateMutuel(Long id, Mutuelle mutuelle) {
        return mutuelleRepository.findById(id).map(m->{
            m.setName(mutuelle.getName());
            m.setTeletransmissionNumber(mutuelle.getTeletransmissionNumber());
            return mutuelleRepository.save(m);
        });
    }

}

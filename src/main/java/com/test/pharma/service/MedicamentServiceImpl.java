package com.test.pharma.service;

import com.test.pharma.model.Medicament;
import com.test.pharma.repository.MedicamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicamentServiceImpl implements MedicamentService{

    @Autowired
    MedicamentRepository medicamentRepository;

    @Override
    public Medicament addMedicament(Medicament medicament) {
        return medicamentRepository.save(medicament);
    }

    @Override
    public List<Medicament> getMedicaments() {
        return medicamentRepository.findAll();
    }

    @Override
    public Optional<Medicament> getMedicamentById(Long id) {
        return medicamentRepository.findById(id);
    }

    @Override
    public void deleteMedicament(Long id) {
        medicamentRepository.deleteById(id);
    }

    @Override
    public Optional<Medicament> updateMedicament(Long id, Medicament medicament) {
        return medicamentRepository.findById(id).map(m->{
            m.setNomCommercial(medicament.getNomCommercial());
            m.setDci(medicament.getDci());
            m.setLaboratoire(medicament.getLaboratoire());
            m.setForme(medicament.getForme());
            m.setNombreComprimes(medicament.getNombreComprimes());
            m.setContenanceMl(medicament.getContenanceMl());
            return medicamentRepository.save(m);
        });
    }
}

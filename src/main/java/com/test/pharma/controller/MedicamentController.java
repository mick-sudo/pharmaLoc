package com.test.pharma.controller;

import com.test.pharma.model.Medicament;
import com.test.pharma.service.MedicamentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/medicaments")
@AllArgsConstructor
public class MedicamentController {

    @Autowired
    MedicamentService medicamentService;

    @PostMapping
    public Medicament addMedicament(@RequestBody Medicament medicament){
        return  medicamentService.addMedicament(medicament);
    }

    @GetMapping("/{id}")
    public Optional <Medicament> getMedicamentById(@PathVariable Long id){
        return medicamentService.getMedicamentById(id);
    }

    @GetMapping
    public Iterable<Medicament> getAllMedicament() {
        return medicamentService.getMedicaments();
    }

    @PutMapping("/{id}")
    public Optional<Medicament> updateMedicamentById(@PathVariable Long id, @RequestBody Medicament medicament){
        return medicamentService.updateMedicament(id, medicament);
    }

}

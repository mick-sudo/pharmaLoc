package com.test.pharma.controller;

import com.test.pharma.model.Mutuelle;
import com.test.pharma.service.MutuelleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@RestController
@RequestMapping("/mutuelles")
@AllArgsConstructor
public class MutuelleController {
    
    @Autowired
    MutuelleService mutuelleService;

    @GetMapping
    public Iterable<Mutuelle> getAllMutuelles() {
        return mutuelleService.getMutuelle();
    }

    @PostMapping
    public Mutuelle addNewMutuelle(@RequestBody Mutuelle mutuelle) {
        return mutuelleService.addMutuelle(mutuelle);
    }

    @GetMapping("/{id}")
    public Optional<Mutuelle> mutuelleById(@PathVariable Long id){return mutuelleService.getMutuelleById(id);}

    @DeleteMapping("/{id}")
    public void deleteMutuel(@PathVariable Long id){
        mutuelleService.deleteMutuelle(id);
    }
}

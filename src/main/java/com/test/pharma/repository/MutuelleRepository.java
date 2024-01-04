package com.test.pharma.repository;

import com.test.pharma.model.Mutuelle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MutuelleRepository extends JpaRepository<Mutuelle, Long> {
}

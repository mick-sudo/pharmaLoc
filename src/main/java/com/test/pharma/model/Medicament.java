package com.test.pharma.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "medicaments")
@Data
public class Medicament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomCommercial;
    private String dci;
    private String laboratoire;
    private String forme;
    private Integer nombreComprimes;
    private Integer contenanceMl;
}

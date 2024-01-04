package com.test.pharma.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "mutuelles")
@Data
public class Mutuelle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String teletransmissionNumber;


}

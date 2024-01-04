package com.test.pharma.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "patients")
@Data
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String socialSecurityNumber;
    private String primaryHealthInsurance;
    private Long mutuelleId;


}

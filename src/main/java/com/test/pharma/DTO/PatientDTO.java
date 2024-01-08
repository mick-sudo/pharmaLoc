package com.test.pharma.DTO;

import lombok.Data;

@Data
public class PatientDTO {
    private String firstName;
    private String lastName;
    private String address;
    private String socialSecurityNumber;
    private String primaryHealthInsurance;
    private String mutuelleName;
    private String teletransmissionNumber;
}

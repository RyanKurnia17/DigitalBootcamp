package com.example.multipolar.bootcamp.gateway.dto;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class CustomerDTO implements Serializable{
    private String id;
    private String nik;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private LocalDate dateOfBirth;
    private MembershipStatus membershipStatus;
    private Address address;
}


enum MembershipStatus {
    FREE,
    STANDART,
    PREMIUM,
    VIP
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Address implements Serializable {
    private String street;
    private String city;
    private String state;
    private String postalCode;
    private String country;
}

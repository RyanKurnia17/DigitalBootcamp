package com.multipolar.bootcamp.gateway.dto;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class AccountDTO implements Serializable{
    private String id;
    private String accountNumber;
    private AccountType accountType;
    private AccountStatus accountStatus;
    private AccountHolder accountHolder;
    private Double balance;
    private LocalDateTime openingDate = LocalDateTime.now();
    private LocalDate closingDate;
}


enum AccountType{
    SAVINGS,
    CHECKING,
    CERTIFICATE_OF_DEPOSIT
}

enum AccountStatus{
    OPEN,
    CLOSED,
    FROZEN,
    SPECIAL_STATUS
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class AccountHolder implements Serializable {
    private String nik;
    private String name;
    private String address;
}
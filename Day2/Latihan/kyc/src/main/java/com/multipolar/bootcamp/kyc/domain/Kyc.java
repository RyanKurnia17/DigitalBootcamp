package com.multipolar.bootcamp.kyc.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode //untuk menjamin nilai unik
@Document//apabila ingin nama collectionnya sama maka tidak perlu dikasih atribut
public class Kyc {
    @Id
    private String id;
    @NotEmpty(message = "Task cannot be empty")
    private String nik;

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private LocalDate dateOfBirth;
}
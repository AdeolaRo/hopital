package org.example.hopital.model;

import jakarta.persistence.*;
import jakarta.servlet.annotation.MultipartConfig;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name= "PATIENT_ID")
    Long id;
    @Column(name= "NAME")
    String name;
    @Column(name= "TELEPHONE")
    String phone;
    @Column(name= "DOB")
    LocalDate birthDate;
    @Column(name= "IMAGE")
    String photo;


    public Patient(String name, String phone, LocalDate birthDate, String photo) {
        this.name = name;
        this.phone = phone;
        this.birthDate = birthDate;
        this.photo = photo;
    }


}

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
@MultipartConfig(maxFileSize = 1024*1024*10) // Limite de 10 MB (10 mégaoctets) pour chaque fichier

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
    String file;


    public Patient(String name, String phone, LocalDate birthDate, String file) {
        this.name = name;
        this.phone = phone;
        this.birthDate = birthDate;
        this.file = file;
    }


}

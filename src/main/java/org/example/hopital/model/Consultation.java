package org.example.hopital.model;


import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CONSULTATION_ID")
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date dateConsultation;
    @Column(name="NOM_MEDECIN")
    private String nomMedecin;
    @Column(name="PRESCRIPTION")
    private String prescription;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @OneToMany(mappedBy = "consultation", cascade = CascadeType.ALL)
    private List<FicheDeSoin> fichesDeSoin;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateConsultation() {
        return dateConsultation;
    }

    public void setDateConsultation(Date dateConsultation) {
        this.dateConsultation = dateConsultation;
    }

    public String getNomMedecin() {
        return nomMedecin;
    }

    public void setNomMedecin(String nomMedecin) {
        this.nomMedecin = nomMedecin;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public List<FicheDeSoin> getFichesDeSoin() {
        return fichesDeSoin;
    }

    public void setFichesDeSoin(List<FicheDeSoin> fichesDeSoin) {
        this.fichesDeSoin = fichesDeSoin;
    }
}

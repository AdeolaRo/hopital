package org.example.hopital.model;


import jakarta.persistence.*;



@Entity
public class FicheDeSoin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="FICHE_SOIN_ID")
    private Long id;

    @Column(name="CONTENU")
    private String contenu;

    @ManyToOne
    @JoinColumn(name = "consultation_id")
    private Consultation consultation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Consultation getConsultation() {
        return consultation;
    }

    public void setConsultation(Consultation consultation) {
        this.consultation = consultation;
    }

}

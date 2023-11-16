package com.gestionEvent.handlerService.HandlerService.entities;

import java.util.Date;
//import java.util.List;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Evenement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date dateEvenement;
    private String typeEvenement;
    private String lieu;
    private String description;
    private String serviceRequis;
    private int budget;
    private Date dateDebut; // Ajout de l'attribut date de début
    private Date dateFin;   // Ajout de l'attribut date de fin


    public Evenement() {}; //Constructeur par defaut

    public Evenement(String typeEvenement, Date dateEvenement, String lieu, String description,
            String serviceRequis, int budget, Date dateDebut, Date dateFin, Client client) {
        this.typeEvenement = typeEvenement;
        this.dateEvenement = dateEvenement;
        this.lieu = lieu;
        this.description = description;
        this.serviceRequis = serviceRequis;
        this.budget = budget;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.client = client;
    }

//-------------Gerer les relation entre les tables  

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy="evenement")
    private List<Prestataire> prestataires;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client")
    private Client client;


    public List<Prestataire> getPrestataires() {
    return prestataires;
    }

    public void setPrestataires(List<Prestataire> prestataires) {
        this.prestataires = prestataires;
    }

    public long getId() {
        return id;
    }

    public Date getDateEvenement() {
        return dateEvenement;
    }

    public void setDateEvenement(Date dateEvenement) {
        this.dateEvenement = dateEvenement;
    }

    public String getTypeEvenement() {
        return typeEvenement;
    }

    public void setTypeEvenement(String typeEvenement) {
        this.typeEvenement = typeEvenement;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getServiceRequis() {
        return serviceRequis;
    }

    public void setServiceRequis(String serviceRequis) {
        this.serviceRequis = serviceRequis;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }
} 
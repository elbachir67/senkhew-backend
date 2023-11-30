package com.gestionEvent.handlerService.HandlerService.entities;

import java.time.LocalDate;
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
    private String nomEvenement;
    private String dateEvenement;
    private String typeEvenement;
    private String lieu;
    private String description;
    private int budget;
    private int duree;



    public Evenement() {}; //Constructeur par defaut

    public Evenement(String nomEvenement, String typeEvenement, String dateEvenement, String lieu, String description,
            int budget,int duree, Client client, List<Prestataire> prestataires) {
        this.nomEvenement = nomEvenement;
        this.typeEvenement = typeEvenement;
        this.dateEvenement = dateEvenement;
        this.lieu = lieu;
        this.description = description;
        this.budget = budget;
        this.duree = duree;
        this.client = client;
        this.prestataires=prestataires;
    }

//-------------Gerer les relation entre les tables  

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy="evenement")
    private List<Prestataire> prestataires;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client")
    private Client client;


    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Prestataire> getPrestataires() {
    return prestataires;
    }

    public void setPrestataires(List<Prestataire> prestataires) {
        this.prestataires = prestataires;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getNomEvenement() {
        return nomEvenement;
    }

    public void setNomEvenement(String nomEvenement) {
        this.nomEvenement = nomEvenement;
    }

    public String getDateEvenement() {
        return dateEvenement;
    }

    public void setDateEvenement(String dateEvenement) {
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

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }
} 
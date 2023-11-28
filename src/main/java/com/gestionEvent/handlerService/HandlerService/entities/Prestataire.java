package com.gestionEvent.handlerService.HandlerService.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;

@Entity
public class Prestataire {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(nullable=false, updatable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String nom;
    private String prenom;
    private String nomEntreprise ;
    private String desEntreprise ;
    private String telephone;
    private String adresse;
    private int note; // Note sous forme d'entier
    private String fonction;
    private String email;
    private int tarif;

    @Column(nullable=false, unique=true)
    private String username;

    @Column(nullable=false)
    private String password;
 
    @Column(nullable=false)
    private String role;


    private String image;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Prestataire(){};

    public Prestataire(Evenement evenement,String nom, String prenom, String nomEntreprise, String desEntreprise,
            String telephone, String adresse, String email, String fonction, String username, String password, int tarif, int note , String image, 
            String role) {
        this.evenement = evenement;
        this.nom = nom;
        this.prenom = prenom;
        this.nomEntreprise = nomEntreprise;
        this.desEntreprise = desEntreprise;
        this.telephone = telephone;
        this.adresse = adresse;
        this.email = email;
        this.fonction = fonction;
        this.username = username;
        this.password = password;
        this.role = role;
        this.note = note;
        this.tarif = tarif;
        this.image = image;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "evenement")
    private Evenement evenement;
 
    public String getStarRating() {
        // Convertir la note en étoiles
        StringBuilder stars = new StringBuilder();
        for (int i = 0; i < note; i++) {
            stars.append("★");
        }
        return stars.toString();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getId_pres() {
        return id;
    }

    public void setId_pres(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNomEntreprise() {
        return nomEntreprise;
    }

    public void setNomEntreprise(String nomEntreprise) {
        this.nomEntreprise = nomEntreprise;
    }

    public String getDesEntreprise() {
        return desEntreprise;
    }

    public void setDesEntreprise(String desEntreprise) {
        this.desEntreprise = desEntreprise;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getNote() {
        return note;
    }

    public int getTarif() {
        return tarif;
    }

    public void setTarif(int tarif) {
        this.tarif = tarif;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public Evenement getEvenement() {
        return evenement;
    }

    public void setEvenement(Evenement evenement) {
        this.evenement = evenement;
    }
    
}

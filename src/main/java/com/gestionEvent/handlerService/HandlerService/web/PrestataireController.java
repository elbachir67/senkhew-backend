package com.gestionEvent.handlerService.HandlerService.web;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.MediaType;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gestionEvent.handlerService.HandlerService.HandlerServiceApplication;
import com.gestionEvent.handlerService.HandlerService.entities.Prestataire;
import com.gestionEvent.handlerService.HandlerService.service.PrestataireService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@AllArgsConstructor
@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
public class PrestataireController {
    
    private final PrestataireService prestataireService;

    private static final Logger logger = LoggerFactory.getLogger(HandlerServiceApplication.class);

    @PostMapping(path = "/inscriptionPrestataire")
    public void inscription(@RequestBody Prestataire prestataire){
        logger.info("InscriptionPrestataire");
        prestataireService.inscription(prestataire);
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Prestataire addPrestataire(@RequestParam("image") MultipartFile file,
            // @RequestParam("nom") String nom,
            // @RequestParam("prenom") String prenom,
            // @RequestParam("adresse") String adresse,
            // @RequestParam("fonction") String fonction,
            // @RequestParam("email") String email,
            // @RequestParam("note") int note,
            // @RequestParam("telephone") String telephone,
            // @RequestParam("nomEntreprise") String nomEntreprise,
            // @RequestParam("desEntreprise") String desEntreprise,
            // @RequestParam("tarif") int tarif    
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("role") String role                       
    ) throws JsonProcessingException {

        Prestataire prestataire = new Prestataire();
        // prestataire.setNom(nom);
        // prestataire.setPrenom(prenom);
        // prestataire.setAdresse(adresse);
        // prestataire.setFonction(fonction);
        // prestataire.setEmail(email);
        // prestataire.setNote(note);
        // prestataire.setTelephone(telephone);
        // prestataire.setNomEntreprise(nomEntreprise);
        // prestataire.setDesEntreprise(desEntreprise);
        // prestataire.setTarif(tarif);
        prestataire.setUsername(username);
        prestataire.setPassword(password);
        prestataire.setRole(role);

        String repertoireImage = "src/main/resources/images"; // Remplacez par le chemin souhaité pour le répertoire "images"
        File repertoire = new File(repertoireImage);
        if (!repertoire.exists()) {
            boolean repertoireCree = repertoire.mkdirs();
            if (!repertoireCree) {
                // Gestion de l'erreur si le répertoire ne peut pas être créé
                throw new RuntimeException("Impossible de créer le répertoire 'images'");
            }
        }
        String nomFichier = file.getOriginalFilename();
        String nouveauNom = FilenameUtils.getBaseName(nomFichier) + "." + FilenameUtils.getExtension(nomFichier);
        File fichierDuServeur = new File(repertoire, nouveauNom);
        try {
            FileUtils.writeByteArrayToFile(fichierDuServeur, file.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        prestataire.setImage(nouveauNom);
        return prestataireService.add(prestataire);
    }
}    

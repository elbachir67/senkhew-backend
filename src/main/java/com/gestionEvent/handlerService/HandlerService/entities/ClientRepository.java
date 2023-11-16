package com.gestionEvent.handlerService.HandlerService.entities;

import java.util.Optional;

// import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="clients")
public interface ClientRepository extends CrudRepository <Client, Long> { 
    
    Optional<Client> findByUsername(String username);

    // List<Client> findByMotDePasse(@Param("motDePasse") String motDePasse);

    // List<Client> findByPrenom(@Param("prenom") String prenom);

    // List<Client> findByNom(@Param("nom") String nom);
}


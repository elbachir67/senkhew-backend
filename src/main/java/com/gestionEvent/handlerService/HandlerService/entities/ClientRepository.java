package com.gestionEvent.handlerService.HandlerService.entities;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(path = "clients")
public interface ClientRepository extends CrudRepository <Client, Long> { 

    Optional<Client> findByUsername(String username);

    @Query("SELECT c.id FROM Client c WHERE c.username = :username")
    Long findIdUsername(@Param("username") String username);

    @Query("SELECT c.role FROM Client c WHERE c.username = :username")
    String findRoleUsername(@Param("username") String username);

    // List<Client> findByMotDePasse(@Param("motDePasse") String motDePasse);

    // List<Client> findByPrenom(@Param("prenom") String prenom);

    // List<Client> findByNom(@Param("nom") String nom);
}


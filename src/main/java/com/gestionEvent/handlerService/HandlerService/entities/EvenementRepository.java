package com.gestionEvent.handlerService.HandlerService.entities;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="evenements")
public interface EvenementRepository extends  CrudRepository <Evenement, Long> {

}
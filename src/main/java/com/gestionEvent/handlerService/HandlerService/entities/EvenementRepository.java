package com.gestionEvent.handlerService.HandlerService.entities;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gestionEvent.handlerService.HandlerService.entities.Evenement;

import java.util.List;

import java.util.Date;

@Repository
public interface EvenementRepository extends  CrudRepository <Evenement, Long> {



}
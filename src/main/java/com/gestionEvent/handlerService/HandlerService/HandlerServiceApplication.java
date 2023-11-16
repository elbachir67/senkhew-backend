package com.gestionEvent.handlerService.HandlerService;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import com.gestionEvent.handlerService.HandlerService.entities.*;


@SpringBootApplication
public class HandlerServiceApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(HandlerServiceApplication.class);

	@Autowired
	private EvenementRepository erepository;

	@Autowired
	private ClientRepository crepository;

	@Autowired PrestataireRepository prepository;

	public static void main(String[] args) {
		SpringApplication.run(HandlerServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{

		// Client c1 = new Client("Ndiaye","Pape",12,"M","7729389302","Dakar","","","","");
		Client c2 = new Client("Coly","Ousmane",17,"M","335776578","Fatick","coly@gmail.com","admin","$2a$10$8cjz47bjbR4Mn8GMg9IZx.vyjhLXR/SKKMSZ9.mP9vpMu0ssKi8GW","ADMIN");
		Client c3 = new Client("Doumbia","Fatou",45,"F","789340348","Ziguinchor","diagne@gmail.com","user","$2a$10$NVM0n8ElaRgg7zWO1CxUdei7vWoPg91Lz2aYavh9.f9q0e4bRadue","USER");
		crepository.saveAll(Arrays.asList(c3,c2));

		Date d = new Date(2023,12,28);

		// Evenement e1 = new Evenement();
		// Evenement e2 = new Evenement();
		// Evenement e3 = new Evenement();	
		Evenement e4 = new Evenement("Mariage",d,"Dakar","bonjour daffy duck","restauration",600000,d,d,c3);
		erepository.saveAll(Arrays.asList(e4));



		byte[] byteArray = new byte[10];

		Prestataire p1 = new Prestataire(e4,"Kama","Faly","6Point9","kfjsdgnfkjdjfdbkds","339089485","Dakar","coly@gmail.com","Habilleur","admin","$2a$10$8cjz47bjbR4Mn8GMg9IZx.vyjhLXR/SKKMSZ9.mP9vpMu0ssKi8GW",5,byteArray,"ADMIN");
		prepository.saveAll(Arrays.asList(p1));

		// for (Prestataire pres : prepository.findAll()){
		// 	logger.info(pres.getNomEntreprise()+" "+pres.getFonction());
		// }



	}


}

package com.gestionEvent.handlerService.HandlerService.web;


import com.gestionEvent.handlerService.HandlerService.HandlerServiceApplication;
import com.gestionEvent.handlerService.HandlerService.entities.Client;
import com.gestionEvent.handlerService.HandlerService.service.ClientService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;

import java.util.List;

@AllArgsConstructor
@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
public class ClientController {

	private static final Logger logger = LoggerFactory.getLogger(HandlerServiceApplication.class);

    private final ClientService clientService;


    @PostMapping(path = "/inscriptionClient")
    public void inscription(@RequestBody Client client){
        logger.info("InscriptionClient");
        clientService.inscription(client);
    }


    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/{id}")
    public Client getClientById(@PathVariable Long id) {
        return clientService.getClientById(id);
    }

    @PostMapping("/new-client")
    public Client createClient(@RequestBody Client client) {
        return clientService.createClient(client);
    }

    @PutMapping("/{id}")
    public Client updateClient(@PathVariable Long id, @RequestBody Client client) {
        return clientService.updateClient(id, client);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
    }
}
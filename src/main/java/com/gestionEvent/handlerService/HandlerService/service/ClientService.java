package com.gestionEvent.handlerService.HandlerService.service;

import com.gestionEvent.handlerService.HandlerService.entities.Client;
import com.gestionEvent.handlerService.HandlerService.entities.ClientRepository;
import com.gestionEvent.handlerService.HandlerService.entities.PrestataireRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



@Service
public class ClientService {

    private final ClientRepository clientRepository;

    private BCryptPasswordEncoder passwordEncoder;

    public void inscription(Client client){
        String mdpCrypte = this.passwordEncoder.encode(client.getPassword());
        client.setPassword(mdpCrypte);
        client.setRole("CLIENT");
        clientRepository.save(client);
    }

    public ClientService(ClientRepository clientRepository, BCryptPasswordEncoder passwordEncoder){
        this.clientRepository=clientRepository;
        this.passwordEncoder=passwordEncoder;
    }

    public Long getIdUsername(String username){
        return clientRepository.findIdUsername(username);
    }

    public String getRoleUsername(String username){
        return clientRepository.findRoleUsername(username);
    }

    public List<Client> getAllClients() {
        Iterable<Client> clientsIterable = clientRepository.findAll();
        List<Client> clientsList = new ArrayList<>();

        clientsIterable.forEach(clientsList::add);

        return clientsList;
    }

    public Client getClientById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    public Client updateClient(Long id, Client client) {
        if (clientRepository.existsById(id)) {
            client.setId(id);
            return clientRepository.save(client);
        }
        return null;
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

}



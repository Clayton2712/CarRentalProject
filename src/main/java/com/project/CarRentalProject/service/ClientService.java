package com.project.CarRentalProject.service;

import com.project.CarRentalProject.model.Client;
import com.project.CarRentalProject.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    @Autowired //Inject ClientRepo
    public ClientService(ClientRepository clientRepository) {this.clientRepository = clientRepository;}

    public Client addClient(Client client){return clientRepository.save(client);}

    public List<Client> getAllClients(){return clientRepository.findAll();}



}

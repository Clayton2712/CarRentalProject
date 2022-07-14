package com.project.CarRentalProject.service;

import com.project.CarRentalProject.model.Car;
import com.project.CarRentalProject.model.Client;
import com.project.CarRentalProject.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    @Autowired //Inject ClientRepo
    public ClientService(ClientRepository clientRepository) {this.clientRepository = clientRepository;}

    public Client addClient(Client client){return clientRepository.save(client);}

    public List<Client> getAllClients(){return clientRepository.findAll();}

    public Client getClientById(Long id){return clientRepository.getReferenceById(id);}

    public Client deleteClientById(Long id){
        Client client = getClientById(id);
        clientRepository.delete(client);
        return client;
    }

    @Transactional
    public Client updateClientById(Long id, Client client){
        Client clientUpdater = getClientById(id);

        clientUpdater.setClientName(client.getClientName());
        clientUpdater.setClientCellNum(client.getClientCellNum());

        return clientRepository.save(clientUpdater);
    }

}

package com.project.CarRentalProject.controller;

import com.project.CarRentalProject.model.Client;
import com.project.CarRentalProject.model.DTOs.ClientDTO;
import com.project.CarRentalProject.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/client")
public class ClientController {
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {this.clientService = clientService;}

    //CRUD
    @PostMapping
    public ResponseEntity<ClientDTO> addClient (@RequestBody final ClientDTO clientDTO){
        Client newClient = clientService.addClient(Client.from(clientDTO));

        return new ResponseEntity<>(ClientDTO.from(newClient), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ClientDTO>> getAllClients(){
        List<Client> allClients = clientService.getAllClients();
        List<ClientDTO> clientsDTO = allClients.stream().map(ClientDTO::from).collect(Collectors.toList());

        return new ResponseEntity<>(clientsDTO, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<ClientDTO> getClientById(@PathVariable final Long id){
        Client client = clientService.getClientById(id);

        return new ResponseEntity<>(ClientDTO.from(client),HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<ClientDTO> deleteClient(@PathVariable final Long id){
        Client deletedClient = clientService.deleteClientById(id);

        return new ResponseEntity<>(ClientDTO.from(deletedClient), HttpStatus.OK);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<ClientDTO> updateClient(@PathVariable final Long id, @RequestBody final ClientDTO clientDTO){
        Client updatedClient = clientService.updateClientById(id, Client.from(clientDTO));

        return new ResponseEntity<>(ClientDTO.from(updatedClient), HttpStatus.OK);
    }
}

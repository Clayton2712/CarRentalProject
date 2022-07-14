package com.project.CarRentalProject.model;

import com.project.CarRentalProject.model.DTOs.ClientDTO;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long clientId;

    @Column(unique = true, nullable = false)
    private String clientCellNum;

    private String clientName;

    public static Client from(ClientDTO clientDTO){
        Client client = new Client();
        client.setClientName(clientDTO.getClientName());
        client.setClientCellNum(clientDTO.getClientCellNum());

        return client;
    }
}

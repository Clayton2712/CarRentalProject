package com.project.CarRentalProject.model.DTOs;

import com.project.CarRentalProject.model.Client;
import lombok.Data;

@Data
public class ClientDTO {
    private Long clientId;
    private String clientCellNum;
    private String clientName;

    public static ClientDTO from(Client client){
        ClientDTO clientDTO = new ClientDTO();

        clientDTO.setClientId(client.getClientId());
        clientDTO.setClientName(client.getClientName());
        clientDTO.setClientCellNum(client.getClientCellNum());

        return clientDTO;
    }

}

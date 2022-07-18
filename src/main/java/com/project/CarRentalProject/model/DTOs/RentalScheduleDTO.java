package com.project.CarRentalProject.model.DTOs;

import com.project.CarRentalProject.model.Car;
import com.project.CarRentalProject.model.Client;
import com.project.CarRentalProject.model.RentalSchedule;
import lombok.Data;

import java.sql.Date;

@Data
public class RentalScheduleDTO {

    private Long rentalId;
    private Date collectionDate;
    private Date returnDate;
    private Client client;
    private Car car;

    public static RentalScheduleDTO from(RentalSchedule rentalSchedule){
        RentalScheduleDTO rentalScheduleDTO = new RentalScheduleDTO();

        rentalScheduleDTO.setRentalId(rentalSchedule.getRentalId());
        rentalScheduleDTO.setClient(rentalSchedule.getClient());
        rentalScheduleDTO.setCar(rentalSchedule.getCar());
        rentalScheduleDTO.setCollectionDate(rentalSchedule.getCollectionDate());
        rentalScheduleDTO.setReturnDate(rentalSchedule.getReturnDate());

        return rentalScheduleDTO;
    }
}

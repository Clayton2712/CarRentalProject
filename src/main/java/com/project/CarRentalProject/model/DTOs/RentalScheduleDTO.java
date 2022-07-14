package com.project.CarRentalProject.model.DTOs;

import com.project.CarRentalProject.model.RentalSchedule;
import lombok.Data;

@Data
public class RentalScheduleDTO {

    private Long rentalId;
    private Long clientId;
    private Long carId;
    private String collectionDate;
    private String returnDate;

    public static RentalScheduleDTO from(RentalSchedule rentalSchedule){
        RentalScheduleDTO rentalScheduleDTO = new RentalScheduleDTO();

        rentalScheduleDTO.setRentalId(rentalSchedule.getRentalId());
        rentalScheduleDTO.setClientId(rentalSchedule.getClientId());
        rentalScheduleDTO.setCarId(rentalSchedule.getCarId());
        rentalScheduleDTO.setCollectionDate(rentalSchedule.getCollectionDate());
        rentalScheduleDTO.setReturnDate(rentalSchedule.getReturnDate());

        return rentalScheduleDTO;
    }
}

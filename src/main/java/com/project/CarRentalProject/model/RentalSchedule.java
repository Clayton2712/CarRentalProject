package com.project.CarRentalProject.model;

import com.project.CarRentalProject.model.DTOs.RentalScheduleDTO;
import lombok.Data;
import javax.persistence.*;


@Data
@Entity
@Table(name = "rentalSchedule")
public class RentalSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long rentalId;

    @Column(updatable = false, nullable = false)
    private Long clientId;

    @Column(nullable = false)
    private Long carId;

    @Column(nullable = false)
    private String collectionDate;

    @Column(nullable = false)
    private String returnDate;

    public static RentalSchedule from(RentalScheduleDTO rentalScheduleDTO){
        RentalSchedule rentalSchedule = new RentalSchedule();

        rentalSchedule.setCarId(rentalScheduleDTO.getCarId());
        rentalSchedule.setCollectionDate(rentalScheduleDTO.getCollectionDate());
        rentalSchedule.setReturnDate(rentalScheduleDTO.getReturnDate());

        return rentalSchedule;
    }
}

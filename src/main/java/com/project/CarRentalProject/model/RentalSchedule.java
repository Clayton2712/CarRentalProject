package com.project.CarRentalProject.model;

import com.project.CarRentalProject.model.DTOs.RentalScheduleDTO;
import lombok.Data;
import javax.persistence.*;
import java.sql.Date;


@Data
@Entity
@Table(name = "rentalSchedule")
public class RentalSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long rentalId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clientId", nullable = false, updatable = false)
    private Client client;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carId", nullable = false, updatable = false)
    private Car car;

    @Column(nullable = false)
    private Date collectionDate;

    @Column(nullable = false)
    private Date returnDate;

    public static RentalSchedule from(RentalScheduleDTO rentalScheduleDTO){
        RentalSchedule rentalSchedule = new RentalSchedule();

        rentalSchedule.setReturnDate(rentalScheduleDTO.getReturnDate());

        return rentalSchedule;
    }
}

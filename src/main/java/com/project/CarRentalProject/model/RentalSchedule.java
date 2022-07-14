package com.project.CarRentalProject.model;

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

    private Long clientId;
    private String reservationDate;
    private String returnDate;
}

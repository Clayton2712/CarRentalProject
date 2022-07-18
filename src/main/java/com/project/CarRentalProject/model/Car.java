package com.project.CarRentalProject.model;

import com.project.CarRentalProject.model.DTOs.CarDTO;
import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long carId;

    @Column(nullable = false)
    private Float bookValue;

    @Column(nullable = false)
    private Boolean available;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "descId", nullable = false, updatable = false)
    private CarDesc carDesc;

    public static Car from(CarDTO carDTO){
        Car car = new Car();

        car.setBookValue(carDTO.getBookValue());
        car.setAvailable(carDTO.getAvailable());

        return car;
    }
}

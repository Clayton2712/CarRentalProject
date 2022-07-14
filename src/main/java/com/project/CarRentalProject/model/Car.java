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

    @Column(nullable = false, updatable = false)
    //@OneToMany(fetch = FetchType.LAZY)
    //@JoinColumn(name = "descId")
    private Long descId;

    @Column(nullable = false)
    private Float bookValue;

    public static Car from(CarDTO carDTO){
        Car car = new Car();

        car.setBookValue(carDTO.getBookValue());

        return car;
    }
}

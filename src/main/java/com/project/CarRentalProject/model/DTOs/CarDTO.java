package com.project.CarRentalProject.model.DTOs;

import com.project.CarRentalProject.model.Car;
import lombok.Data;

@Data
public class CarDTO {

    private Long carId;
    private Float bookValue;
    private Long descId;

    public static CarDTO from(Car car){
        CarDTO carDTO = new CarDTO();

        carDTO.setBookValue(car.getBookValue());
        carDTO.setCarId(car.getCarId());
        carDTO.setDescId(car.getDescId());

        return carDTO;
    }
}

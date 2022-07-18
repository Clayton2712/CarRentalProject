package com.project.CarRentalProject.model.DTOs;

import com.project.CarRentalProject.model.Car;
import com.project.CarRentalProject.model.CarDesc;
import lombok.Data;

@Data
public class CarDTO {

    private Long carId;
    private Float bookValue;
    private Boolean available;
    private CarDesc carDesc;

    public static CarDTO from(Car car){
        CarDTO carDTO = new CarDTO();

        carDTO.setBookValue(car.getBookValue());
        carDTO.setCarId(car.getCarId());
        carDTO.setAvailable(car.getAvailable());
        carDTO.setCarDesc(car.getCarDesc());
        return carDTO;
    }
}

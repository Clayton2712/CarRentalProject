package com.project.CarRentalProject.model.DTOs;


import com.project.CarRentalProject.model.CarDesc;
import lombok.Data;

@Data
public class CarDescDTO {
    private Long descId;
    private String carModel;
    private String carBrand;
    private String carCategory;

    public static CarDescDTO from (CarDesc carDesc){
        CarDescDTO carDescDTO = new CarDescDTO();

        carDescDTO.setDescId(carDesc.getDescId());
        carDescDTO.setCarBrand(carDesc.getCarBrand());
        carDescDTO.setCarModel(carDesc.getCarModel());
        carDescDTO.setCarCategory(carDesc.getCarCategory());

        return carDescDTO;
    }
}

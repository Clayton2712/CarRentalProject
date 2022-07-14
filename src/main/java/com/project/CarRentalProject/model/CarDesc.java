package com.project.CarRentalProject.model;

import com.project.CarRentalProject.model.DTOs.CarDescDTO;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "carDescription")
public class CarDesc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long descId;

    @Column(nullable = false, updatable = false)
    private String carModel;

    @Column(nullable = false, updatable = false)
    private String carBrand;

    @Column(nullable = false, updatable = false)
    private String carCategory;

    public static CarDesc from(CarDescDTO carDescDTO){
        CarDesc carDesc = new CarDesc();
        carDesc.setCarBrand(carDescDTO.getCarBrand());
        carDesc.setCarModel(carDescDTO.getCarModel());
        carDesc.setCarCategory(carDescDTO.getCarCategory());

        return carDesc;
    }
}

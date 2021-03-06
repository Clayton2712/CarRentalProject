package com.project.CarRentalProject.service;


import com.project.CarRentalProject.model.CarDesc;
import com.project.CarRentalProject.repository.CarDescRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CarDescService {

    private final CarDescRepository carDescRepository;

    @Autowired //Inject CarDescRepo
    public CarDescService(CarDescRepository carDescRepository) {
        this.carDescRepository = carDescRepository;
    }

    public CarDesc addCarDesc(CarDesc carDesc){
        return carDescRepository.save(carDesc);
    }

    public List<CarDesc> getAllCarDesc() {
        return carDescRepository.findAll();
    }

    public CarDesc getCarDescByID(Long id) {
        return carDescRepository.getReferenceById(id);
    }

    public CarDesc deleteCarDescByID(Long id){
        CarDesc carDesc = getCarDescByID(id);
        carDescRepository.delete(carDesc);
        return carDesc;
    }

    //Should not update immutable characteristics
    /*
    @Transactional
    public CarDesc updateCarDescByID(Long id, CarDesc carDesc){
        CarDesc carDescUpdater = getCarDescByID(id);

        carDescUpdater.setCarCategory(carDesc.getCarCategory());
        carDescUpdater.setCarModel(carDesc.getCarModel());
        carDescUpdater.setCarBrand(carDesc.getCarBrand());

        return carDescRepository.save(carDescUpdater);
    }
    */

}

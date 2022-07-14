package com.project.CarRentalProject.service;

import com.project.CarRentalProject.model.Car;
import com.project.CarRentalProject.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CarService {
    private final CarRepository carRepository;

    @Autowired //Inject CarRepo
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car addCar(Car car) {return carRepository.save(car);}

    public List<Car> getAllCars() {return carRepository.findAll();}

    public Car getCarById(Long id) {return carRepository.getReferenceById(id);}

    public Car deleteCarById(Long id) {
        Car car = getCarById(id);
        carRepository.delete(car);
        return car;
    }

    @Transactional
    public Car updateCarById(Long id, Car car){
        Car carUpdater = getCarById(id);

        carUpdater.setBookValue(car.getBookValue());

        return carRepository.save(carUpdater);
    }

}

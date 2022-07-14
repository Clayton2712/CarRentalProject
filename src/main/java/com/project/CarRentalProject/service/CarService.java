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

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car addCar(Car car) {return carRepository.save(car);}

    public List<Car> getAllCars() {return carRepository.findAll();}

    public Car getCarByID(Long id) {return carRepository.getReferenceById(id);}

    public Car deleteCarByID(Long id) {
        Car car = getCarByID(id);
        carRepository.delete(car);
        return car;
    }

    @Transactional
    public Car updateCarByID(Long id, Car car){
        Car initialCar = getCarByID(id);

        initialCar.setBookValue(car.getBookValue());

        return initialCar;
    }

}

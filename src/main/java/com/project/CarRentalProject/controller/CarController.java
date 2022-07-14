package com.project.CarRentalProject.controller;

import com.project.CarRentalProject.model.Car;
import com.project.CarRentalProject.model.DTOs.CarDTO;
import com.project.CarRentalProject.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/car")
public class CarController {
    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {this.carService = carService;}

    //CRUD
    @PostMapping
    public ResponseEntity<CarDTO> addCar(@RequestBody final CarDTO carDTO){
        Car newCar = carService.addCar(Car.from(carDTO));

        return new ResponseEntity<>(CarDTO.from(newCar), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CarDTO>> getAllCars(){
        List<Car> allCars = carService.getAllCars();
        List<CarDTO> carsDTO = allCars.stream().map(CarDTO::from).collect(Collectors.toList());

        return new ResponseEntity<>(carsDTO, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<CarDTO> getCar(@PathVariable final Long id){
        Car car = carService.getCarById(id);

        return new ResponseEntity<>(CarDTO.from(car), HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<CarDTO> deleteCar(@PathVariable final Long id){
        Car deletedCar = carService.deleteCarById(id);

        return new ResponseEntity<>(CarDTO.from(deletedCar), HttpStatus.OK);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<CarDTO> updateCar(@PathVariable final Long id, @RequestBody final CarDTO carDTO){
        Car updatedCar = carService.updateCarById(id, Car.from(carDTO));

        return new ResponseEntity<>(CarDTO.from(updatedCar), HttpStatus.OK);
    }
}

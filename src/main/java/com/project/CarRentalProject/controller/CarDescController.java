package com.project.CarRentalProject.controller;

import com.project.CarRentalProject.model.CarDesc;
import com.project.CarRentalProject.model.DTOs.CarDescDTO;
import com.project.CarRentalProject.service.CarDescService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/carDescription")
public class CarDescController {
    private final CarDescService carDescService;

    @Autowired
    public CarDescController(CarDescService carDescService) {
        this.carDescService = carDescService;
    }

    //CRUD
    @PostMapping
    public ResponseEntity<CarDescDTO> addCarDesc(@RequestBody final CarDescDTO carDescDTO){
        CarDesc newCarDesc = carDescService.addCarDesc(CarDesc.from(carDescDTO));

        return new ResponseEntity<>(carDescDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CarDescDTO>> getAllCarDesc(){
        List<CarDesc> allCarDesc = carDescService.getAllCarDesc();
        List<CarDescDTO> descriptionsDTO = allCarDesc.stream().map(CarDescDTO::from).collect(Collectors.toList());

        return new ResponseEntity<>(descriptionsDTO, HttpStatus.OK);
    }
    @GetMapping(value = "{id}")
    public ResponseEntity<CarDescDTO> getCarDesc(@PathVariable final Long id){
        CarDesc carDesc = carDescService.getCarDescByID(id);

        return new ResponseEntity<>(CarDescDTO.from(carDesc), HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<CarDescDTO> deleteCarDesc(@PathVariable final Long id){
        CarDesc deletedCarDesc = carDescService.deleteCarDescByID(id);

        return new ResponseEntity<>(CarDescDTO.from(deletedCarDesc), HttpStatus.OK);
    }

    ////Should not update immutable characteristics
/*

    @PutMapping(value = "{id}")
    public ResponseEntity<CarDescDTO> updateCarDesc(@PathVariable final Long id, @RequestBody final CarDescDTO carDescDTO){
        CarDesc updatedCarDesc = carDescService.updateCarDescByID(id, CarDesc.from(carDescDTO));

        return new ResponseEntity<>(CarDescDTO.from(updatedCarDesc),HttpStatus.OK);
    }
*/

}

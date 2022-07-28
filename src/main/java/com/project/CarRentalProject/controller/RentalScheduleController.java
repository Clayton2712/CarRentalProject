package com.project.CarRentalProject.controller;

import com.project.CarRentalProject.model.DTOs.RentalScheduleDTO;
import com.project.CarRentalProject.model.RentalSchedule;
import com.project.CarRentalProject.service.RentalScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rentalSchedule")
public class RentalScheduleController {
    private final RentalScheduleService rentalScheduleService;

    @Autowired
    public RentalScheduleController(RentalScheduleService rentalScheduleService) {
        this.rentalScheduleService = rentalScheduleService;
    }

    @PostMapping("/{clientId}/{carId}")
    public ResponseEntity<RentalScheduleDTO> addRentalSchedule(@PathVariable final Long clientId,
                                                            @PathVariable final Long carId,
                                                            @RequestBody final RentalScheduleDTO rentalScheduleDTO){
        RentalSchedule newRentalSchedule = rentalScheduleService.addRentalSchedule(clientId, carId,
                RentalSchedule.from(rentalScheduleDTO));

        return new ResponseEntity<>(RentalScheduleDTO.from(newRentalSchedule), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<RentalScheduleDTO>> getAllRentalSchedules(){
        List<RentalSchedule> allRentalSchedules = rentalScheduleService.getAllRentalSchedules();
        List<RentalScheduleDTO> allRentalSchedulesDTO =
                allRentalSchedules.stream().map(RentalScheduleDTO::from).collect(Collectors.toList());

        return new ResponseEntity<>(allRentalSchedulesDTO, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RentalScheduleDTO> getRentalSchedule(@PathVariable final Long id){
        RentalSchedule rentalSchedule = rentalScheduleService.getRentalScheduleById(id);

        return new ResponseEntity<>(RentalScheduleDTO.from(rentalSchedule), HttpStatus.OK);
    }
    @GetMapping("/byClientId/{id}")
    public ResponseEntity<List<RentalScheduleDTO>> getRentalByClientId(@PathVariable final Long id){
        List<RentalSchedule> rentalScheduleList = rentalScheduleService.getRentalByClientId(id);
        List<RentalScheduleDTO> rentalScheduleDTOList =
                rentalScheduleList.stream().map(RentalScheduleDTO::from).collect(Collectors.toList());

        return new ResponseEntity<>(rentalScheduleDTOList, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RentalScheduleDTO> deleteRentalSchedule(@PathVariable final Long id){
        RentalSchedule deletedRentalSchedule = rentalScheduleService.deleteRentalScheduleById(id);

        return new ResponseEntity<>(RentalScheduleDTO.from(deletedRentalSchedule), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RentalScheduleDTO> updateRentalSchedule(@PathVariable final Long id, @RequestBody
                                                                  final RentalScheduleDTO rentalScheduleDTO){
        RentalSchedule updatedRentalSchedule = rentalScheduleService.updateRentalScheduleById(id,
                RentalSchedule.from(rentalScheduleDTO));

        return new ResponseEntity<>(RentalScheduleDTO.from(updatedRentalSchedule), HttpStatus.OK);
    }

}

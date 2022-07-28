package com.project.CarRentalProject.service;

import com.project.CarRentalProject.model.Client;
import com.project.CarRentalProject.model.RentalSchedule;
import com.project.CarRentalProject.repository.CarRepository;
import com.project.CarRentalProject.repository.ClientRepository;
import com.project.CarRentalProject.repository.RentalScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;

@Service
public class RentalScheduleService {

    private final RentalScheduleRepository rentalScheduleRepository;
    private final ClientRepository clientRepository;
    private final CarService carService;

    @Autowired
    public RentalScheduleService(RentalScheduleRepository rentalScheduleRepository, ClientRepository clientRepository,  CarService carService) {
        this.rentalScheduleRepository = rentalScheduleRepository;
        this.clientRepository = clientRepository;
        this.carService = carService;
    }

    public RentalSchedule addRentalSchedule(Long clientId, Long carId, RentalSchedule rentalSchedule){
        rentalSchedule.setClient(clientRepository.getReferenceById(clientId));
        rentalSchedule.setCar(carService.getCarById(carId));
        carService.carOut(rentalSchedule.getCar());
        rentalSchedule.setCollectionDate(Date.valueOf(java.time.LocalDate.now()));

        return rentalScheduleRepository.save(rentalSchedule);
    }

    public List<RentalSchedule> getAllRentalSchedules(){return rentalScheduleRepository.findAll();}

    public RentalSchedule getRentalScheduleById(Long id){return rentalScheduleRepository.getReferenceById(id);}

    public RentalSchedule deleteRentalScheduleById(Long id){
        RentalSchedule rentalSchedule = getRentalScheduleById(id);

        rentalScheduleRepository.delete(rentalSchedule);
        carService.carIn(rentalSchedule.getCar());

        return rentalSchedule;
    }

    public List<RentalSchedule> getRentalByClientId(Long id){
        Client client = clientRepository.getReferenceById(id);
        return rentalScheduleRepository.findByClient(client);
    }

    @Transactional
    public RentalSchedule updateRentalScheduleById(Long id, RentalSchedule rentalSchedule){
        RentalSchedule rentalScheduleUpdater = rentalScheduleRepository.getReferenceById(id);

        rentalScheduleUpdater.setReturnDate(rentalSchedule.getReturnDate());

        return rentalScheduleRepository.save(rentalScheduleUpdater);
    }

}

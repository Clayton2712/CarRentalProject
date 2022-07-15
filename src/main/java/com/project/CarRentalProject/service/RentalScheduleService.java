package com.project.CarRentalProject.service;

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
    private final CarRepository carRepository;

    @Autowired
    public RentalScheduleService(RentalScheduleRepository rentalScheduleRepository, ClientRepository clientRepository, CarRepository carRepository) {
        this.rentalScheduleRepository = rentalScheduleRepository;
        this.clientRepository = clientRepository;
        this.carRepository = carRepository;
    }

    public RentalSchedule addRentalSchedule(Long clientId, Long carId, RentalSchedule rentalSchedule){
        rentalSchedule.setClient(clientRepository.getReferenceById(clientId));
        rentalSchedule.setCar(carRepository.getReferenceById(carId));
        rentalSchedule.setCollectionDate(Date.valueOf(java.time.LocalDate.now()));

        return rentalScheduleRepository.save(rentalSchedule);
    }

    public List<RentalSchedule> getAllRentalSchedules(){return rentalScheduleRepository.findAll();}

    public RentalSchedule getRentalScheduleById(Long id){return rentalScheduleRepository.getReferenceById(id);}

    public RentalSchedule deleteRentalScheduleById(Long id){
        RentalSchedule rentalSchedule = getRentalScheduleById(id);

        rentalScheduleRepository.delete(rentalSchedule);

        return rentalSchedule;
    }

    @Transactional
    public RentalSchedule updateRentalScheduleById(Long id, RentalSchedule rentalSchedule){
        RentalSchedule rentalScheduleUpdater = rentalScheduleRepository.getReferenceById(id);

        rentalScheduleUpdater.setReturnDate(rentalSchedule.getReturnDate());

        return rentalScheduleRepository.save(rentalScheduleUpdater);
    }

}

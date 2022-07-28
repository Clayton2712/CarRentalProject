package com.project.CarRentalProject.repository;

import com.project.CarRentalProject.model.Client;
import com.project.CarRentalProject.model.RentalSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentalScheduleRepository extends JpaRepository<RentalSchedule, Long> {
    List<RentalSchedule> findByClient(Client client);
}

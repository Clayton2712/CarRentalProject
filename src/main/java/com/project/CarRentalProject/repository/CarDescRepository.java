package com.project.CarRentalProject.repository;

import com.project.CarRentalProject.model.CarDesc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarDescRepository extends JpaRepository<CarDesc, Long> {
}

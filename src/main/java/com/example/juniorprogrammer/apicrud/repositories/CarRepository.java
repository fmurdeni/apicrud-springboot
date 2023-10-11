package com.example.juniorprogrammer.apicrud.repositories;

import com.example.juniorprogrammer.apicrud.entities.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<CarEntity, Integer> {
}

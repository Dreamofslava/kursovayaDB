package com.javamaster.spring_crud.repository;

import com.javamaster.spring_crud.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository extends JpaRepository<Trip, Integer> {
    Trip findByNumber (String number);
}

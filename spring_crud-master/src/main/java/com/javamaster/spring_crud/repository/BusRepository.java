package com.javamaster.spring_crud.repository;

import com.javamaster.spring_crud.entity.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusRepository extends JpaRepository<Bus, Integer> {
    Bus findByNum (String num);
}

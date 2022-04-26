package com.javamaster.spring_crud.service;

import com.javamaster.spring_crud.dto.BusDto;
import com.javamaster.spring_crud.exception.ValidationException;

import java.util.List;

public interface BusService {

    BusDto saveBus (BusDto busDto) throws ValidationException;

    void deleteBus(Integer busId);

    BusDto findByNum(String num);

    List<BusDto> findAll();
}








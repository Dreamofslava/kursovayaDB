package com.javamaster.spring_crud.service;

import com.javamaster.spring_crud.dto.TripDto;
import com.javamaster.spring_crud.exception.ValidationException;

import java.util.List;

public interface TripService {

    TripDto saveTrip (TripDto tripDto) throws ValidationException;

    void deleteTrip(Integer tripId);

    TripDto findByNumber(String number);

    List<TripDto> findAll();
}

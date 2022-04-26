package com.javamaster.spring_crud.service;

import com.javamaster.spring_crud.dto.TripDto;
import com.javamaster.spring_crud.entity.Trip;
import org.springframework.stereotype.Component;

@Component
public class TripConverter {
    public Trip fromTripDtoToTrip(TripDto tripDto) {
        Trip trip = new Trip();
        trip.setId(tripDto.getId());
        trip.setNumber(tripDto.getNumber());
        trip.setStarttime(tripDto.getStarttime());
        trip.setEndtime(tripDto.getEndtime());
        trip.setInterval(tripDto.getInterval());
        trip.setProtyaj(tripDto.getProtyaj());
        return trip;
    }

    public TripDto fromTripToTripDto(Trip trip) {
        return TripDto.builder()
                .id(trip.getId())
                .number(trip.getNumber())
                .starttime(trip.getStarttime())
                .endtime(trip.getEndtime())
                .interval(trip.getInterval())
                .protyaj(trip.getProtyaj())
                .build();
    }

}

package com.javamaster.spring_crud.prototype;

import com.javamaster.spring_crud.dto.TripDto;
import com.javamaster.spring_crud.entity.Trip;

public class TripPrototype {

    public static Trip aTrip() {
        Trip t = new Trip();
        t.setNumber("test_number");
        return t;
    }

    public static TripDto aTripDTO() {
        return TripDto.builder()
                .number("test_number")
                .build();
    }
}

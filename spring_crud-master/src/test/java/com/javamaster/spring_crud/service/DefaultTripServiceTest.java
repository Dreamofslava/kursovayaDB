package com.javamaster.spring_crud.service;

import com.javamaster.spring_crud.dto.TripDto;
import com.javamaster.spring_crud.exception.ValidationException;
import com.javamaster.spring_crud.repository.TripRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.javamaster.spring_crud.prototype.TripPrototype.aTrip;
import static com.javamaster.spring_crud.prototype.TripPrototype.aTripDTO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DefaultTripServiceTest {
    private TripRepository tripRepository;
    private TripConverter tripConverter;
    private TripService tripService;

    @BeforeEach
    void setUp() {
        tripRepository = mock(TripRepository.class);
        tripConverter = new TripConverter();
        tripService = new DefaultTripService(tripRepository, tripConverter);
    }

    @Test
    void saveTrip() throws ValidationException {
        when(tripRepository.save(any())).thenReturn(aTrip());
        TripDto createdTrip = tripService.saveTrip(aTripDTO());
        assertThat(createdTrip).isNotNull();
    }

    @Test
    void saveTripValidationExceptionWhenProtyajIsNull() {
        TripDto tripDto = aTripDTO();
        tripDto.setNumber("");
        assertThrows(ValidationException.class,
                () -> tripService.saveTrip(tripDto),
                "Number is Empty");
    }

    @Test
    void findByNumber() {
        when(tripRepository.findByNumber(eq("test_number"))).thenReturn(aTrip());
        TripDto foundTrip = tripService.findByNumber("test_number");
        assertThat(foundTrip).isNotNull();
        assertThat(foundTrip.getProtyaj()).isEqualTo("test_number");
    }

    @Test
    void findAll() {
    }

}

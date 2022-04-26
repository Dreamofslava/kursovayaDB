package com.javamaster.spring_crud.service;

import com.javamaster.spring_crud.dto.TripDto;
import com.javamaster.spring_crud.entity.Trip;
import com.javamaster.spring_crud.exception.ValidationException;
import com.javamaster.spring_crud.repository.TripRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
@AllArgsConstructor
public class DefaultTripService implements TripService{

    private final TripRepository tripRepository;
    private final TripConverter tripConverter;

    @Override
    public TripDto saveTrip(TripDto tripDto) throws ValidationException {
        validateTripDto(tripDto);
        Trip savedTrip = tripRepository.save(tripConverter.fromTripDtoToTrip(tripDto));
        return tripConverter.fromTripToTripDto(savedTrip);
    }

    private void validateTripDto(TripDto tripDto) throws ValidationException{
        if (isNull(tripDto)) {
            throw new ValidationException("Object trip is null");
        }
        if (isNull(tripDto.getProtyaj()) || tripDto.getProtyaj().isEmpty()) {
            throw new ValidationException("Protyaj is empty");
        }
    }

    @Override
    public void deleteTrip(Integer tripId) {
        tripRepository.deleteById(tripId);
    }

    @Override
    public TripDto findByNumber(String number) {
        Trip trip = tripRepository.findByNumber(number);
        if (trip != null) {
            return tripConverter.fromTripToTripDto(trip);
        }
        return null;
    }

    @Override
    public List<TripDto> findAll() {
        return tripRepository.findAll()
                .stream()
                .map(tripConverter::fromTripToTripDto)
                .collect(Collectors.toList());
    }
}

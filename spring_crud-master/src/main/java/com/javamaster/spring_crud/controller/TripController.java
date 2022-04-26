package com.javamaster.spring_crud.controller;

import com.javamaster.spring_crud.dto.TripDto;
import com.javamaster.spring_crud.exception.ValidationException;
import com.javamaster.spring_crud.service.TripService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trip")
@AllArgsConstructor
@Log
@CrossOrigin
public class TripController {
    private final TripService tripService;

    @PostMapping("/save")
    public TripDto saveTrip(@RequestBody TripDto tripDto) throws ValidationException {
        log.info("Handling save trip: " + tripDto);
        return tripService.saveTrip(tripDto);
    }

    @GetMapping("/findAll")
    public List<TripDto> findAllTrip() {
        log.info("Handling find all trip request");
        return tripService.findAll();
    }

    @GetMapping("/findByNumber")
    public TripDto findByNumber(@RequestParam String number) {
        log.info("Handling find by protyaj request: " + number);
        return tripService.findByNumber(number);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTrip(@PathVariable Integer id) {
        log.info("Handling delete user request: " + id);
        tripService.deleteTrip(id);
        return ResponseEntity.ok().build();
    }
}

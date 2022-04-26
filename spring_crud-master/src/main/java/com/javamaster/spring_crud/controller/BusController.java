package com.javamaster.spring_crud.controller;

import com.javamaster.spring_crud.dto.BusDto;
import com.javamaster.spring_crud.exception.ValidationException;
import com.javamaster.spring_crud.service.BusService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bus")
@AllArgsConstructor
@Log
@CrossOrigin
public class BusController {

    private final BusService busService;

    @PostMapping("/save")
    public BusDto saveBus(@RequestBody BusDto busDto) throws ValidationException {
        log.info("Handling save bus: " + busDto);
        return busService.saveBus(busDto);
    }

    @GetMapping("/findAll")
    public List<BusDto> findAllBus() {
        log.info("Handling find all users request");
        return busService.findAll();
    }

    @GetMapping("/findByNum")
    public BusDto findByNum(@RequestParam String num) {
        log.info("Handling find by number request: " + num);
        return busService.findByNum(num);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBus(@PathVariable Integer id) {
        log.info("Handling delete user request: " + id);
        busService.deleteBus(id);
        return ResponseEntity.ok().build();
    }
}

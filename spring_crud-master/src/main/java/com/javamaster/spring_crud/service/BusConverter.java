package com.javamaster.spring_crud.service;

import com.javamaster.spring_crud.dto.BusDto;
import com.javamaster.spring_crud.entity.Bus;
import org.springframework.stereotype.Component;

@Component
public class BusConverter {
    public Bus fromBusDtoToBus(BusDto busDto) {
        Bus bus = new Bus();
        bus.setId(busDto.getId());
        bus.setNum(busDto.getNum());
        bus.setType(busDto.getType());
        bus.setMest(busDto.getMest());
        return bus;
    }

    public BusDto fromBusToBusDto(Bus bus) {
        return BusDto.builder()
                .id(bus.getId())
                .num(bus.getNum())
                .type(bus.getType())
                .mest(bus.getMest())
                .build();
    }
}

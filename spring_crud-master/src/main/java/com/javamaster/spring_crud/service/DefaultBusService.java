package com.javamaster.spring_crud.service;

import com.javamaster.spring_crud.dto.BusDto;
import com.javamaster.spring_crud.entity.Bus;
import com.javamaster.spring_crud.exception.ValidationException;
import com.javamaster.spring_crud.repository.BusRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
@AllArgsConstructor
public class DefaultBusService implements BusService{

    private final BusRepository busRepository;
    private final BusConverter busConverter;

    @Override
    public BusDto saveBus(BusDto busDto) throws ValidationException {
        validateBusDto(busDto);
        Bus savedBus = busRepository.save(busConverter.fromBusDtoToBus(busDto));
        return busConverter.fromBusToBusDto(savedBus);
    }

    private void validateBusDto(BusDto busDto) throws ValidationException{
        if (isNull(busDto)) {
            throw new ValidationException("Object bus is null");
        }
        if (isNull(busDto.getNum()) || busDto.getNum().isEmpty()) {
            throw new ValidationException("Number is Empty");
        }
    }

    @Override
    public void deleteBus(Integer busId) {
        busRepository.deleteById(busId);
    }

    @Override
    public BusDto findByNum(String num) {
        Bus bus = busRepository.findByNum(num);
        if (bus != null) {
            return busConverter.fromBusToBusDto(bus);
        }
        return null;
    }

    @Override
    public List<BusDto> findAll() {
        return busRepository.findAll()
                .stream()
                .map(busConverter::fromBusToBusDto)
                .collect(Collectors.toList());
    }
}

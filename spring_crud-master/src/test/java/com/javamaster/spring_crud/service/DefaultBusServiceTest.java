package com.javamaster.spring_crud.service;

import com.javamaster.spring_crud.dto.BusDto;
import com.javamaster.spring_crud.exception.ValidationException;
import com.javamaster.spring_crud.repository.BusRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.javamaster.spring_crud.prototype.BusPrototype.aBus;
import static com.javamaster.spring_crud.prototype.BusPrototype.aBusDTO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DefaultBusServiceTest {

    private BusRepository busRepository;
    private BusConverter busConverter;
    private BusService busService;

    @BeforeEach
    void setUp() {
        busRepository = mock(BusRepository.class);
        busConverter = new BusConverter();
        busService = new DefaultBusService(busRepository, busConverter);
    }

    @Test
    void saveBus() throws ValidationException {
        when(busRepository.save(any())).thenReturn(aBus());
        BusDto createdBus = busService.saveBus(aBusDTO());
        assertThat(createdBus).isNotNull();
        //assertThat(createdBus.getMest()).isEqualTo(aBusDTO().getMest());
    }

    @Test
    void saveBusThrowsValidationExceptionWhenNumIsNull() {
        BusDto busDto = aBusDTO();
        busDto.setNum("");
        assertThrows(ValidationException.class,
                () -> busService.saveBus(busDto),
                "Number is Empty");
    }

    @Test
    void deleteBus() {
    }

    @Test
    void findByNum() {
        when(busRepository.findByNum(eq("test_num"))).thenReturn(aBus());
        BusDto foundBus = busService.findByNum("test_num");
        assertThat(foundBus).isNotNull();
        assertThat(foundBus.getNum()).isEqualTo("test_num");
    }

    @Test
    void findAll(){
    }
}

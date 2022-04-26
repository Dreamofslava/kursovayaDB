package com.javamaster.spring_crud.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javamaster.spring_crud.service.BusService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;

import static com.javamaster.spring_crud.prototype.BusPrototype.aBusDTO;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class BusControllerTest {

    MockMvc mockMvc;
    ObjectMapper objectMapper;
    BusService busService;

    @BeforeEach
    void setUp() {
        busService = mock(BusService.class);
        mockMvc = MockMvcBuilders.standaloneSetup(new BusController(busService)).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    void saveBus() throws Exception {
        when(busService.saveBus(any())).thenReturn(aBusDTO());
        mockMvc.perform(post("/bus/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(aBusDTO())))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(aBusDTO())));
    }

    @Test
    void findAllBus() throws Exception {
        when(busService.findAll()).thenReturn(Collections.singletonList(aBusDTO()));
        mockMvc.perform(get("/bus/findAll")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(Collections.singletonList(aBusDTO()))))
                .andExpect(status().isOk());
    }

    @Test
    void findByNum() {
    }

    @Test
    void deleteBus() {
    }

}

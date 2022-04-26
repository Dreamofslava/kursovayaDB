package com.javamaster.spring_crud.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javamaster.spring_crud.service.TripService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;

import static com.javamaster.spring_crud.prototype.TripPrototype.aTripDTO;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.web.servlet.function.RequestPredicates.contentType;

class TripControllerTest {

    MockMvc mockMvc;
    ObjectMapper objectMapper;
    TripService tripService;

    @BeforeEach
    void setUp() {
        tripService = mock(TripService.class);
        mockMvc = MockMvcBuilders.standaloneSetup(new TripController(tripService)).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    void saveTrip() throws Exception {
        when(tripService.saveTrip(any())).thenReturn(aTripDTO());
        mockMvc.perform(post("/trip/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(aTripDTO())))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(aTripDTO())));
    }

    @Test
    void findAllTrip() throws Exception {
        when(tripService.findAll()).thenReturn(Collections.singletonList(aTripDTO()));
        mockMvc.perform(get("/trip/findAll")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(Collections.singletonList(aTripDTO()))))
                .andExpect(status().isOk());
    }

    @Test
    void findByNumber() {
    }

    @Test
    void deleteTrip(){
    }
}

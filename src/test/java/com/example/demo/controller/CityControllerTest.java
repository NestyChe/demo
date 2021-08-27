/*package com.example.demo.controller;

import com.example.demo.entitymysql.City;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;


import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// Integration test
@ExtendWith(SpringExtension.class)
@WebMvcTest(CityController.class)
class CityControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CityController cityController;

    //проверить  соответствие http запроса и что метод возвращает верное содержимое
    @Test
    void getAllCitiesTest() throws Exception {
        City s = new City("Minsk", "55.234563", "43.324464");
        when(cityController.getAllCities()).thenReturn(s.getName());
        mockMvc.perform(get("/get"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").isNotEmpty())
                .andExpect(jsonPath("$.latitude").value("55.234563"))
                .andExpect(jsonPath("$.longitude").value("43.324464"));
    }

    // проверить сериализацию входного потока, правильность ввода(на недопустимые значения),
    // проверить вызов бизнес логики(получает нужные значения и отдает верные данные рассчетов)
//, "55.234563", "43.324464" ; "50.07784341", "14.43881727"
    @Test
    void calculateDistanceTest() throws Exception {
        when(cityController.calculateDistance(any())).thenReturn("905.0934");
                mockMvc.perform(MockMvcRequestBuilders.get("/calculate")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"srt1\": \"DistanceMatrix\",\"str2\" : \"Minsk\", \"str3\" : \"Praha\"}"))
                .andExpect(status().isCreated())
                .andExpect(header().string(HttpHeaders.LOCATION, "http://localhost/calculate"));
    }

    //проверка верности вводных данных, проверка на сохранение данных в бд и статуса ответа
    @Test
    void uploadCity() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/upload")
                .content(new ObjectMapper().writeValueAsString(new City("Minsk","55.234563", "43.324464")))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.cityName").exists());
    }
} */
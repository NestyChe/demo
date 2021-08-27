package com.example.demo.controller;

import com.example.demo.entitymysql.City;
import com.example.demo.entitymysql.CityRepository;
import com.example.demo.entitymysql.Distance;
import com.example.demo.entitymysql.DistanceRepository;
import com.example.demo.service.CityService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;


@RestController
@RequestMapping("/")
public class CityController {
    @Autowired
    private CityService cityService;
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private DistanceRepository distanceRepository;

    @GetMapping(path = "/get")
    public String getAllCities() {
        try {
            return cityService.getAllCities().toString();
        } catch (NotFoundException ex) {
            return ex.getMessage();
        }
    }

    @GetMapping(path = "/calculate")
    public String calculateDistance(@RequestBody ObjectNode json) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String type = json.get("str1").asText();
            List<String> from = objectMapper.readValue(json.get("str2").toString(),  new TypeReference<List<String>>(){});
            List<String> to = objectMapper.readValue(json.get("str3").toString(),  new TypeReference<List<String>>(){});
            return cityService.calculateDistance(type, from, to);
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    @PostMapping(path = "/upload")
    public ResponseEntity uploadCity(@RequestPart("file") MultipartFile file) {
        try {
            return ResponseEntity.ok(cityService.uploadCity(file));
        } catch (Exception ex) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(path = "/addCity")
    public  String addNewCity (@RequestBody City city) {
        try {
            cityService.addCity(city);
            return "Save";
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
}

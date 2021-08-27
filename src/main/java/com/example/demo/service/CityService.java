package com.example.demo.service;

import com.example.demo.claculation.AllCalculate;
import com.example.demo.claculation.Calculation;
import com.example.demo.claculation.CrowFlight;
import com.example.demo.claculation.DistanceMatrix;
import com.example.demo.entitymysql.*;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Service
public class CityService {
    @Autowired
    CityRepository cityRepository;

    @Autowired
    DistanceRepository distanceRepository;


    public void addCity(City city) throws Exception {
        if (cityRepository.findByName(city.getName()) != null) {
            throw new Exception("City already exist");
        }
        cityRepository.save(city);
    }

    public String getAllCities() throws NotFoundException {
        Map<Integer,String> cityMap = new HashMap<>();
        for (City n : cityRepository.findAll()) {
            cityMap.put(n.getId(), n.getName());
        }
        if (cityMap.isEmpty()) {
            throw new NotFoundException("Not found cities");
        }
        return cityMap.toString();
    }

    public String calculateDistance(String s, List<String> from, List<String> to) {
        List<String> listDistance = new ArrayList<>();
        double[] x = new double[2];
        double[] y = new double[2];
        Calculation c;
        switch (s) {
            case ("CrowFlight"):
                c = new CrowFlight();
                break;
            case ("DistanceMatrix"):
                c = new DistanceMatrix();
                break;
            case ("All"):
                c = new AllCalculate();
                break;
            default:
                throw new IllegalStateException();
        }
        for (int i = 0; i < from.size(); i++) {
            x[0] = Double.parseDouble(cityRepository.findByName(from.get(i)).getLatitude());
            x[1] = Double.parseDouble(cityRepository.findByName(from.get(i)).getLongitude());
            y[0] = Double.parseDouble(cityRepository.findByName(to.get(i)).getLatitude());
            y[1] = Double.parseDouble(cityRepository.findByName(to.get(i)).getLongitude());
            listDistance.add(c.calculate(x, y));
        }
        return listDistance.toString();
    }

    public String uploadCity(MultipartFile file) throws IOException, JAXBException {
        File file2 = new File(System.getProperty("user.home") + "/" + file.getOriginalFilename());
        file.transferTo(file2);
        JAXBContext jaxbContext = JAXBContext.newInstance(DistanceList.class);
        Unmarshaller jaxbUnmarshall = jaxbContext.createUnmarshaller();
        DistanceList distanceList = (DistanceList) jaxbUnmarshall.unmarshal(file2);
        for (Distance d : distanceList.getDistanceList()) {
            distanceRepository.save(d);
        }
        return "Upload success!";
    }
}


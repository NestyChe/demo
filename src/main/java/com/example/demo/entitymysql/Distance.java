package com.example.demo.entitymysql;

import javax.persistence.*;
import javax.xml.bind.annotation.*;


@XmlRootElement(name = "distance-class")
@XmlAccessorType (XmlAccessType.FIELD)
@Entity
public class Distance {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String fromCity;
    private String toCity;
    private String distance;

    public Distance() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getFromCity() {
        return fromCity;
    }


    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }

    public String getToCity() {
        return toCity;
    }

    public void setToCity(String toCity) {
        this.toCity = toCity;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "From: " + fromCity + " To: " + toCity + " Distance: " + distance;
    }

}

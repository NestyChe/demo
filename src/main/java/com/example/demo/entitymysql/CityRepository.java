package com.example.demo.entitymysql;

import org.springframework.data.repository.CrudRepository;

public interface CityRepository extends CrudRepository<City,Integer> {
    City findByName(String s);
}

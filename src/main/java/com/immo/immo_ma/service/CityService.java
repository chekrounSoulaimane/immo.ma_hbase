package com.immo.immo_ma.service;

import com.immo.immo_ma.bean.City;

import java.io.IOException;
import java.util.List;

public interface CityService {

    City save(City city) throws IOException;

    City findById(String id) throws IOException;

    List<City> findAll() throws IOException;

    void delete(String id) throws IOException;
}

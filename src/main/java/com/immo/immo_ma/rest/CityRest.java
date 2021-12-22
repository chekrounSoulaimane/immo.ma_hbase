package com.immo.immo_ma.rest;

import com.immo.immo_ma.bean.City;
import com.immo.immo_ma.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/city")
public class CityRest {

    @Autowired
    private CityService cityService;

    @PostMapping("/")
    public City save(@RequestBody City city) {
        try {
            return cityService.save(city);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/")
    public List<City> findAll() {
        try {
            return cityService.findAll();
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @GetMapping("/{id}")
    public City findById(@PathVariable String id) {
        try {
            return cityService.findById(id);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @PutMapping("/")
    public City update(@RequestBody City city) {
        try {
            return cityService.save(city);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable String id) {
        try {
            cityService.delete(id);
            return 0;
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }
}

package com.immo.immo_ma.service.impl;

import com.flipkart.hbaseobjectmapper.Records;
import com.immo.immo_ma.bean.City;
import com.immo.immo_ma.dao.CityDao;
import com.immo.immo_ma.service.CityService;
import org.apache.hadoop.hbase.client.Scan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao cityDao;


    @Override
    public City save(City city) throws IOException {
        String id = cityDao.persist(city);
        if (id != null) {
            return findById(id);
        }
        return null;
    }

    @Override
    public City findById(String id) throws IOException {
        return cityDao.get(id);
    }

    @Override
    public List<City> findAll() throws IOException {
        List<City> citys = new ArrayList<>();
        Scan scan = new Scan();
        try (Records<City> userRecords = cityDao.records(scan)) {
            userRecords.forEach(citys::add);
            return citys;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(String id) throws IOException {
        cityDao.delete(id);
    }
}

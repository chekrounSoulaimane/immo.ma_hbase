package com.immo.immo_ma.service.impl;

import com.flipkart.hbaseobjectmapper.Records;
import com.immo.immo_ma.bean.City;
import com.immo.immo_ma.bean.Secteur;
import com.immo.immo_ma.dao.SecteurDao;
import com.immo.immo_ma.service.CityService;
import com.immo.immo_ma.service.SecteurService;
import lombok.AllArgsConstructor;
import org.apache.hadoop.hbase.client.Scan;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class SecteurServiceImpl implements SecteurService {

    private SecteurDao secteurDao;
    private CityService cityService;


    @Override
    public Secteur save(Secteur secteur) throws IOException {

        City city = secteur.getCity();
        if (city != null) {
            city = cityService.findById(city.getId());
            if (city != null) {
                secteur.setCity(city);
            } else {
                secteur.setCity(null);
            }
        }
        String id = secteurDao.persist(secteur);
        if (id != null) {
            return findById(id);
        }
        return null;
    }

    @Override
    public Secteur findById(String id) throws IOException {
        return secteurDao.get(id);
    }

    @Override
    public List<Secteur> findAll() throws IOException {
        List<Secteur> secteurs = new ArrayList<>();
        Scan scan = new Scan();
        try (Records<Secteur> userRecords = secteurDao.records(scan)) {
            userRecords.forEach(secteurs::add);
            return secteurs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(String id) throws IOException {
        secteurDao.delete(id);
    }
}

package com.immo.immo_ma.service.impl;

import com.flipkart.hbaseobjectmapper.Records;
import com.immo.immo_ma.bean.AnnonceType;
import com.immo.immo_ma.dao.AnnonceTypeDao;
import com.immo.immo_ma.service.AnnonceTypeService;
import org.apache.hadoop.hbase.client.Scan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class AnnonceTypeServiceImpl implements AnnonceTypeService {

    @Autowired
    private AnnonceTypeDao annonceTypeDao;


    @Override
    public AnnonceType save(AnnonceType annonceType) throws IOException {
        String id = annonceTypeDao.persist(annonceType);
        if (id != null) {
            return findById(id);
        }
        return null;
    }

    @Override
    public AnnonceType findById(String id) throws IOException {
        return annonceTypeDao.get(id);
    }

    @Override
    public List<AnnonceType> findAll() throws IOException {
        List<AnnonceType> annonceTypes = new ArrayList<>();
        Scan scan = new Scan();
        try (Records<AnnonceType> userRecords = annonceTypeDao.records(scan)) {
            userRecords.forEach(annonceTypes::add);
            return annonceTypes;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(String id) throws IOException {
        annonceTypeDao.delete(id);
    }
}

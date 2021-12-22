package com.immo.immo_ma.service.impl;

import com.flipkart.hbaseobjectmapper.Records;
import com.immo.immo_ma.bean.Annonce;
import com.immo.immo_ma.bean.AnnonceType;
import com.immo.immo_ma.dao.AnnonceDao;
import com.immo.immo_ma.service.AnnonceService;
import com.immo.immo_ma.service.AnnonceTypeService;
import org.apache.hadoop.hbase.client.Scan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class AnnonceServiceImpl implements AnnonceService {

    @Autowired
    private AnnonceDao annonceDao;
    @Autowired
    private AnnonceTypeService annonceTypeService;

    @Override
    public Annonce save(Annonce annonce) throws IOException {
        String annonceTypeId = annonce.getAnnonceType().getId();
        if (annonceTypeId == null || annonceTypeId.isEmpty()) {
            return null;
        }

        AnnonceType annonceType = annonceTypeService.findById(annonceTypeId);
        if (annonceType == null) {
            return null;
        }

        annonce.setAnnonceType(annonceType);
        String id = annonceDao.persist(annonce);
        if (id != null) {
            return findById(id);
        }
        return null;
    }

    @Override
    public Annonce findById(String id) throws IOException {
        return annonceDao.get(id);
    }

    @Override
    public List<Annonce> findAll() throws IOException {
        List<Annonce> annonces = new ArrayList<>();
        Scan scan = new Scan();
        try (Records<Annonce> userRecords = annonceDao.records(scan)) {
            userRecords.forEach(annonces::add);
            return annonces;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(String id) throws IOException {
        annonceDao.delete(id);
    }
}

package com.immo.immo_ma.service;

import com.immo.immo_ma.bean.AnnonceType;

import java.io.IOException;
import java.util.List;

public interface AnnonceTypeService {

    AnnonceType save(AnnonceType annonceType) throws IOException;

    AnnonceType findById(String id) throws IOException;

    List<AnnonceType> findAll() throws IOException;

    void delete(String id) throws IOException;
}

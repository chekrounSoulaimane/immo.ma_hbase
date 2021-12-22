package com.immo.immo_ma.service;

import com.immo.immo_ma.bean.Annonceur;

import java.io.IOException;
import java.util.List;

public interface AnnonceurService {

    Annonceur save(Annonceur annonceur) throws IOException;

    Annonceur findById(String id) throws IOException;

    List<Annonceur> findAll() throws IOException;

    void delete(String id) throws IOException;
}

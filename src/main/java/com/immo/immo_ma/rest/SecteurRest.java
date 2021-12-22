package com.immo.immo_ma.rest;

import com.immo.immo_ma.bean.Secteur;
import com.immo.immo_ma.service.SecteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/secteur")
public class SecteurRest {

    @Autowired
    private SecteurService secteurService;

    @PostMapping("/")
    public Secteur save(@RequestBody Secteur secteur) {
        try {
            return secteurService.save(secteur);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/")
    public List<Secteur> findAll() {
        try {
            return secteurService.findAll();
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @GetMapping("/{id}")
    public Secteur findById(@PathVariable String id) {
        try {
            return secteurService.findById(id);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @PutMapping("/")
    public Secteur update(@RequestBody Secteur secteur) {
        try {
            return secteurService.save(secteur);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable String id) {
        try {
            secteurService.delete(id);
            return 0;
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }
}

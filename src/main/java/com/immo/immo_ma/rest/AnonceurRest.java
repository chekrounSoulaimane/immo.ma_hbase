package com.immo.immo_ma.rest;

import com.immo.immo_ma.bean.Annonceur;
import com.immo.immo_ma.service.AnnonceurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/anonceur")
public class AnonceurRest {

    @Autowired
    private AnnonceurService annonceurService;

    @PostMapping("/")
    public Annonceur save(@RequestBody Annonceur anonceur) {
        try {
            return annonceurService.save(anonceur);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/")
    public List<Annonceur> findAll() {
        try {
            return annonceurService.findAll();
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @GetMapping("/{id}")
    public Annonceur findById(@PathVariable String id) {
        try {
            return annonceurService.findById(id);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @PutMapping("/")
    public Annonceur update(@RequestBody Annonceur anonceur) {
        try {
            return annonceurService.save(anonceur);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable String id) {
        try {
            annonceurService.delete(id);
            return 0;
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }
}

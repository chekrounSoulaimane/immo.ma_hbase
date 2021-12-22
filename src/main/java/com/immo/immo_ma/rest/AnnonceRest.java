package com.immo.immo_ma.rest;

import com.immo.immo_ma.bean.Annonce;
import com.immo.immo_ma.service.AnnonceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/annonce")
public class AnnonceRest {

    @Autowired
    private AnnonceService annonceService;

    @PostMapping("/")
    public Annonce save(@RequestBody Annonce annonce) {
        try {
            return annonceService.save(annonce);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/")
    public List<Annonce> findAll() {
        try {
            return annonceService.findAll();
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @GetMapping("/{id}")
    public Annonce findById(@PathVariable String id) {
        try {
            return annonceService.findById(id);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @PutMapping("/")
    public Annonce update(@RequestBody Annonce annonce) {
        try {
            return annonceService.save(annonce);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable String id) {
        try {
            annonceService.delete(id);
            return 0;
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }
}

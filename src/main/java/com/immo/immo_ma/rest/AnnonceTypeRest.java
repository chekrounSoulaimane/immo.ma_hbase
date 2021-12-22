package com.immo.immo_ma.rest;

import com.immo.immo_ma.bean.AnnonceType;
import com.immo.immo_ma.service.AnnonceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/annonce-type")
public class AnnonceTypeRest {

    @Autowired
    private AnnonceTypeService annonceTypeService;

    @PostMapping("/")
    public AnnonceType save(@RequestBody AnnonceType annonceType) {
        try {
            return annonceTypeService.save(annonceType);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/")
    public List<AnnonceType> findAll() {
        try {
            return annonceTypeService.findAll();
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @GetMapping("/{id}")
    public AnnonceType findById(@PathVariable String id) {
        try {
            return annonceTypeService.findById(id);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @PutMapping("/")
    public AnnonceType update(@RequestBody AnnonceType annonceType) {
        try {
            return annonceTypeService.save(annonceType);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable String id) {
        try {
            annonceTypeService.delete(id);
            return 0;
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }
}

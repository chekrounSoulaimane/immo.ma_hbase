package com.immo.immo_ma.rest;

import com.immo.immo_ma.bean.Category;
import com.immo.immo_ma.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryRest {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/")
    public Category save(@RequestBody Category category) {
        try {
            return categoryService.save(category);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/")
    public List<Category> findAll() {
        try {
            return categoryService.findAll();
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @GetMapping("/{id}")
    public Category findById(@PathVariable String id) {
        try {
            return categoryService.findById(id);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @PutMapping("/")
    public Category update(@RequestBody Category category) {
        try {
            return categoryService.save(category);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable String id) {
        try {
            categoryService.delete(id);
            return 0;
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }
}

package com.immo.immo_ma.service;

import com.immo.immo_ma.bean.Category;

import java.io.IOException;
import java.util.List;

public interface CategoryService {

    Category save(Category category) throws IOException;

    Category findById(String id) throws IOException;

    List<Category> findAll() throws IOException;

    void delete(String id) throws IOException;
}

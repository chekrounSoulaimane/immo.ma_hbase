package com.immo.immo_ma.dao;

import com.flipkart.hbaseobjectmapper.AbstractHBDAO;
import com.immo.immo_ma.bean.Category;
import org.apache.hadoop.hbase.client.Connection;
import org.springframework.stereotype.Component;

@Component
public class CategoryDao extends AbstractHBDAO<String, Category> {

    public CategoryDao(Connection connection) {
        super(connection);
    }
}

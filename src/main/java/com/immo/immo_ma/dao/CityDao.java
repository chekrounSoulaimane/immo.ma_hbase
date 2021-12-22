package com.immo.immo_ma.dao;

import com.flipkart.hbaseobjectmapper.AbstractHBDAO;
import com.immo.immo_ma.bean.City;
import org.apache.hadoop.hbase.client.Connection;
import org.springframework.stereotype.Component;

@Component
public class CityDao extends AbstractHBDAO<String, City> {

    public CityDao(Connection connection) {
        super(connection);
    }
}

package com.immo.immo_ma.dao;

import com.flipkart.hbaseobjectmapper.AbstractHBDAO;
import com.immo.immo_ma.bean.AnnonceType;
import org.apache.hadoop.hbase.client.Connection;
import org.springframework.stereotype.Component;

@Component
public class AnnonceTypeDao extends AbstractHBDAO<String, AnnonceType> {

    public AnnonceTypeDao(Connection connection) {
        super(connection);
    }
}

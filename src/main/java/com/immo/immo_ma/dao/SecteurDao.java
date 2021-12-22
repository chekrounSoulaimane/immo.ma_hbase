package com.immo.immo_ma.dao;

import com.flipkart.hbaseobjectmapper.AbstractHBDAO;
import com.immo.immo_ma.bean.Secteur;
import org.apache.hadoop.hbase.client.Connection;
import org.springframework.stereotype.Component;

@Component
public class SecteurDao extends AbstractHBDAO<String, Secteur> {

    public SecteurDao(Connection connection) {
        super(connection);
    }
}

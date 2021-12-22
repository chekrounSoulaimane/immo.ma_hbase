package com.immo.immo_ma.dao;

import com.flipkart.hbaseobjectmapper.AbstractHBDAO;
import com.immo.immo_ma.bean.Annonceur;
import org.apache.hadoop.hbase.client.Connection;
import org.springframework.stereotype.Component;

@Component
public class AnnonceurDao extends AbstractHBDAO<String, Annonceur> {

    public AnnonceurDao(Connection connection) {
        super(connection);
    }
}

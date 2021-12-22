package com.immo.immo_ma;

import com.flipkart.hbaseobjectmapper.HBAdmin;
import com.immo.immo_ma.bean.*;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.util.Arrays;

@SpringBootApplication
public class ImmoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ImmoApplication.class, args);
    }


    @Bean
    Connection getConnection() throws IOException {
        System.setProperty("hadoop.home.dir", "D:/winutils");
        return ConnectionFactory.createConnection(HBaseConfiguration.create());
    }

    @Override
    public void run(String... args) throws Exception {
        HBAdmin hbAdmin = HBAdmin.create(getConnection());
        if (!tableExists(Annonce.class)) {
            hbAdmin.createTable(Annonce.class);
        }

        if (!tableExists(AnnonceType.class)) {
            hbAdmin.createTable(AnnonceType.class);
        }

        if (!tableExists(Annonceur.class)) {
            hbAdmin.createTable(Annonceur.class);
        }

        if (!tableExists(Category.class)) {
            hbAdmin.createTable(Category.class);
        }

        if (!tableExists(City.class)) {
            hbAdmin.createTable(City.class);
        }

        if (!tableExists(Secteur.class)) {
            hbAdmin.createTable(Secteur.class);
        }
    }

    public boolean tableExists(Class myClass) throws IOException {
        String[] className = myClass.getName().split("\\.");
        TableName tableName = TableName.valueOf(className[className.length - 1]);
        Admin admin = getConnection().getAdmin();
        TableName[] tableNames = admin.listTableNames();
        return Arrays.stream(tableNames).filter(tn -> tn.equals(tableName)).findFirst().isPresent();
    }
}

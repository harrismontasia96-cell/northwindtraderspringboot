package com.northwindtraders;


import com.northwindtraders.data.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


public class NorthwindApplication implements CommandLineRunner {

    @Autowired
    private ProductDao productDao;

    @Override
    public void run(String... args) throws Exception {

        System.out.println("=== Northwind Traders CLI ===");


        System.out.println("Products in database:");
        productDao.getAllProducts().forEach(product -> {
            System.out.println(product.getProductId() + " - " + product.getProductName());
        });


    }
}


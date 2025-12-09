package com.northwindtraders.dao;

import com.northwindtraders.models.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Primary
public class JdbcProductDao implements ProductDao {

    private List<Product> products = new ArrayList<>();

    public JdbcProductDao() {
        // preload example products
        products.add(new Product(1, "Laptop", "Electronics", 999.99));
        products.add(new Product(2, "Phone", "Electronics", 599.99));
    }

    @Override
    public List<Product> getAllProducts() {
        return products;
    }

    @Override
    public Product getById(int id) {
        return products.stream()
                .filter(p -> p.getProductId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void add(Product product) {
        products.add(product);
    }

    @Override
    public void update(Product product) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductId() == product.getProductId()) {
                products.set(i, product);
                return;
            }
        }
    }

    @Override
    public void delete(int id) {
        products.removeIf(p -> p.getProductId() == id);
    }
}



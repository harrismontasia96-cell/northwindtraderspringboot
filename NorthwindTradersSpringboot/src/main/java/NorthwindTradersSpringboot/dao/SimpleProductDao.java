
package com.northwindtraders.dao;

import com.northwindtraders.models.Product;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class SimpleProductDao implements ProductDao {

    private List<Product> products = new ArrayList<>();

    public SimpleProductDao() {
        products.add(new Product(3, "Book", "Education", 19.99));
        products.add(new Product(4, "Pen", "Stationery", 2.99));
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
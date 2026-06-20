package com.yukta.systemdesign.lld.high_design_pattterns.repository_pattern;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class RepositoryPatternDemo {

    public static void main(String[] args) {
        ProductRepository repository = new InMemoryProductRepository();

        repository.save(new Product("P-1", "Keyboard"));

        repository.findBySku("P-1")
                .map(Product::name)
                .ifPresent(System.out::println);
    }
}

record Product(String sku, String name) {
}

interface ProductRepository {
    void save(Product product);

    Optional<Product> findBySku(String sku);
}

class InMemoryProductRepository implements ProductRepository {

    private final Map<String, Product> products = new HashMap<>();

    @Override
    public void save(Product product) {
        products.put(product.sku(), product);
    }

    @Override
    public Optional<Product> findBySku(String sku) {
        return Optional.ofNullable(products.get(sku));
    }
}

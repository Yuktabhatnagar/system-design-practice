package com.yukta.systemdesign.hld.high_design_patterns.cqrs;

import java.util.HashMap;
import java.util.Map;

public class CqrsDemo {
    public static void main(String[] args) {
        ProductWriteService writeService = new ProductWriteService();
        ProductReadService readService = new ProductReadService(writeService.store());
        writeService.create("P-1", "Keyboard");
        System.out.println(readService.findName("P-1"));
    }
}

record Product(String sku, String name) {}
class ProductWriteService {
    private final Map<String, Product> products = new HashMap<>();
    void create(String sku, String name) { products.put(sku, new Product(sku, name)); }
    Map<String, Product> store() { return products; }
}
class ProductReadService {
    private final Map<String, Product> products;
    ProductReadService(Map<String, Product> products) { this.products = products; }
    String findName(String sku) { Product product = products.get(sku); return product == null ? "not found" : product.name(); }
}

package com.lesson2.cart.shop;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductRepository {
    private final List<Product> productList = List.of(
            new Product(1, "Яйцо", 80.00F),
            new Product(2, "Масло", 180.10F),
            new Product(3, "Рулет с корицей", 44.20F),
            new Product(4, "Творог деревенский", 99.00F),
            new Product(5, "Яблоки сезонные", 58F));

    public List<Product> getAll() {
        return productList;
    }

    public Product getById(int id) {
        for (Product item : productList) {
            if (id == item.getId()) return item;
        }
        return null;
    }
}

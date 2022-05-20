package com.lesson2.cart.shop;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
public class Cart {

    private List<Product> productList = new ArrayList<>();

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public void showProduct() {
        for (Product product : productList) {
            System.out.printf("Id:%d name:%s price:%5.2f\n", product.getId(),
                    product.getName(), product.getPrice());
        }
    }
}

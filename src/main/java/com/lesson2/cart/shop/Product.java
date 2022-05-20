package com.lesson2.cart.shop;

public class Product {

    private int id;
    private String name;
    private float price;

    public Product(int id, String name, float price) {
        this.name = name;
        this.price = price;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void printProduct() {
        System.out.printf("%d %s %5.2f\n", this.id, this.name, this.price);
    }
}

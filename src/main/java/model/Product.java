package model;

import model.enums.ProductsSeparators;

public class Product {
    private long id;
    private String productName;
    private float price;
    private float weight;
    private String color;
    private int productCount;

    public Product(long id, String productName, float price, float weight, String color, int productCount) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.weight = weight;
        this.color = color;
        this.productCount = productCount;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public long getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public float getPrice() {
        return price;
    }

    public float getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public int getProductCount() {
        return productCount;
    }

    @Override
    public String toString() {
        return ProductsSeparators.PRODUCT_ID.getValue() + ProductsSeparators.PRODUCT_SEPARATOR.getValue() +
                id + ProductsSeparators.PRODUCT_SEPARATOR.getValue() +
                productName + ProductsSeparators.PRODUCT_SEPARATOR.getValue() +
                price + ProductsSeparators.PRODUCT_SEPARATOR.getValue() +
                weight + ProductsSeparators.PRODUCT_SEPARATOR.getValue() +
                color + ProductsSeparators.PRODUCT_SEPARATOR.getValue() +
                productCount;
    }

    public String getBasicProductString() {
        return id + ProductsSeparators.PRODUCT_SEPARATOR.getValue() +
                productName + ProductsSeparators.PRODUCT_SEPARATOR.getValue() +
                price + ProductsSeparators.PRODUCT_SEPARATOR.getValue() +
                weight + ProductsSeparators.PRODUCT_SEPARATOR.getValue() +
                color + ProductsSeparators.PRODUCT_SEPARATOR.getValue() +
                productCount;

    }
}

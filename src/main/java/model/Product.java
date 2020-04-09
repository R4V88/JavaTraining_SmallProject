package model;

import model.enums.Color;
import model.enums.ProductSeparators;

public class Product {
    private long id;
    private String productName;
    private float price;
    private float weight;
    private Color color;
    private int productCount;

    public Product(long id, String productName, float price, float weight, Color color, int productCount) {
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

    public Color getColor() {
        return color;
    }

    public int getProductCount() {
        return productCount;
    }

    @Override
    public String toString() {
        return ProductSeparators.PRODUCT_ID.getValue() + ProductSeparators.PRODUCT_SEPARATOR.getValue() +
                id + ProductSeparators.PRODUCT_SEPARATOR.getValue() +
                productName + ProductSeparators.PRODUCT_SEPARATOR.getValue() +
                price + ProductSeparators.PRODUCT_SEPARATOR.getValue() +
                weight + ProductSeparators.PRODUCT_SEPARATOR.getValue() +
                color + ProductSeparators.PRODUCT_SEPARATOR.getValue() +
                productCount;
    }

    public String getBasicProductString() {
        return id + ProductSeparators.PRODUCT_SEPARATOR.getValue() +
                productName + ProductSeparators.PRODUCT_SEPARATOR.getValue() +
                price + ProductSeparators.PRODUCT_SEPARATOR.getValue() +
                weight + ProductSeparators.PRODUCT_SEPARATOR.getValue() +
                color + ProductSeparators.PRODUCT_SEPARATOR.getValue() +
                productCount;

    }
}

package model;

public class Product {
    public static final String PRODUCT_SEPARATOR = ",";
    private long id;
    private String productName;
    private float price;
    private float weight;
    private String color;
    private int productCount;
    public static final char PRODUCT_TYPE = 'P';

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
        return PRODUCT_TYPE + PRODUCT_SEPARATOR +
                id + PRODUCT_SEPARATOR +
                productName + PRODUCT_SEPARATOR +
                price + PRODUCT_SEPARATOR +
                weight + PRODUCT_SEPARATOR +
                color + PRODUCT_SEPARATOR +
                productCount;
    }

    public String getBasicProductString() {
        return id + PRODUCT_SEPARATOR +
                productName + PRODUCT_SEPARATOR +
                price + PRODUCT_SEPARATOR +
                weight + PRODUCT_SEPARATOR +
                color + PRODUCT_SEPARATOR +
                productCount;

    }
}

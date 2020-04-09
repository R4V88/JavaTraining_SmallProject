package model;

import model.enums.ProductsSeparators;

public class Cloth extends Product {
    private String size;
    private String material;
    public static final char PRODUCT_TYPE = 'C';

    public Cloth(long id, String productName, float price, float weight, String color, int productCount, String size, String material) {
        super(id, productName, price, weight, color, productCount);
        this.size = size;
        this.material = material;
    }

    public String getSize() {
        return size;
    }

    public String getMaterial() {
        return material;
    }

    @Override
    public String toString() {
        return ProductsSeparators.CLOTH_ID.getValue() + ProductsSeparators.PRODUCT_SEPARATOR.getValue() +
                getBasicProductString() + ProductsSeparators.PRODUCT_SEPARATOR.getValue() +
                size + ProductsSeparators.PRODUCT_SEPARATOR.getValue() +
                material + ProductsSeparators.PRODUCT_SEPARATOR.getValue();
    }

}

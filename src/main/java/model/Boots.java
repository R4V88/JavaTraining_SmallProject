package model;

import model.enums.ProductsSeparators;

public class Boots extends Product {
    private int size;
    private boolean isNaturalSkin;

    public Boots(long id, String productName, float price, float weight, String color, int productCount, int size, boolean isNaturalSkin) {
        super(id, productName, price, weight, color, productCount);
        this.size = size;
        this.isNaturalSkin = isNaturalSkin;
    }

    public int getSize() {
        return size;
    }

    public boolean isNaturalSkin() {
        return isNaturalSkin;
    }

    @Override
    public String toString() {
        return ProductsSeparators.BOOTS_ID.getValue() + ProductsSeparators.PRODUCT_SEPARATOR.getValue() +
                getBasicProductString() + ProductsSeparators.PRODUCT_SEPARATOR.getValue() +
                size + ProductsSeparators.PRODUCT_SEPARATOR.getValue() +
                isNaturalSkin;
    }
}

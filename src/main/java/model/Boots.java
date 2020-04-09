package model;

import model.enums.Color;
import model.enums.ProductSeparators;
import model.enums.SkinType;

public class Boots extends Product {
    private int size;
    private SkinType skinType;

    public Boots(long id, String productName, float price, float weight, Color color, int productCount, int size, SkinType skinType) {
        super(id, productName, price, weight, color, productCount);
        this.size = size;
        this.skinType = skinType;
    }

    public int getSize() {
        return size;
    }

    public SkinType isSkinType() {
        return skinType;
    }

    @Override
    public String toString() {
        return ProductSeparators.BOOTS_ID.getValue() + ProductSeparators.PRODUCT_SEPARATOR.getValue() +
                getBasicProductString() + ProductSeparators.PRODUCT_SEPARATOR.getValue() +
                size + ProductSeparators.PRODUCT_SEPARATOR.getValue() +
                skinType;
    }
}

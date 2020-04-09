package model;

import model.enums.Color;
import model.enums.Material;
import model.enums.ProductSeparators;

public class Cloth extends Product {
    private String size;
    private Material material;

    public Cloth(long id, String productName, float price, float weight, Color color, int productCount, String size, Material material) {
        super(id, productName, price, weight, color, productCount);
        this.size = size;
        this.material = material;
    }

    public String getSize() {
        return size;
    }

    public Material getMaterial() {
        return material;
    }

    @Override
    public String toString() {
        return ProductSeparators.CLOTH_ID.getValue() + ProductSeparators.PRODUCT_SEPARATOR.getValue() +
                getBasicProductString() + ProductSeparators.PRODUCT_SEPARATOR.getValue() +
                size + ProductSeparators.PRODUCT_SEPARATOR.getValue() +
                material + ProductSeparators.PRODUCT_SEPARATOR.getValue();
    }

}

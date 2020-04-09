package model.enums;

public enum ProductsSeparators {

    PRODUCT_SEPARATOR(","),
    PRODUCT_ID("P"),
    CLOTH_ID("C"),
    BOOTS_ID("B");

    private String value;

    ProductsSeparators(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

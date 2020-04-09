package model.enums;

public enum ProductsSeparators {

    PRODUCTS_SEPARATOR(","),
    PRODUCT_ID("P"),
    CLOTH_ID("C"),
    BOOTS_ID("B");

    private String separator;

    ProductsSeparators(String separator) {
        this.separator = separator;
    }

    public String getSeparator() {
        return separator;
    }
}

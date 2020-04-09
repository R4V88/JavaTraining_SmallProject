package model.enums;

public enum ProductSeparators {

    PRODUCT_SEPARATOR(","),
    PRODUCT_ID("P"),
    CLOTH_ID("C"),
    BOOTS_ID("B");

    private String value;

    ProductSeparators(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ProductSeparators getIdByChar(String value) {
        for (ProductSeparators id : ProductSeparators.values()) {
            if (id.getValue().equals(value)) {
                return id;
            }
        }
        return null;
    }
}

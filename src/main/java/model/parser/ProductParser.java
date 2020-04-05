package model.parser;

import model.Boots;
import model.Cloth;
import model.Product;

public class ProductParser {
    public static Product stringToProduct(String productStr, String productType) {
        switch (productType) {
            case "CLOTH": {
                return convertToCloth(productStr);
            }
            case "BOOTS": {
                return convertToBoots(productStr);
            }
            default: {
                return convertToProduct(productStr);
            }
        }
    }

    private static String[] productInfoSplitter(String productStr) {
        return productStr.split(Product.PRODUCT_SEPARATOR);
    }

    private static Boots convertToBoots(String productStr) {
        String[] productInformations = productInfoSplitter(productStr);

        long id = Long.parseLong(productInformations[0]);
        String productName = productInformations[1];
        float price = Float.parseFloat(productInformations[2]);
        float weight = Float.parseFloat(productInformations[3]);
        String color = productInformations[4];
        int productCount = Integer.parseInt(productInformations[5]);
        int size = Integer.parseInt(productInformations[6]);
        boolean isNaturalSkin = Boolean.parseBoolean(productInformations[7]);

        return new Boots(id, productName, price, weight, color, productCount, size, isNaturalSkin);
    }

    private static Cloth convertToCloth(String productStr) {
        String[] productInformations = productInfoSplitter(productStr);

        long id = Long.parseLong(productInformations[0]);
        String productName = productInformations[1];
        float price = Float.parseFloat(productInformations[2]);
        float weight = Float.parseFloat(productInformations[3]);
        String color = productInformations[4];
        int productCount = Integer.parseInt(productInformations[5]);
        String size = productInformations[6];
        String material = productInformations[7];

        return new Cloth(id, productName, price, weight, color, productCount, size, material);
    }

    private static Product convertToProduct(String productStr) {
        String[] productInformations = productInfoSplitter(productStr);

        long id = Long.parseLong(productInformations[0]);
        String productName = productInformations[1];
        float price = Float.parseFloat(productInformations[2]);
        float weight = Float.parseFloat(productInformations[3]);
        String color = productInformations[4];
        int productCount = Integer.parseInt(productInformations[5]);

        return new Product(id, productName, price, weight, color, productCount);
    }
}

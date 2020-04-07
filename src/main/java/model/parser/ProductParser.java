package model.parser;

import model.Boots;
import model.Cloth;
import model.Product;

public class ProductParser {

    public static Product stringToProduct(String productStr) {
        final char productType = productStr.charAt(0);
        switch (productType) {
            case Cloth.PRODUCT_TYPE: {
                return convertToCloth(productStr);
            }
            case Boots.PRODUCT_TYPE: {
                return convertToBoots(productStr);
            }
            case Product.PRODUCT_TYPE: {
                return convertToProduct(productStr);
            }
        }
        return null;
    }

    private static String[] productInfoSplitter(String productStr) {
        return productStr.split(Product.PRODUCT_SEPARATOR);
    }

    private static Boots convertToBoots(String productStr) {
        String[] productInformations = productInfoSplitter(productStr);

        long id = Long.parseLong(productInformations[1]);
        String productName = productInformations[2];
        float price = Float.parseFloat(productInformations[3]);
        float weight = Float.parseFloat(productInformations[4]);
        String color = productInformations[5];
        int productCount = Integer.parseInt(productInformations[6]);
        int size = Integer.parseInt(productInformations[7]);
        boolean isNaturalSkin = Boolean.parseBoolean(productInformations[8]);

        return new Boots(id, productName, price, weight, color, productCount, size, isNaturalSkin);
    }

    private static Cloth convertToCloth(String productStr) {
        String[] productInformations = productInfoSplitter(productStr);

        long id = Long.parseLong(productInformations[1]);
        String productName = productInformations[2];
        float price = Float.parseFloat(productInformations[3]);
        float weight = Float.parseFloat(productInformations[4]);
        String color = productInformations[5];
        int productCount = Integer.parseInt(productInformations[6]);
        String size = productInformations[7];
        String material = productInformations[8];

        return new Cloth(id, productName, price, weight, color, productCount, size, material);
    }

    private static Product convertToProduct(String productStr) {
        String[] productInformations = productInfoSplitter(productStr);

        long id = Long.parseLong(productInformations[1]);
        String productName = productInformations[2];
        float price = Float.parseFloat(productInformations[3]);
        float weight = Float.parseFloat(productInformations[4]);
        String color = productInformations[5];
        int productCount = Integer.parseInt(productInformations[6]);

        return new Product(id, productName, price, weight, color, productCount);
    }
}

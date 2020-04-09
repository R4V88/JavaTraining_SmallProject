package model.parser;

import model.Boots;
import model.Cloth;
import model.Product;
import model.enums.Color;
import model.enums.Material;
import model.enums.ProductSeparators;
import model.enums.SkinType;

public class ProductParser {

    public static Product stringToProduct(String productStr) {
        final ProductSeparators productType = ProductSeparators.getIdByChar(productStr.substring(0, 1));
        switch (productType) {
            case CLOTH_ID: {
                return convertToCloth(productStr);
            }
            case BOOTS_ID: {
                return convertToBoots(productStr);
            }
            case PRODUCT_ID: {
                return convertToProduct(productStr);
            }
        }
        return null;
    }

    private static String[] productInfoSplitter(String productStr) {
        return productStr.split(ProductSeparators.PRODUCT_SEPARATOR.getValue());
    }

    private static Boots convertToBoots(String productStr) {
        String[] productInformations = productInfoSplitter(productStr);

        long id = Long.parseLong(productInformations[1]);
        String productName = productInformations[2];
        float price = Float.parseFloat(productInformations[3]);
        float weight = Float.parseFloat(productInformations[4]);
        Color color = ColorParser.parseStrToColor(productInformations[5]);
        int productCount = Integer.parseInt(productInformations[6]);
        int size = Integer.parseInt(productInformations[7]);
        SkinType skinType = SkinParser.parseStrToSkinType(productInformations[8]);

        return new Boots(id, productName, price, weight, color, productCount, size, skinType);
    }

    private static Cloth convertToCloth(String productStr) {
        String[] productInformations = productInfoSplitter(productStr);

        long id = Long.parseLong(productInformations[1]);
        String productName = productInformations[2];
        float price = Float.parseFloat(productInformations[3]);
        float weight = Float.parseFloat(productInformations[4]);
        Color color = ColorParser.parseStrToColor(productInformations[5]);
        int productCount = Integer.parseInt(productInformations[6]);
        String size = productInformations[7];
        Material material = MaterialParser.parseStrToMaterial(productInformations[8]);

        return new Cloth(id, productName, price, weight, color, productCount, size, material);
    }

    private static Product convertToProduct(String productStr) {
        String[] productInformations = productInfoSplitter(productStr);

        long id = Long.parseLong(productInformations[1]);
        String productName = productInformations[2];
        float price = Float.parseFloat(productInformations[3]);
        float weight = Float.parseFloat(productInformations[4]);
        Color color = ColorParser.parseStrToColor(productInformations[5]);
        int productCount = Integer.parseInt(productInformations[6]);

        return new Product(id, productName, price, weight, color, productCount);
    }
}

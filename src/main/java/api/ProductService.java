package api;

import model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    int getCountOfProducts(List<Product> products);

    Product getProductByName(String productName);

    boolean isProductInWarehouse(String productName);

    boolean isProductWithNameExist(String productName);

    boolean isProductWithIdExist(long id);

}

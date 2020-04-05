package api;

import model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    int getCountOfProducts(List<Product> products);

    Product getProductByName(String productName);

    boolean isProductInWarehouse(String productName);

    boolean isProductExist(String productName);

    boolean isProductExist(long id);

}

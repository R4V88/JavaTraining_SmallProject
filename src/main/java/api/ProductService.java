package api;

import model.Product;

import java.io.IOException;
import java.util.List;

public interface ProductService {

    List<Product> getAllProducts() throws IOException;

    int getCountOfProducts() throws IOException;

    Product getProductByName(String productName) throws IOException;

    boolean isProductInWarehouse(String productName);

    boolean isProductExist(String productName);

    boolean isProductExist(long productId);

    boolean saveProduct(Product product);

}

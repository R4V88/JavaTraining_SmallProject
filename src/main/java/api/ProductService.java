package api;

import exception.ProductCountNegativeException;
import exception.ProductNameEmptyException;
import exception.ProductPriceNoPositiveException;
import exception.ProductWeightNoPositiveException;
import model.Product;

import java.io.IOException;
import java.util.List;

public interface ProductService {

    List<Product> getAllProducts() throws IOException;

    int getCountOfProducts() throws IOException;

    Product getProductByName(String productName) throws IOException;

    boolean isProductInWarehouse(String productName) throws IOException;

    boolean isProductExist(String productName) throws IOException;

    boolean isProductExist(long productId) throws IOException;

    boolean saveProduct(Product product) throws ProductWeightNoPositiveException, ProductNameEmptyException, ProductCountNegativeException, ProductPriceNoPositiveException, IOException;
    void removeProduct(String productName) throws Exception;
}

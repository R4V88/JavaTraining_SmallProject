package service;

import api.ProductService;
import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    private List<Product> productsList;

    public ProductServiceImpl() {
        productsList = new ArrayList<>();
    }

    public ProductServiceImpl(List<Product> productsList) {
        this.productsList = productsList;
    }

    @Override
    public List<Product> getAllProducts() {
        return productsList;
    }

    @Override
    public int getCountOfProducts(List<Product> products) {
        return products.size();
    }

    @Override
    public Product getProductByName(String productName) {
        for (Product product : productsList) {
            if (product.getProductName().equals(productName)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public boolean isProductInWarehouse(String productName) {
        for (Product product : productsList) {
            if (product.getProductName().equals(productName) && product.getProductCount() > 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isProductExist(String productName) {
        for (Product product : productsList) {
            if (product.getProductName().equals(productName)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isProductExist(long id) {
        for (Product product : productsList) {
            if (product.getId() == id) {
                return true;
            }
        }
        return false;
    }
}

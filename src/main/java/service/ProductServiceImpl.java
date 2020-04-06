package service;

import api.ProductDao;
import api.ProductService;
import dao.ProductDaoImpl;
import model.Product;

import java.io.IOException;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    private ProductDao productDao = new ProductDaoImpl("products.data", "PRODUCT");
    private static ProductServiceImpl instance = null;

    public static ProductServiceImpl getInstance() {
        if (instance == null) {
            instance = new ProductServiceImpl();
        }
        return instance;
    }

    private ProductServiceImpl() {
    }

    @Override
    public List<Product> getAllProducts() throws IOException {
        return productDao.getAllProducts();
    }

    @Override
    public int getCountOfProducts(List<Product> products) throws IOException {
        return productDao.getAllProducts().size();
    }

    @Override
    public Product getProductByName(String productName) throws IOException {
        return productDao.getProductByProductName(productName);
    }

    @Override
    public boolean isProductInWarehouse(String productName) {
        try {
            for (Product product : productDao.getAllProducts()) {
                if (product.getProductName().equals(productName) && product.getProductCount() > 0) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean isProductExist(String productName) {
        Product product = null;
        try {
            product = productDao.getProductByProductName(productName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (product == null) {
            return false;
        }
        return true;
    }

    @Override
    public boolean isProductExist(long id) {
        Product product = null;

        try {
            product = productDao.getProductById(id);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (product == null) {
            return false;
        }

        return true;
    }
}

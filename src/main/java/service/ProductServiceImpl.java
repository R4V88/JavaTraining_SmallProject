package service;

import api.ProductDao;
import api.ProductService;
import dao.ProductDaoImpl;
import exception.ProductCountNegativeException;
import exception.ProductNameEmptyException;
import exception.ProductPriceNoPositiveException;
import exception.ProductWeightNoPositiveException;
import model.Product;
import validator.ProductValidator;

import java.io.IOException;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    private ProductDao productDao = ProductDaoImpl.getInstance();
    private static ProductServiceImpl instance = null;
    private ProductValidator productValidator = ProductValidator.getInstance();


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
    public int getCountOfProducts() throws IOException {
        return productDao.getAllProducts().size();
    }

    @Override
    public Product getProductByName(String productName) throws IOException {
        List<Product> products = productDao.getAllProducts();

        for (Product product : products) {
            if (product.getProductName().equals(productName)) {
                return product;
            }
        }
        return null;
    }

    public Product getProductById(long id) throws IOException {

        List<Product> products = productDao.getAllProducts();

        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }

        return null;
    }

    @Override
    public boolean isProductInWarehouse(String productName) throws IOException {
            for (Product product : productDao.getAllProducts()) {
                if (product.getProductName().equals(productName) && product.getProductCount() > 0) {
                    return true;
                }
            }
        return false;
    }

    @Override
    public boolean isProductExist(String productName) throws IOException {
        Product product = null;
            product = getProductByName(productName);
        if (product == null) {
            return false;
        }
        return true;
    }

    @Override
    public boolean isProductExist(long id) throws IOException {
        Product product = null;

            product = getProductById(id);

        if (product == null) return false;

        return true;
    }

    @Override
    public boolean saveProduct(Product product) throws ProductWeightNoPositiveException, ProductNameEmptyException, ProductCountNegativeException, ProductPriceNoPositiveException, IOException {
            if (productValidator.isValidate(product)) {
                productDao.saveProduct(product);
                return true;
            }
        return false;
    }

    @Override
    public void removeProduct(String productName) throws Exception {
        productDao.removeProductByName(productName);
    }
}

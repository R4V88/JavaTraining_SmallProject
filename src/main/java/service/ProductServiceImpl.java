package service;

import api.ProductDao;
import api.ProductService;
import dao.ProductDaoImpl;
import model.Product;

import java.io.IOException;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    private ProductDao productDao = ProductDaoImpl.getInstance();
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
    public int getCountOfProducts() throws IOException {
        return productDao.getAllProducts().size();
    }

    @Override
    public Product getProductByName(String productName) throws IOException {
        List<Product> products = productDao.getAllProducts();

        for(Product product : products){
            if(product.getProductName().equals(productName)){
                return product;
            }
        }
        return null;
    }

    public Product getProductById (long id) {
        try {
            List<Product> products = productDao.getAllProducts();

            for(Product product : products){
                if(product.getId() == id){
                    return product;
                }
            }

        } catch (IOException e){
            e.printStackTrace();
        }
        return null;
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
            product = getProductByName(productName);
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
        Product product = getProductById(id);

        return product != null;
    }

    @Override
    public boolean saveProduct(Product product) {
        try {
            List<Product> productList = productDao.getAllProducts();
            for(Product product1 : productList) {
                product.equals(product);
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}

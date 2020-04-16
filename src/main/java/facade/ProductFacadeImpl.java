package facade;

import api.ProductFacade;
import api.ProductService;
import exception.ProductCountNegativeException;
import exception.ProductNameEmptyException;
import exception.ProductPriceNoPositiveException;
import exception.ProductWeightNoPositiveException;
import model.Product;
import service.ProductServiceImpl;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class ProductFacadeImpl implements ProductFacade {

    private final static ProductFacade instance = new ProductFacadeImpl();
    private final ProductService productService = ProductServiceImpl.getInstance();

    private ProductFacadeImpl() {
    }

    public static ProductFacade getInstance(){
        return ProductFacadeImpl.instance;
    }

    @Override
    public String createProduct(Product product) {
        try{
            productService.saveProduct(product);
            return "Create product " + product;
        } catch (IOException e) {
            e.printStackTrace();
            return "[IOException] Error while add product to database";
        }  catch (ProductPriceNoPositiveException | ProductWeightNoPositiveException | ProductNameEmptyException | ProductCountNegativeException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @Override
    public String removeProduct(String productName) {
        try {
            productService.removeProduct(productName);
            return "Removed product";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public List<Product> getAllProducts() {
        try {
            return productService.getAllProducts();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }
}

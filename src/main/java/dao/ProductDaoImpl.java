package dao;

import api.ProductDao;
import model.Product;
import model.parser.ProductParser;
import utils.FileUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

    private final String FILE_NAME;
    private final String PRODUCT_TYPE;

    public ProductDaoImpl(String FILE_NAME, String PRODUCT_TYPE) throws IOException {
        this.FILE_NAME = FILE_NAME;
        this.PRODUCT_TYPE = PRODUCT_TYPE.toUpperCase();
        FileUtils.createNewFile(FILE_NAME);
    }

    @Override
    public List<Product> getAllProducts() throws IOException {
        List<Product> productsList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
        String lineFromFile;
        while ((lineFromFile = br.readLine()) != null) {
            Product product = ProductParser.stringToProduct(lineFromFile, PRODUCT_TYPE);
            if (product != null) {
                productsList.add(product);
            }
        }
        br.close();
        /*
            Loop for tests.
            Needs to be removed.
         */
        for (Product product : productsList) {
            System.out.println(product.toString());
        }

        return productsList;
    }

    @Override
    public void saveProducts(List<Product> products) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new FileOutputStream(FILE_NAME, true));
        for (Product product : products) {
            pw.write(product.toString() + "\n");
        }
        pw.close();
    }

    @Override
    public void saveProduct(Product product) throws IOException {
        List<Product> products = getAllProducts();
        products.add(product);
        saveProducts(products);
    }

    @Override
    public void removeProductById(long productId) throws IOException {
        List<Product> productList = getAllProducts();
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == productId) {
                productList.remove(productList.get(i));
            }
        }
        saveProducts(productList);
    }

    @Override
    public void removeProductByName(String productName) throws IOException {
        List<Product> productList = getAllProducts();
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getProductName().equals(productName)) {
                productList.remove(productList.get(i));
            }
        }
        saveProducts(productList);
    }

    @Override
    public Product getProductById(long productId) throws IOException {
        List<Product> productList = getAllProducts();
        for (Product product : productList) {
            if (product.getId() == productId) {
                return product;
            }
        }
        return null;
    }

    @Override
    public Product getProductByProductName(String productName) throws IOException {
        List<Product> productList = getAllProducts();
        for (Product product : productList) {
            if (product.getProductName().equals(productName)) {
                return product;
            }
        }
        return null;
    }
}

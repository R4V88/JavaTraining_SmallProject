package dao;

import api.ProductDao;
import model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

    private String fileName;

    public ProductDaoImpl() {
        this.fileName = "Products.txt";
    }

    @Override
    public void saveProduct(Product product) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new FileOutputStream(fileName, true));
        pw.write(product.toString() + "\n");
        pw.close();
    }

    @Override
    public void saveProducts(List<Product> products) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new FileOutputStream(fileName, false));
        for (Product product : products) {
            pw.write(product.toString() + "\n");
        }
        pw.close();
    }

    @Override
    public void removeProductById(long productId) throws IOException {
        List<Product> productList = getAllProducts();
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == productId) {
                Product product = productList.get(i);
                productList.remove(product);
            }
        }
        saveProducts(productList);
    }

    @Override
    public void removeProductByName(String productName) throws IOException {
        List<Product> productList = getAllProducts();
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getProductName().equals(productName)) {
                Product product = productList.get(i);
                productList.remove(product);
            }
        }
        saveProducts(productList);
    }

    @Override
    public List<Product> getAllProducts() throws IOException {
        List<Product> productsList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String lineFromFile;
        while ((lineFromFile = br.readLine()) != null) {
            String[] userString = stringToArrayConverter(lineFromFile);
            productsList.add(new Product(
                    Long.parseLong(userString[0]),
                    userString[1],
                    Float.parseFloat(userString[2]),
                    Float.parseFloat(userString[3]),
                    userString[4],
                    Integer.parseInt(userString[5])
            ));
        }
        br.close();
        return productsList;
    }

    public String[] stringToArrayConverter(String string) {
        String[] stringArray = null;
        stringArray = string.split(",");
        return stringArray;
    }

    @Override
    public void getProductById(long productId) throws IOException {
        List<Product> productList = getAllProducts();
        for (Product product : productList) {
            if (product.getId() == productId) {
                System.out.println(product.toString());
            }
        }
    }

    @Override
    public void getProductByProductName(String productName) throws IOException {
        List<Product> productList = getAllProducts();
        for (Product product : productList) {
            if (product.getProductName().equals(productName)) {
                System.out.println(product.toString());
            }
        }
    }
}

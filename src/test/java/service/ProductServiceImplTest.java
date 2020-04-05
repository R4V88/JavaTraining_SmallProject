package service;

import model.Product;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImplTest {

    //positive test
    @Test
    public void testGetAllProducts() {
        //is
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Gacie", 20f, 0.5f, "red", 2));
        products.add(new Product(2, "t-shirt", 100f, 1f, "black", 4));
        products.add(new Product(4, "longsleeve", 120f, 1.25f, "white", 1));
        products.add(new Product(10, "ultrabook", 2000f, 1.5f, "spacegrey", 10));

        //then
        ProductServiceImpl productService = new ProductServiceImpl(new ArrayList<>(products));
        List<Product> productsFromTestClass = productService.getAllProducts();

        //expected
        Assert.assertEquals(products, productsFromTestClass);
    }

    //negative test
    @Test
    public void testGetAllProductsWhenSomething() {
        //is
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Gacie", 20f, 0.5f, "red", 2));
        products.add(new Product(2, "t-shirt", 100f, 1f, "black", 4));
        products.add(new Product(4, "longsleeve", 120f, 1.25f, "white", 1));
        products.add(new Product(10, "ultrabook", 2000f, 1.5f, "spacegrey", 10));
        Product cookies = new Product(12, "Oreo", 9.99f, 0.25f, "black'N'white", 9999);
        products.add(cookies);

        //then
        ProductServiceImpl productService = new ProductServiceImpl(new ArrayList<>(products));
        List<Product> productsFromTestClass = productService.getAllProducts();

        //remove 1 element from products
        products.remove(cookies);

        //expected
        Assert.assertNotEquals(products, productsFromTestClass);
    }

    //positive test
    @Test
    public void testGetCountOfProducts() {
        //is
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Gacie", 20f, 0.5f, "red", 2));
        products.add(new Product(2, "t-shirt", 100f, 1f, "black", 4));
        products.add(new Product(4, "longsleeve", 120f, 1.25f, "white", 1));
        products.add(new Product(10, "ultrabook", 2000f, 1.5f, "spacegrey", 10));

        //then
        ProductServiceImpl productService = new ProductServiceImpl(new ArrayList<>(products));
        List<Product> productsFromTestClass = productService.getAllProducts();

        //expected
        Assert.assertEquals(products.size(), productsFromTestClass.size());
    }

    //negative test
    @Test
    public void testGetCountOfProductsWhenDifferentSizes() {
        //is
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Gacie", 20f, 0.5f, "red", 2));
        products.add(new Product(2, "t-shirt", 100f, 1f, "black", 4));
        products.add(new Product(4, "longsleeve", 120f, 1.25f, "white", 1));
        products.add(new Product(10, "ultrabook", 2000f, 1.5f, "spacegrey", 10));
        Product cookies = new Product(12, "Oreo", 9.99f, 0.25f, "black'N'white", 999999999);
        products.add(cookies);


        //then
        ProductServiceImpl productService = new ProductServiceImpl(new ArrayList<>(products));
        List<Product> productsFromTestClass = productService.getAllProducts();

        //remove 1 element from products
        products.remove(cookies);

        //expected
        Assert.assertNotEquals(products.size(), productsFromTestClass.size());
    }

    //positive test
    @Test
    public void testGetProductByName() {
        //is
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Gacie", 20f, 0.5f, "red", 2));
        products.add(new Product(2, "t-shirt", 100f, 1f, "black", 4));
        products.add(new Product(4, "longsleeve", 120f, 1.25f, "white", 1));
        products.add(new Product(10, "ultrabook", 2000f, 1.5f, "spacegrey", 10));

        //then
        ProductServiceImpl productService = new ProductServiceImpl(new ArrayList<>(products));
        List<Product> productsFromTestClass = productService.getAllProducts();
        String productName = products.get(0).getProductName();
        String productNameFromTestClass = productsFromTestClass.get(0).getProductName();

        //expected
        Assert.assertEquals(productName, productNameFromTestClass);
    }

    //negative test
    @Test
    public void testGetProductByNameWhenDifferentIndexes() {
        //is
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Gacie", 20f, 0.5f, "red", 2));
        products.add(new Product(2, "t-shirt", 100f, 1f, "black", 4));
        products.add(new Product(4, "longsleeve", 120f, 1.25f, "white", 1));
        products.add(new Product(10, "ultrabook", 2000f, 1.5f, "spacegrey", 10));

        //then
        ProductServiceImpl productService = new ProductServiceImpl(new ArrayList<>(products));
        List<Product> productsFromTestClass = productService.getAllProducts();
        String productName = products.get(1).getProductName();
        String productNameFromTestClass = productsFromTestClass.get(0).getProductName();

        //expected
        Assert.assertNotEquals(productName, productNameFromTestClass);
    }

    //positive test
    @Test
    public void testIsProductInWarehouse() {
        //is
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Gacie", 20f, 0.5f, "red", 2));
        products.add(new Product(2, "t-shirt", 100f, 1f, "black", 4));
        products.add(new Product(4, "longsleeve", 120f, 1.25f, "white", 1));
        products.add(new Product(10, "ultrabook", 2000f, 1.5f, "spacegrey", 10));
        Product cookies = new Product(12, "Oreo", 9.99f, 0.25f, "black'N'white", 999999999);
        products.add(cookies);

        //then
        ProductServiceImpl productService = new ProductServiceImpl(new ArrayList<>(products));
        List<Product> productsFromTestClass = productService.getAllProducts();
        Boolean booleanFromTestClass = productsFromTestClass.contains(cookies);

        Boolean isProduct = products.contains(cookies);

        //expected
        Assert.assertEquals(isProduct, booleanFromTestClass);
    }

    //negative test
    @Test
    public void testIsProductInWarehouseWhenDeleted() {
        //is
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Gacie", 20f, 0.5f, "red", 2));
        products.add(new Product(2, "t-shirt", 100f, 1f, "black", 4));
        products.add(new Product(4, "longsleeve", 120f, 1.25f, "white", 1));
        products.add(new Product(10, "ultrabook", 2000f, 1.5f, "spacegrey", 10));
        Product cookies = new Product(12, "Oreo", 9.99f, 0.25f, "black'N'white", 999999999);
        products.add(cookies);

        //then
        ProductServiceImpl productService = new ProductServiceImpl(new ArrayList<>(products));
        List<Product> productsFromTestClass = productService.getAllProducts();
        productsFromTestClass.remove(cookies);
        Boolean booleanFromTestClass = productsFromTestClass.contains(cookies);

        Boolean isProduct = products.contains(cookies);

        //expected
        Assert.assertNotEquals(isProduct, booleanFromTestClass);
    }

    //positive test
    @Test
    public void testIsProductWithNameExist() {
        //is
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Gacie", 20f, 0.5f, "red", 2));
        products.add(new Product(2, "t-shirt", 100f, 1f, "black", 4));
        products.add(new Product(4, "longsleeve", 120f, 1.25f, "white", 1));
        products.add(new Product(10, "ultrabook", 2000f, 1.5f, "spacegrey", 10));
        Product cookies = new Product(12, "Oreo", 9.99f, 0.25f, "black'N'white", 999999999);
        products.add(cookies);

        //then
        ProductServiceImpl productService = new ProductServiceImpl(new ArrayList<>(products));
        Boolean isProductWithName = productService.isProductExist("Oreo");

        Boolean isCookie = products.contains(cookies);

        //expected
        Assert.assertEquals(isCookie, isProductWithName);
    }

    //negative test
    @Test
    public void testIsProductWithNameExistWhenThereIsNotAny() {
        //is
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Gacie", 20f, 0.5f, "red", 2));
        products.add(new Product(2, "t-shirt", 100f, 1f, "black", 4));
        products.add(new Product(4, "longsleeve", 120f, 1.25f, "white", 1));
        products.add(new Product(10, "ultrabook", 2000f, 1.5f, "spacegrey", 10));
        Product cookies = new Product(12, "Oreo", 9.99f, 0.25f, "black'N'white", 999999999);
        products.add(cookies);

        //then
        ProductServiceImpl productService = new ProductServiceImpl(new ArrayList<>(products));
        List<Product> productsFromTestClass = productService.getAllProducts();
        productsFromTestClass.remove(cookies);
        Boolean isProductWithName = productService.isProductExist("Oreo");

        Boolean isCookie = products.contains(cookies);

        //expected
        Assert.assertNotEquals(isCookie, isProductWithName);

    }

    //positive test
    @Test
    public void TestIsProductWithIdExist() {
        //is
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Gacie", 20f, 0.5f, "red", 2));
        products.add(new Product(2, "t-shirt", 100f, 1f, "black", 4));
        products.add(new Product(4, "longsleeve", 120f, 1.25f, "white", 1));
        products.add(new Product(10, "ultrabook", 2000f, 1.5f, "spacegrey", 10));
        Product cookies = new Product(12, "Oreo", 9.99f, 0.25f, "black'N'white", 999999999);
        products.add(cookies);

        //then
        ProductServiceImpl productService = new ProductServiceImpl(new ArrayList<>(products));
        Boolean isCookieInTestClass = productService.isProductExist(12);

        Boolean isCookie = products.contains(cookies);

        //expected
        Assert.assertEquals(isCookie, isCookieInTestClass);
    }

    //negative test
    @Test
    public void TestIsProductWithIdExistsWhenDeleted() {
        //is
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Gacie", 20f, 0.5f, "red", 2));
        products.add(new Product(2, "t-shirt", 100f, 1f, "black", 4));
        products.add(new Product(4, "longsleeve", 120f, 1.25f, "white", 1));
        products.add(new Product(10, "ultrabook", 2000f, 1.5f, "spacegrey", 10));
        Product cookies = new Product(12, "Oreo", 9.99f, 0.25f, "black'N'white", 999999999);
        products.add(cookies);

        //then
        ProductServiceImpl productService = new ProductServiceImpl(new ArrayList<>(products));
        List<Product> productsFromTestClass = productService.getAllProducts();
        productsFromTestClass.remove(cookies);
        Boolean isCookieInTestClass = productService.isProductExist(12);

        Boolean isCookie = products.contains(cookies);

        //expected
        Assert.assertNotEquals(isCookie, isCookieInTestClass);
    }
}
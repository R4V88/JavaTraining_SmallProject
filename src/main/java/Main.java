import exception.UserLoginAlreadyExistException;
import exception.UserShortLengthLoginException;
import exception.UserShortLengthPasswordException;
import model.User;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, UserLoginAlreadyExistException, UserShortLengthPasswordException, UserShortLengthLoginException {
//        User user = new User(1l, "admin", "admin");
//
//        Cloth cloth = new Cloth(1l, "T-shirt", 35.9f, 0.3f, "Black", 10,"XL", "Cotton");
//        Boots boots = new Boots(1l, "High heels", 99.9f, .5f, "Red", 12, 35, true);
//
//        System.out.println(user.toString());
//        System.out.println(cloth.toString());
//        System.out.println(boots.toString());
//
//        List<Integer> numbers = new ArrayList<Integer>();
//        numbers.add(5);
//        numbers.add(7);
//        numbers.add(3);
//
//        numbers.remove(1);
//        numbers.size();
//
//        Product product1 = new Product(11, "buty", 120, 15, "czerwone", 3);
//        Product product2 = new Product(12, "buty", 120, 15, "czerwone", 3);
//        Product product3 = new Product(13, "buty", 120, 15, "czerwone", 3);
//        Product product4 = new Product(14, "buty", 120, 15, "czerwone", 3);
//        ProductDaoImpl productDaoImpl = new ProductDaoImpl();
//        List<Product> productList = new ArrayList<>();
//        productList.add(product1);
//        productList.add(product2);
//        productList.add(product3);
//        productList.add(product4);
//        productDaoImpl.saveProducts(productList);
//        productDaoImpl.getAllProducts();
//        productDaoImpl.removeProductById(13);
//
//        productDaoImpl.saveProduct(product1);
//        productDaoImpl.saveProduct(product2);
//        productDaoImpl.saveProduct(product3);
//        productDaoImpl.saveProduct(product4);
//        productDaoImpl.removeProductById(2);
//
//        List<User> users = new ArrayList<>();
//        User user1 = new User(12, "marek1", "marek1");
//        User user2 = new User(13, "marek2", "marek1");
//        User user3 = new User(14, "marek3", "marek1");
//        users.add(user1);
//        users.add(user2);
//        users.add(user3);
//
//        UserDaoImpl userDao = new UserDaoImpl();
//        userDao.saveUsers(users);
//        userDao.getAllUsers();


//        ProductDaoImpl bootsOnly = new ProductDaoImpl("Products.txt", "boots");
//        List<Product> productList = new ArrayList<>();
//        Product bootki = new Boots(1, "sofixy", 120, 15, "black", 24, 99, true);
//        productList.add(bootki);
//        bootsOnly.saveProducts(productList);
//        bootsOnly.getAllProducts();

//        ProductDao productDaoCloth = new ProductDaoImpl("clothes", "cloth");
//        productDaoCloth.saveProduct(new Cloth(1, "T-shirt", 11f, 0.5f, "black", 12, "L", "cotton"));
//
//        UserValidator userValidator = UserValidator.getInstance();
//        UserDao userDao = UserDaoImpl.getInstance();
//        User user = new User(2, "tak", "pass");
////        userValidator.isValidate(user);
//        userDao.saveUser(user);
    }
}

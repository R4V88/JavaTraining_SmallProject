package service;

import model.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImplTest {

    @Test
    public void testGetAllUsers() {
        //is
        List<User> users = new ArrayList<>();
        users.add(new User(11, "admin", "admin"));
        users.add(new User(21, "pablo", "admin"));

        //then
        UserServiceImpl userService = new UserServiceImpl(users);
        List<User> usersFromTestClass = userService.getAllUsers();

        //expected
        Assert.assertEquals(users, usersFromTestClass);
    }

    @Test
    public void testAddUser() {
        //is
        List<User> users = new ArrayList<>();
        User user = new User(11, "admin", "admin");
        users.add(user);

        //then
        UserServiceImpl userService = new UserServiceImpl();
        userService.addUser(user);
        List<User> usersFromTestCase = userService.getAllUsers();

        //expected
        Assert.assertEquals(users, usersFromTestCase);
    }

    @Test
    public void testRemoveUser() {
        //is
        List<User> users = new ArrayList<>();
        User admin = new User(11, "admin", "admin");
        User pablo = new User(21, "pablo", "admin");
        users.add(admin);
        users.add(pablo);

        //then
        UserServiceImpl userService = new UserServiceImpl(users);
        userService.removeUserById(11);
        users.remove(admin);
        List<User> usersFromTestClass = userService.getAllUsers();

        //expected
        Assert.assertEquals(users, usersFromTestClass);
    }
}
package service;

import api.UserService;
import dao.UserDaoImpl;
import model.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDaoImpl userDao;
    private List<User> users;

    private static UserServiceImpl instance = null;

    public static UserServiceImpl getInstance() {
        if (instance == null) {
            instance = new UserServiceImpl();
        }
        return instance;
    }

    //    konstruktor domyślny
    private UserServiceImpl() {
        this.users = new ArrayList<>();
    }

    //    konstruktor parametryzowany
    private UserServiceImpl(List<User> users) {
        this.users = users;
    }

    @Override
    public List<User> getAllUsers() throws IOException {
        return userDao.getAllUsers();
    }

    @Override
    public void addUser(User user) throws IOException {
        userDao.saveUser(user);
    }

    @Override
    public void removeUserById(long userId) throws IOException {
        userDao.removeUserById(userId);
    }
}

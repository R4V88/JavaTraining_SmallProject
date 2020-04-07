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
    public boolean addUser(User user) {
        try {
            userDao.saveUser(user);
            List<User> users = userDao.getAllUsers();
            for (User user1 : users) {
                if (user1.equals(user)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void removeUserById(long userId) throws IOException {
        userDao.removeUserById(userId);
    }

    @Override
    public User getUserById(long id) {
        return null;
    }

    @Override
    public User getUserByLogin(String login) {
        return null;
    }

    @Override
    public boolean isCorrectLoginAndPassword(String login, String password) {
        return false;
    }
}

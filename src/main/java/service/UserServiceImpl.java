package service;

import api.UserDao;
import api.UserService;
import dao.UserDaoImpl;
import exception.UserLoginAlreadyExistException;
import exception.UserShortLengthLoginException;
import exception.UserShortLengthPasswordException;
import model.User;
import validator.UserValidator;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao = UserDaoImpl.getInstance();
    private UserValidator userValidator = UserValidator.getInstance();

    private static UserServiceImpl instance = null;

    public static UserServiceImpl getInstance() {
        if (instance == null) {
            instance = new UserServiceImpl();
        }
        return instance;
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public boolean addUser(User user) throws UserLoginAlreadyExistException, UserShortLengthPasswordException, UserShortLengthLoginException {
        if (isLoginAlreadyExist(user.getLogin())) {
            throw new UserLoginAlreadyExistException();
        }
        if (userValidator.isValidate(user)) {
            userDao.saveUser(user);
            return true;
        }
        return false;
    }

    private boolean isLoginAlreadyExist(String login) {
        User user = getUserByLogin(login);
        return user != null;
    }

    @Override
    public void removeUserById(long userId) {
        userDao.removeUserById(userId);
    }

    @Override
    public User getUserById(long id) {
        List<User> users = getAllUsers();
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User getUserByLogin(String login) {
        List<User> users = null;
        users = getAllUsers();
        for (User user : users) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public boolean isCorrectLoginAndPassword(String login, String password) {
        User found = getUserByLogin(login);

        if (found == null) {
            return false;
        }

        boolean isCorrectLogin = found.getLogin().equals(login);
        boolean isCorrectPass = found.getPassword().equals(password);

        return isCorrectLogin && isCorrectPass;
    }
}

package validator;

import api.UserDao;
import dao.UserDaoImpl;
import exception.UserLoginAlreadyExistException;
import exception.UserShortLengthLoginException;
import exception.UserShortLengthPasswordException;
import model.User;

import java.io.IOException;

public class UserValidator {

    private final int MIN_LENGTH_PASSWORD = 6;
    private final int MIN_LENGTH_LOGIN = 4;

    private static UserValidator instance = null;
    private UserDao userDao = UserDaoImpl.getInstance();

    private UserValidator() {

    }

    public static UserValidator getInstance() {
        if (instance == null) {
            instance = new UserValidator();
        }
        return instance;
    }

    public boolean isValidate(User user) throws UserShortLengthPasswordException, UserShortLengthLoginException, UserLoginAlreadyExistException {
        if (isPasswordValid(user.getPassword())) {
            throw new UserShortLengthPasswordException("Password is too short!");
        }
        if (isLoginValid(user.getLogin())) {
            throw new UserShortLengthLoginException("Login is too short!");
        }
        if (isLoginExist(user.getLogin())) {
            throw new UserLoginAlreadyExistException("User with this login already exists!");
        }
        return true;
    }

    private boolean isPasswordValid(String password) {
        return password.length() >= MIN_LENGTH_PASSWORD;
    }

    private boolean isLoginValid(String login) {
        return login.length() >= MIN_LENGTH_LOGIN;
    }

    private boolean isLoginExist(String login) {
        User user = null;
        try {
            user = userDao.getUserByLogin(login);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (user == null) {
            return false;
        }
        return true;
    }

}

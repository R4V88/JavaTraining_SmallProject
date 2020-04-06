package validator;

import api.UserService;
import exception.UserLoginAlreadyExistException;
import exception.UserShortLengthLoginException;
import exception.UserShortLengthPasswordException;
import model.User;

import java.util.List;

public class UserValidator {

    private UserService userService;

    private static UserValidator instance = null;

    public static UserValidator getInstance() {
        if(instance == null) {
            instance = new UserValidator();
        }
        return instance;
    }

    public boolean isValidate(User user) throws UserShortLengthPasswordException, UserShortLengthLoginException, UserLoginAlreadyExistException {
        return isPasswordValid(user) && isLoginValid(user) && isLoginExist(user);
    }

    private boolean isPasswordValid(User user) throws UserShortLengthPasswordException {
        if(user.getPassword().length() < 6){
            return true;
        }
        throw new UserShortLengthPasswordException("Password is too short!");
    }

    private boolean isLoginValid(User user) throws UserShortLengthLoginException {
        if(user.getLogin().length() < 4){
            return true;
        }
        throw new UserShortLengthLoginException("Login " + user.getLogin() + " is too short!");
    }

    private boolean isLoginExist(User user) throws UserLoginAlreadyExistException {
        List<User> userList = userService.getAllUsers();
        for(User userFromList : userList){
            if(userFromList.getLogin().equals(user.getLogin())){
                throw new UserLoginAlreadyExistException("User *" + user.getLogin() + "* already exist!");
            }
        }
        return true;
    }

}

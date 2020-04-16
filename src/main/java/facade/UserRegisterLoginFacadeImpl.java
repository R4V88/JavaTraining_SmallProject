package facade;

import api.UserRegisterLoginFacade;
import api.UserService;
import exception.UserLoginAlreadyExistException;
import exception.UserShortLengthLoginException;
import exception.UserShortLengthPasswordException;
import model.User;
import service.UserServiceImpl;

public class UserRegisterLoginFacadeImpl implements UserRegisterLoginFacade {

    private UserService userService = UserServiceImpl.getInstance();

    private static UserRegisterLoginFacade instance = null;

    private UserRegisterLoginFacadeImpl() {
    }

    public static UserRegisterLoginFacade getInstance() {
        if (instance == null) {
            instance = new UserRegisterLoginFacadeImpl();
        }
        return instance;
    }

    @Override
    public String registerUser(User user) {
        try {
            userService.addUser(user);
            return "Register successfully";
        } catch (UserLoginAlreadyExistException | UserShortLengthLoginException | UserShortLengthPasswordException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @Override
    public boolean loginUser(String login, String password) {
        if (userService.isCorrectLoginAndPassword(login, password)) {
            return true;
        }
        return false;
    }

}

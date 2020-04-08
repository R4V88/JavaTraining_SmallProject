package facade;

import api.UserRegisterLoginFacade;
import api.UserService;
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
    public boolean registerUser(User user) {
        return userService.addUser(user);
    }

    @Override
    public boolean loginUser(String login, String password) {
        if (userService.isCorrectLoginAndPassword(login, password)) {
            return true;
        }

        return false;
    }

}

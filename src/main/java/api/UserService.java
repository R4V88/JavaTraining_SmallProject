package api;

import model.User;

import java.io.IOException;
import java.util.List;

public interface UserService {

    List<User> getAllUsers() throws IOException;

    boolean addUser(User user);

    void removeUserById(long userId) throws IOException;

    User getUserById(long id) throws IOException;

    User getUserByLogin(String login) throws IOException;

    boolean isCorrectLoginAndPassword(String login, String password);
}

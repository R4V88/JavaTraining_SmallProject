package api;

import model.User;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface UserDao {
    void saveUser(User user) throws IOException;

    void saveUsers(List<User> users) throws FileNotFoundException;

    List<User> getAllUsers() throws IOException;

    User getUserByLogin(String login) throws IOException;

    User getUserById(long id) throws IOException;

    void removeUserByLogin(String login) throws IOException;

    void removeUserById(long id) throws IOException;
}

package dao;

import api.UserDao;
import model.User;
import model.parser.UserParser;
import utils.FileUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private final String FILE_NAME;

    public UserDaoImpl(String FILE_NAME) throws IOException {
        this.FILE_NAME = FILE_NAME;
        FileUtils.createNewFile(FILE_NAME);
    }

    @Override
    public void saveUsers(List<User> users) throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME, true));
        for (User user : users) {
            pw.write(user.toString() + "\n");
        }
        pw.close();
    }

    @Override
    public void saveUser(User user) throws IOException {
        List<User> users = getAllUsers();
        users.add(user);
        saveUsers(users);
    }

    @Override
    public List<User> getAllUsers() throws IOException {
        List<User> users = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
        String lineFromFile;
        while ((lineFromFile = br.readLine()) != null) {
            User user = UserParser.stringToUser(lineFromFile);
            users.add(user);
        }
        br.close();
        return users;
    }

    @Override
    public User getUserByLogin(String login) throws IOException {
        List<User> userList = getAllUsers();
        for (User user : userList) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User getUserById(long id) throws IOException {
        List<User> userList = getAllUsers();
        for (User user : userList) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void removeUserByLogin(String login) throws IOException {
        List<User> userList = getAllUsers();
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getLogin().equals(login)) {
                userList.remove(userList.get(i));
            }
        }
        saveUsers(userList);

    }

    @Override
    public void removeUserById(long id) throws IOException {
        List<User> userList = getAllUsers();
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getId() == id) {
                userList.remove(userList.get(i));
            }
        }
        saveUsers(userList);
    }
}

package service;

import api.UserService;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    private List<User> users;

    //    konstruktor domyślny
    public UserServiceImpl() {
        this.users = new ArrayList<>();
    }

    //    konstruktor parametryzowany
    public UserServiceImpl(List<User> users) {
        this.users = users;
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public void removeUserById(long userId) {
        for (int i = 0; i < users.size(); i++) {
            User userFromList = users.get(i);
            if (userFromList.getId() == userId) {
                users.remove(i);
            }
        }
    }
}

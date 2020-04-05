package dao;

import api.UserDao;
import model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private String fileName;

    public UserDaoImpl() {
        this.fileName = "Users.txt";
    }

    @Override
    public void saveUser(User user) throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter(fileName, true));
        pw.write(user.toString() + "\n");
        pw.close();
    }

    @Override
    public void saveUsers(List<User> users) throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter(fileName, true));
        for (User user : users){
            pw.write(user.toString() + "\n");
        }
        pw.close();
    }

    @Override
    public List<User> getAllUsers() throws IOException {
        List<User> users = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String lineFromFile;
        while((lineFromFile = br.readLine()) != null) {
            String[] convertedString = stringToArrayConverter(lineFromFile);
            users.add(new User(Long.parseLong(convertedString[0]), convertedString[1], convertedString[2]));
        }
        br.close();
        return users;
    }

    public String[] stringToArrayConverter(String string) {
        String[] stringArray = null;
        stringArray = string.split(",");
        return stringArray;
    }

    @Override
    public void getUserByLogin(String login) throws IOException {
        List<User> userList = getAllUsers();
        for(User user : userList){
            if(user.getLogin().equals(login)){
                System.out.println(user.toString());
            }
        }
    }

    @Override
    public void getUserById(long id) throws IOException {
        List<User> userList = getAllUsers();
        for(User user : userList){
            if(user.getId() == id){
                System.out.println(user.toString());
            }
        }
    }

    @Override
    public void removeUserByLogin(String login) throws IOException {
        List<User> userList = getAllUsers();
        for(int i = 0; i < userList.size(); i++){
            if(userList.get(i).getLogin().equals(login)){
                userList.remove(userList.get(i));
            }
        }
        saveUsers(userList);

    }

    @Override
    public void removeUserById(long id) throws IOException {
        List<User> userList = getAllUsers();
        for(int i = 0; i < userList.size(); i++){
            if(userList.get(i).getId() == id){
                userList.remove(userList.get(i));
            }
        }
        saveUsers(userList);
    }
}

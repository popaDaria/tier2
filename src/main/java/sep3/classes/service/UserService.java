package sep3.classes.service;

import sep3.classes.Model.User;

import java.util.ArrayList;

public interface UserService {
    ArrayList<User> getAllUsers();
    User getUser(String id);
    void addUser(User user);
    void deleteUser(String id);
    void editUser(User user);
}

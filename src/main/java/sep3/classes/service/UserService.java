package sep3.classes.service;

import sep3.classes.Model.User;

import java.util.ArrayList;

public interface UserService {
    public ArrayList<User> getAllUsers();
    public User getUser(int id);
    public void addUser(User user);
    public void deleteUser(int id);
    public void editUser(User user);
}

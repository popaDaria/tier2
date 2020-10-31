package sep3.classes.socketClient;

import sep3.classes.Model.User;

import java.util.ArrayList;

public interface SocketClient {
    public ArrayList<User> getAllUsers();
    public User getUser(int id);
    public void addUser(User user);
    public void deleteUser(int id);
    public void editUser(User user);
    void startClient();
}

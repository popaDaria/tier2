package sep3.classes.socketClient;

import sep3.classes.Model.User;

import java.util.ArrayList;

public interface SocketClient {
    ArrayList<User> getAllUsers();
    User getUser(int id);
    void addUser(User user);
    void deleteUser(int id);
    void editUser(User user);
    void startClient();
    void disconnect();
}

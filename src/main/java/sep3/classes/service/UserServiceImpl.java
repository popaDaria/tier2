package sep3.classes.service;

import org.springframework.stereotype.Service;
import sep3.classes.socketClient.SocketClient;
import sep3.classes.Model.User;

import java.util.ArrayList;

@Service
public class UserServiceImpl implements UserService {

    private SocketClient socketClient;

    public UserServiceImpl(SocketClient socketClient) {
        this.socketClient = socketClient;
        socketClient.startClient();
    }


    @Override
    public ArrayList<User> getAllUsers() { return socketClient.getAllUsers(); }

    @Override
    public User getUser(int id) {
        return socketClient.getUser(id);
    }

    @Override
    public void addUser(User user) {
       socketClient.addUser(user);
    }

    @Override
    public void deleteUser(int id) {
     socketClient.deleteUser(id);
    }

    @Override
    public void editUser(User user) {
     socketClient.editUser(user);
    }


}

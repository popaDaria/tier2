package sep3.classes.socketClient;

import org.springframework.stereotype.Component;
import sep3.classes.Model.Request;
import sep3.classes.Model.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

@Component
public class SocketClientImpl implements SocketClient {

    private final static String HOST = "localhost";
    private final static int PORT = 2910;
    private ObjectInputStream inFromServer;
    private ObjectOutputStream outToServer;
    private Socket socket;
    private Request receivedMessage;

   // private PropertyChangeSupport support;
    public SocketClientImpl() {

      //  support = new PropertyChangeSupport(this);
    }

    @Override
    public void startClient() {
        try {
            socket = new Socket(HOST, PORT);
            outToServer = new ObjectOutputStream(socket.getOutputStream());
            inFromServer = new ObjectInputStream(socket.getInputStream());
            //new Thread(() -> listenToServer(outToServer, inFromServer)).start();

            SocketClientReceiver clientReceiver = new SocketClientReceiver(this,inFromServer);
            Thread thread = new Thread(clientReceiver);
            thread.setDaemon(true);
            thread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void disconnect(){
        try {
            inFromServer.close();
            outToServer.close();
            socket.close();
            System.out.println("Connection terminated....");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<User> getAllUsers() {

        try {
            Request response = request("GetAllUsers", null);
            return (ArrayList<User>) response.getArg();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User getUser(int id) {
        try {
            Request response = request("GetUser", id);
            return (User) response.getArg();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addUser(User user) {
        try {
            Request response = request("AddUser", user);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteUser(int id) {
        try {
            Request response = request("DeleteUser", id);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editUser(User user) {
        try {
            Request response = request("EditUser", user);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void setReceivedMessage(Request request){
        receivedMessage=request;
    }

    private Request request(String type,Object arg) throws IOException, ClassNotFoundException {
        outToServer.writeObject(new Request(type, arg));
        return (Request) inFromServer.readObject();
    }

    /*private void listenToServer(ObjectOutputStream outToServer, ObjectInputStream inFromServer) {
        try {
            while (true) {
                Request request = (Request) inFromServer.readObject();
                // support.firePropertyChange(request.getType(), null, request.getArg());
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }*/
}

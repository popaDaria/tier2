package sep3.classes.socketClient;

import org.springframework.stereotype.Component;
import sep3.classes.Model.Request;
import sep3.classes.Model.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import static java.lang.Thread.sleep;

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

            System.out.println("Client connected...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void disconnect(){
        System.out.println("Terminating connection....");
        try {
            inFromServer.close();
            outToServer.close();
            socket.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<User> getAllUsers() {

        try {
            Request response = request("GetAllUsers", null);
            System.out.println(response.getType());
            if(response!=null) {
                return (ArrayList<User>) response.getArg();
            }else
                return new ArrayList<>();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User getUser(int id) {
        try {
            Request response = request("GetUser", id);
            if(response!=null) {
                return (User) response.getArg();
            }else
                return null;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addUser(User user) {
        try {
            Request response = request("AddUser", user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(int id) {
        try {
            Request response = request("DeleteUser", id);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editUser(User user) {
        try {
            Request response = request("EditUser", user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized void setReceivedMessage(Request request){
        //sets received messages here
        receivedMessage=request;
    }

    private synchronized Request getReceivedMessage() {
        return receivedMessage;
    }

    private synchronized Request request(String type, Object arg) throws IOException{
        outToServer.writeObject(new Request(type, arg));
        //return (Request) inFromServer.readObject();
        try {
            wait(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return getReceivedMessage();
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

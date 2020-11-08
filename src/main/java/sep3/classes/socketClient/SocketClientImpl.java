package sep3.classes.socketClient;

import org.springframework.stereotype.Component;
import sep3.classes.Model.*;

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
        startClient();
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
    public ArrayList<Hospital> getAllHospitals() {
        try {
            Request response = request("GetAllHospitals", null);
            System.out.println(response.getType());
            if(response!=null) {
                return (ArrayList<Hospital>) response.getArg();
            }else
                return new ArrayList<>();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Hospital getHospital(int id) {
        try {
            Request response = request("GetHospital", id);
            if(response!=null) {
                return (Hospital) response.getArg();
            }else
                return null;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addHospital(Hospital hospital) {
        try {
            Request response = request("AddHospital", hospital);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteHospital(int id) {
        try {
            Request response = request("DeleteHospital", id);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editHospital(Hospital hospital) {
        try {
            Request response = request("EditHospital", hospital);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public MedicalRecord getMedicalRecord(int id) {
        try {
            Request response = request("GetRecord", id);
            if(response!=null) {
                return (MedicalRecord) response.getArg();
            }else
                return null;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addMedicalRecord(MedicalRecord medicalRecord) {
        try {
            Request response = request("AddRecord", medicalRecord);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editMedicalRecord(MedicalRecord medicalRecord) {
        try {
            Request response = request("EditRecord", medicalRecord);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Rating> getAllRatings() {
        try {
            Request response = request("GetAllRatings", null);
            System.out.println(response.getType());
            if(response!=null) {
                return (ArrayList<Rating>) response.getArg();
            }else
                return new ArrayList<>();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Rating> getRating(int id) {
        try {
            Request response = request("GetRating", id);
            if(response!=null) {
                return (ArrayList<Rating>) response.getArg();
            }else
                return new ArrayList<>();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    public void addRating(Rating rating) {
        try {
            Request response = request("AddRating", rating);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editRating(Rating rating) {
        try {
            Request response = request("EditRating", rating);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public double getAvgRating(int hospitalId) {
        try {
            Request response = request("GetAverageRating", hospitalId);
            if(response!=null) {
                return (double) response.getArg();
            }else
                return 0;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public ArrayList<Message> getAllMessages() {
        try {
            Request response = request("GetAllMessages", null);
            System.out.println(response.getType());
            if(response!=null) {
                return (ArrayList<Message>) response.getArg();
            }else
                return new ArrayList<>();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Message> getUserMessages(int userId) {
        try {
            Request response = request("GetUserMessages", userId);
            if(response!=null) {
                return (ArrayList<Message>) response.getArg();
            }else
                return new ArrayList<>();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    public void addMessage(Message message) {
        try {
            Request response = request("AddMessage", message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteMessage(Message message) {
        try {
            Request response = request("DeleteMessage", message);
        } catch (IOException e) {
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
            wait(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return getReceivedMessage();
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

package sep3.classes.socketClient;

import sep3.classes.Model.Request;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.ObjectInputStream;

public class SocketClientReceiver implements Runnable {
    private ObjectInputStream inputStream;
    private SocketClientImpl client;
    //private Request receivedMessage;

    public SocketClientReceiver(SocketClientImpl client, ObjectInputStream inputStream){
        this.client=client;
        this.inputStream=inputStream;
    }


    @Override
    public void run() {
        while (true){
            try {
                Request request = (Request) inputStream.readObject();
                client.setReceivedMessage(request);
                //receivedMessage=request;
            }catch (IOException | ClassNotFoundException e){
                e.printStackTrace();
            }
        }
    }
}

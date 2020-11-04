package sep3.classes.service;

import org.springframework.stereotype.Service;
import sep3.classes.Model.Message;
import sep3.classes.socketClient.SocketClient;

import java.util.ArrayList;

@Service
public class MessageServiceImpl implements MessageService {
    private SocketClient socketClient;

    public MessageServiceImpl(SocketClient socketClient) {
        this.socketClient = socketClient;
        //socketClient.startClient();
    }

    @Override
    public ArrayList<Message> getAllMessages() {
        return socketClient.getAllMessages();
    }

    @Override
    public ArrayList<Message> getUserMessages(int userId) {
        return socketClient.getUserMessages(userId);
    }

    @Override
    public void addMessage(Message message) {
        socketClient.addMessage(message);
    }

    @Override
    public void deleteMessage(Message message) {
        socketClient.deleteMessage(message);
    }
}

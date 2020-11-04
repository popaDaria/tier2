package sep3.classes.service;

import sep3.classes.Model.Message;

import java.util.ArrayList;

public interface MessageService {
    ArrayList<Message> getAllMessages();
    ArrayList<Message> getUserMessages(int userId);
    void addMessage(Message message);  //send message
    void deleteMessage(Message message);
}

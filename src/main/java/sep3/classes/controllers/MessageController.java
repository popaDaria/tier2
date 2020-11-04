package sep3.classes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sep3.classes.Model.Message;
import sep3.classes.service.MessageService;

import java.util.ArrayList;

@RestController
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    MessageService service;

    //crud-create
    @PostMapping
    public void addMessage(@RequestBody final Message message){
        try {
            service.addMessage(message);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    //crud-get
    @GetMapping("/all")
    public ArrayList<Message> getAllMessages(){
        return service.getAllMessages();
    }

    @GetMapping
    public ArrayList<Message> getUserMessages(@RequestParam(name = "userId") final String userId){
        try {
            int i = Integer.parseInt(userId);
            return service.getUserMessages(i);
        }catch (Exception e){
            System.out.println("Invalid input");
            return new ArrayList<>();
        }
    }

    //crud-delete
    @DeleteMapping
    public void deleteMessage(@RequestBody final Message message){
        try {
            service.deleteMessage(message);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}

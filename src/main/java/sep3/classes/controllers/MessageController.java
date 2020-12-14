package sep3.classes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sep3.classes.Model.Message;
import sep3.classes.service.MessageService;

import java.util.ArrayList;
import java.util.Collections;

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

        @GetMapping("/notifications")
        public ArrayList<Message> getNotifs(){
            try{
                ArrayList<Message> all = service.getAllMessages();
                ArrayList<Message> notifs = new ArrayList<>();
                for (Message msg: all) {
                    if(msg.getMessageType().equals("notification")){
                        notifs.add(msg);
                    }
                }
                return notifs;
            }catch (Exception e){
                System.out.println("No notifs");
                return new ArrayList<>();
            }
        }

        @GetMapping("/sentTo")
        public ArrayList<Message> getMessagesFromTo(@RequestParam(name = "senderId") final String senderId,
                                                    @RequestParam(name = "receiverId") final String receiverId){
            try{
                int rId = Integer.parseInt(receiverId);
                int sId = Integer.parseInt(senderId);
                //ArrayList<Message> msgs = service.getUserMessages(rId);
                ArrayList<Message> result = new ArrayList<>();
                ArrayList<Message> msgs = service.getAllMessages();
                for (Message message:msgs) {
                    if((message.getSenderId()==sId&&message.getReceiverId()==rId)
                            ||(message.getSenderId()==rId&&message.getReceiverId()==sId)){
                        result.add(message);
                    }
                }
                /*msgs = service.getUserMessages(sId);
                for (Message message:msgs) {
                    if(message.getSenderId()==rId){
                        result.add(message);
                    }
                }*/
                return result;

            }catch (Exception e){
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

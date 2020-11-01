package sep3.classes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sep3.classes.service.UserService;
import sep3.classes.Model.User;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService service;

    //crud-create
    @PostMapping
    public void addUser(@RequestBody final User user){
        service.addUser(user);
        System.out.println("===>>> User with idNr "+user.getIdNr()+" has been added");
    }

    //crud-retrieve
    @GetMapping("/all")
    public List<User> getAllUsers(){
        //returns an empty array list if no users exist
        try {
            return service.getAllUsers();
        }catch (Exception e){
            System.out.println("Exception...");
            return new ArrayList<>();
        }
    }

    @GetMapping
    public User getUser(@RequestParam(name="idNr") final String idNr){
        try {
            int id = Integer.parseInt(idNr);
            //TODO: Will return null if no user found
            return service.getUser(id);
        }catch (Exception e){
            System.out.println("!!! User not found or incorrect input");
            return null;
        }
    }

    @GetMapping("/type")
    public List<User> getAllUsersOfAType(@RequestParam(name="userType") final String userType){
        try {
            List<User> allUsers = service.getAllUsers();
            List<User> toReturn = new ArrayList<>();
            for (User user : allUsers) {
                if (user.getUserType().equals(userType)) {
                    toReturn.add(user);
                }
            }
            return toReturn;
        }catch (Exception e){
            System.out.println("!!! User not found or incorrect input");
            return new ArrayList<>();
        }
    }

    @GetMapping("/unvalidated")
    public List<User> getUnvalidatedUsers(){
        try{
            List<User> allUsers = service.getAllUsers();
            List<User> toReturn = new ArrayList<>();
            for (User user : allUsers) {
                if (!user.isValidated()) {
                    toReturn.add(user);
                }
            }
            return toReturn;
        }catch (Exception e){
            System.out.println("!!! User not found or incorrect input");
            return new ArrayList<>();
        }
    }


    //crud-update
    @PatchMapping
    public void editUser(@RequestBody final User user){
        service.editUser(user);
        System.out.println("===>>> User with idNr "+user.getIdNr()+" has been updated");
    }

    //crud-delete
    @DeleteMapping("/{idNr}")
    @ResponseBody
    public void deleteUser(@PathVariable("idNr") final String id){
        try {
            int i = Integer.parseInt(id);
            service.deleteUser(i);
            System.out.println("===>>> User with idNr "+id+" has been deleted");
        }catch (Exception e){
            System.out.println("!!! User not found or incorrect input");
        }
    }
}

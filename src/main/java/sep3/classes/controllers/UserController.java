package sep3.classes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sep3.classes.service.UserService;
import sep3.classes.Model.User;

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
    @GetMapping("/get")
    public List<User> getAllUsers(){
        return service.getAllUsers();
    }

    @GetMapping
    public User getUser(@RequestParam(name="idNr") final String id){
        try {
            int idNr = Integer.parseInt(id);
            return service.getUser(idNr);
        }catch (Exception e){
            System.out.println("!!! User not found or incorrect input");
            return null;
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

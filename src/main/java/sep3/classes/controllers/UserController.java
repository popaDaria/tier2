package sep3.classes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sep3.classes.Model.Hospital;
import sep3.classes.Model.User;
import sep3.classes.service.UserService;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService service;

    //crud-create
    @PutMapping
    public String addUser(@RequestBody final User user){
        try {
            ArrayList<User> all = service.getAllUsers();
            boolean found=false;
            for (User us:all) {
                if(us.getIdNr()==user.getIdNr())
                    found=true;
            }
            if(!found) {
                service.addUser(user);
                System.out.println("===>>> User with idNr " + user.getIdNr() + " has been added");
                return "OK";
            }else {
                System.out.println("User with same idNr already added");
                return "NOT";
            }
        }catch (Exception e){
            System.out.println("User with same idNr already added or invalid input");
            return "NOT";
        }
    }


    @PutMapping("/doctor")
    public void addDoctor(@RequestBody final User user){
        try {
            ArrayList<User> all = service.getAllUsers();
            boolean exists=false;
            for (User us:all) {
                if(us.getIdNr()==user.getIdNr())
                    exists=true;
            }
            if(!exists) {
                service.addUser(user);
                System.out.println("===>>> Doctor with idNr " + user.getIdNr() + " has been added");
            }else{
                System.out.println("Doctor already added!");
            }
        }catch (Exception e){
            System.out.println("Invalid input");
        }

    }


    //crud-retrieve
    @GetMapping("/validate")
    public User validateUser(@RequestParam(name="idNr") final String idNr,
                               @RequestParam(name = "password")final String password){
        try {
            int id = Integer.parseInt(idNr);
            User user = service.getUser(id);
            if(user!=null)
            {
                if(user.getPassword().equals(password))
                    return user;
                else
                    return null;
            }
            else return null;
        }catch (Exception e){
            System.out.println("!!! User not found or incorrect input");
            return null;
        }
    }

    @GetMapping("/manager")
    public String validateManager(@RequestParam(name = "id") final String id){
        try{
            int i= Integer.parseInt(id);
            User user = service.getUser(i);
            if(user!=null) {
                user.setValidated(true);
                service.editUser(user);
                System.out.println("Validated");
                return "validated";
            }
            System.out.println("not found");
            return "not found";
        }catch (Exception e){
            System.out.println("Invalid input");
            return "not found";
        }
    }

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

    @GetMapping("/name")
    public String getFullName(@RequestParam(name="idNr") final String idNr){
        try{
            int id = Integer.parseInt(idNr);
            User user = service.getUser(id);
            String name = user.getFirstname()+" "+user.getLastname();
            return name;
        }catch (Exception e){
            System.out.println("user not found!");
            return "";
        }
    }

    @GetMapping
    public User getUser(@RequestParam(name="idNr") final String idNr){
        try {
            int id = Integer.parseInt(idNr);
            System.out.println("User with id "+id+" returning...");
            //TODO: Will return null if no user found
            return service.getUser(id);
        }catch (Exception e){
            System.out.println("!!! User not found or incorrect input");
            return null;
        }
    }

    @GetMapping("/type")
    public List<String> getAllUsersOfAType(@RequestParam(name="userType") final String userType){
        try {
            //Hashtable<Integer, String> table = new Hashtable<>();
            System.out.println("REQUESTED USER TYPE:"+userType);
            List<User> allUsers = service.getAllUsers();
            List<String> toReturn = new ArrayList<>();
            for (User user : allUsers) {
                if (user.getUserType().equals(userType)) {
                    toReturn.add(user.getIdNr()+"-"+user.getFirstname()+" "+user.getLastname());
                    //table.put(user.getIdNr(), user.getFirstname()+" "+user.getLastname());
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

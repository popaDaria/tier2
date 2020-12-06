package sep3.classes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sep3.classes.Model.Hospital;
import sep3.classes.Model.HospitalDoctor;
import sep3.classes.Model.User;
import sep3.classes.service.HospitalDoctorService;
import sep3.classes.service.UserService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/hospitalDoctor")
public class HospitalDoctorController {

    @Autowired
    HospitalDoctorService service;
    @Autowired
    UserService userService;

    //crud-create
    @PostMapping
    public void addHospitalDoctor(@RequestBody final HospitalDoctor hospitalDoctor){
        try {
            ArrayList<HospitalDoctor> allForDoctor = service.getHospitalDoctor(hospitalDoctor.getDoctorId());
            boolean exists = false;
            for (HospitalDoctor hs:allForDoctor) {
                if(hs.getHospitalId()==hospitalDoctor.getHospitalId())
                    exists=true;
            }
            if(!exists) {
                service.addHospitalDoctor(hospitalDoctor);
                System.out.println("Hospital Doctor added");
            }else{
                System.out.println("Doctor already working in this hospital");
            }
        }catch (Exception e){
            System.out.println("invalid input");
        }
    }

    //crud-retrieve
    @GetMapping
    public List<HospitalDoctor> getHospitalDoctor(@RequestParam(name = "id") final String id){
        try {
            int doctorId = Integer.parseInt(id);
            return service.getHospitalDoctor(doctorId);
        }catch (Exception e){
            System.out.println("Incorrect input or no doctor found");
            return new ArrayList<>();
        }
    }

    @GetMapping("/doctors")
    public List<User> getDepartmentDoctors(@RequestParam(name = "hosId") final String id,
                                           @RequestParam(name = "dept") final String dept){
        try {
            int hospitalId = Integer.parseInt(id);
            ArrayList<Integer> docIds = service.getDoctorIds(hospitalId, dept);
            ArrayList<User> doctors = new ArrayList<>();
            for (int i: docIds) {
                User user = userService.getUser(i);
                doctors.add(user);
            }
            return doctors;
        }catch (Exception e){
            System.out.println("Incorrect input or no doctor found");
            return new ArrayList<>();
        }
    }

    //crud-delete
    @DeleteMapping
    public void deleteHospitalDoctor(@RequestBody final HospitalDoctor hospitalDoctor){
        try {
            service.deleteHospitalDoctor(hospitalDoctor);
        }catch (Exception e){
            System.out.println("HospitalDoctor not found");
        }
    }

}

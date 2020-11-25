package sep3.classes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sep3.classes.Model.Hospital;
import sep3.classes.Model.HospitalDoctor;
import sep3.classes.service.HospitalDoctorService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/hospitalDoctor")
public class HospitalDoctorController {

    @Autowired
    HospitalDoctorService service;

    //crud-create
    @PostMapping
    public void addHospitalDoctor(@RequestBody final HospitalDoctor hospitalDoctor){
        service.addHospitalDoctor(hospitalDoctor);
        System.out.println("Hospital Doctor added");
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

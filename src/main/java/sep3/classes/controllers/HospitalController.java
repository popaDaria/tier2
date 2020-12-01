package sep3.classes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sep3.classes.Model.Hospital;
import sep3.classes.service.HospitalService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/hospitals")
public class HospitalController {

    @Autowired
    HospitalService service;

    //crud-create
    @PostMapping
    public void addHospital(@RequestBody Hospital hospital){
        ArrayList<Hospital> all = service.getAllHospitals();
        boolean exists = false;
        for (Hospital hos:all) {
            if(hos.getManagerId()==hospital.getManagerId()&&hos.getName().equals(hos.getName()))
                exists=true;
        }
        if(!exists)
            service.addHospital(hospital);
        else
            System.out.println("Hospital already added!");
    }

    //crud-retrieve
    @GetMapping("/all")
    public List<Hospital> getAllHospitals(){
        try {
            return service.getAllHospitals();
        }catch (Exception e){
            return new ArrayList<>();
        }
    }

    @GetMapping
    public Hospital getHospital(@RequestParam(name = "id") final String id){
        try {
            int i = Integer.parseInt(id);
            return service.getHospital(i);
        }catch (Exception e){
            System.out.println("Invalid input");
            return null;
        }
    }

    @GetMapping("/departments")
    public List<String> getDepartmentsOfHospital(@RequestParam(name = "id") final String id){
        try {
            int hosId = Integer.parseInt(id);
            return service.getDepartmentsOfHospital(hosId);
        }catch (Exception e){
            System.out.println("Invalid input");
            return new ArrayList<>();
        }
    }

    //crud-update

    @PatchMapping
    public void updateHospital(@RequestBody Hospital hospital){
        service.editHospital(hospital);
    }

    //crud-delete
    @DeleteMapping("/{id}")
    @ResponseBody
    public void deleteHospital(@PathVariable("id")final String id){
        try {
            int i = Integer.parseInt(id);
            service.deleteHospital(i);
        }catch (Exception e){
            System.out.println("Invalid input");
        }
    }

}

package sep3.classes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sep3.classes.Model.MedicalRecord;
import sep3.classes.service.MedicalRecordService;

@RestController
@RequestMapping("/records")
public class MedicalRecordController {

    @Autowired
    MedicalRecordService service;

    //crud - retrieve
    @GetMapping("/{patientId}")
    @ResponseBody
    public MedicalRecord getMedicalRecord(@PathVariable("patientId")final String patientId){
        try {
            int i = Integer.parseInt(patientId);
            return service.getMedicalRecord(i);
        }catch (Exception e){
            System.out.println("Invalid input");
            return null;
        }
    }
}

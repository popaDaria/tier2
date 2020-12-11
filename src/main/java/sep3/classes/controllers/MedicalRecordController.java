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

    //crud-create
    @PostMapping
    public void addMedicalRecord(@RequestBody final MedicalRecord medicalRecord){
        try {
            MedicalRecord medicalRecord1 = null;
            medicalRecord1 = service.getMedicalRecord(medicalRecord.getPatientId());
            if(medicalRecord1==null)
                 service.addMedicalRecord(medicalRecord);
            else
                service.editMedicalRecord(medicalRecord);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

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

    //crud-update
    @PatchMapping
    public void editMedicalRecord(@RequestBody final MedicalRecord medicalRecord){
        try {
            service.editMedicalRecord(medicalRecord);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

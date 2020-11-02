package sep3.classes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sep3.classes.Model.Appointment;
import sep3.classes.service.AppointmentService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    AppointmentService service;

    //crud-create
    @PostMapping
    public void addAppointment(@RequestBody final Appointment appointment){
        service.addAppointment(appointment);
    }

    //crud-retrieve
    @GetMapping("/patient/{patientId}")
    @ResponseBody
    public List<Appointment> getAllForPatient(@PathVariable("patientId") final String patientId){
        try {
            int id = Integer.parseInt(patientId);
            List<Appointment> appointments = service.getAllAppointments();
            List<Appointment> patientsAppt = new ArrayList<>();
            for (Appointment appt:appointments) {
                if(appt.getPatientId()==id)
                    patientsAppt.add(appt);
            }
            return patientsAppt;
        }catch (Exception e){
            System.out.println("Invalid input");
            return new ArrayList<>();
        }
    }

    @GetMapping("/doctor/{doctorId}")
    @ResponseBody
    public List<Appointment> getAllForDoctor(@PathVariable("doctorId") final String doctorId){
        try {
            int id = Integer.parseInt(doctorId);
            List<Appointment> appointments = service.getAllAppointments();
            List<Appointment> doctorsAppt = new ArrayList<>();
            for (Appointment appt:appointments) {
                if(appt.getDoctorId()==id)
                    doctorsAppt.add(appt);
            }
            return doctorsAppt;
        }catch (Exception e){
            System.out.println("Invalid input");
            return new ArrayList<>();
        }
    }

    @GetMapping
    public Appointment getAppointment(@RequestParam(name = "patientId")final String patientId,
                                      @RequestParam(name = "doctorId")final String doctorId){
        try {
            int pId = Integer.parseInt(patientId);
            int dId = Integer.parseInt(doctorId);
            return service.getAppointment(pId,dId);
        }catch (Exception e){
            System.out.println("Invalid input");
            return null;
        }
    }

    //crud-update
    @PatchMapping
    public void updateAppointment(@RequestBody final Appointment appointment){
        service.updateAppointment(appointment);
    }

    //crud-delete
    @DeleteMapping
    public void deleteAppointment(@RequestParam(name = "patientId")final String patientId,
                                  @RequestParam(name = "doctorId")final String doctorId){
        try {
            int pId = Integer.parseInt(patientId);
            int dId = Integer.parseInt(doctorId);
            service.deleteAppointment(pId,dId);
        }catch (Exception e){
            System.out.println("Invalid input");
        }
    }
}

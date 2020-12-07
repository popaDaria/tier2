package sep3.classes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sep3.classes.Model.AvailableDay;
import sep3.classes.service.AvailableDayService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/availableDays")
public class AvailableDayController {

    @Autowired
    AvailableDayService service;

    //crud-create
    @PostMapping
    public void addAvailableDay(@RequestBody final AvailableDay availableDay){
        service.addAvailableDay(availableDay);
    }

    //crud-retrieve
    @GetMapping("/{doctorId}")
    @ResponseBody
    public List<AvailableDay> getAvailableDays(@PathVariable("doctorId")final String doctorId){
        try {
            int i = Integer.parseInt(doctorId);
            return service.getAvailableDays(i);
        }catch (Exception e){
            System.out.println("Invalid input");
            return new ArrayList<>();
        }
    }

    //crud-update
    @PatchMapping
    public void updateAvailableDay(@RequestBody final AvailableDay availableDay){
        service.deleteAvailableDay(availableDay);
        service.addAvailableDay(availableDay);
    }

    //crud-delete
    @DeleteMapping
    public void deleteAvailableDay(@RequestBody final AvailableDay availableDay){
        service.deleteAvailableDay(availableDay);
    }
}

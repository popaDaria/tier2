package sep3.classes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sep3.classes.Model.Rating;
import sep3.classes.service.RatingService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    RatingService service;

    //crud-create
    @PostMapping
    public void addRating(@RequestBody Rating rating){
        service.addRating(rating);
    }

    //crud-retrieve
    @GetMapping("/all")
    public List<Rating> getAllRatings(){
        try {
            return service.getAllRatings();
        }catch (Exception e){
            return new ArrayList<>();
        }
    }

    @GetMapping
    public Rating getRating(@RequestParam(name = "hospitalId")final String hospitalId, @RequestParam(name = "idNr") final String idNr){
        try {
            int hId= Integer.parseInt(hospitalId);
            int id=Integer.parseInt(idNr);
            return service.getRating(hId,id);
        }catch (Exception e){
            System.out.println("Invalid input");
            return null;
        }
    }

    //crud-update
    @PatchMapping
    public void updateRating(@RequestBody Rating rating){
        service.updateRating(rating);
    }
}

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
        ArrayList<Rating> all = service.getRating(rating.getIdNr());
        boolean update=false;
        for (Rating rt:all) {
            if(rt.getHospitalId()==rating.getHospitalId()){
                update=true;
            }
        }
        if(update){
            service.updateRating(rating);
        }else {
            service.addRating(rating);
        }
    }

    //crud-retrieve
    /*@GetMapping("/all")
    public List<Rating> getAllRatings(){
        try {
            return service.getAllRatings();
        }catch (Exception e){
            return new ArrayList<>();
        }
    }*/

    @GetMapping
    public Rating getRatingForHospitalFromUser(@RequestParam(name = "hospitalId")final String hospitalId, @RequestParam(name = "idNr") final String idNr){
        try {
            int hId= Integer.parseInt(hospitalId);
            int id=Integer.parseInt(idNr);
            ArrayList<Rating> ratings = service.getRating(id);
            Rating rating=null;
            for (Rating ra : ratings) {
                if(ra.getHospitalId()==hId)
                    rating=ra;
            }
            return rating;
        }catch (Exception e){
            System.out.println("Invalid input");
            return null;
        }
    }

    @GetMapping("/hospital")
    /*public List<Rating> getRatingForHospital(@RequestParam(name = "hospitalId")final String hospitalId){
        try {
            int hId= Integer.parseInt(hospitalId);
            List<Rating> ratings = service.getAllRatings();
            List<Rating> toReturn = new ArrayList<>();
            for (Rating ra : ratings) {
                if(ra.getHospitalId()==hId)
                    toReturn.add(ra);
            }
            return toReturn;
        }catch (Exception e){
            System.out.println("Invalid input");
            return new ArrayList<>();
        }
    }
*/
    //crud-update
    @PatchMapping
    public void updateRating(@RequestBody Rating rating){
        service.updateRating(rating);
    }


}

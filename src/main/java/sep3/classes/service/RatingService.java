package sep3.classes.service;

import sep3.classes.Model.Rating;

import java.util.ArrayList;

public interface RatingService {

    void addRating(Rating rating);
    ArrayList<Rating> getRating(int idNr);
    ArrayList<Rating> getAllRatings();
    void updateRating(Rating rating);
    //void deleteRating(int hospitalId, int idNr);
    double getAvgRating(int hospitalId);
}

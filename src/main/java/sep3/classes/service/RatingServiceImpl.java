package sep3.classes.service;


import org.springframework.stereotype.Service;
import sep3.classes.Model.Rating;
import sep3.classes.socketClient.SocketClient;

import java.util.ArrayList;

@Service
public class RatingServiceImpl implements RatingService{

    private SocketClient socketClient;

    public RatingServiceImpl(SocketClient socketClient) {
        this.socketClient = socketClient;
        //socketClient.startClient();
    }

    @Override
    public void addRating(Rating rating) {
        //socketClient.addRating(rating);
    }

    @Override
    public Rating getRating(int hospitalId, int idNr) {
        return null;
        //return socketClient.getRating(hospitalId,idNr);
    }

    @Override
    public ArrayList<Rating> getAllRatings() {
        return null;
        //return socketClient.getAllRatings();
    }

    @Override
    public void updateRating(Rating rating) {
        //socketClient.updateRating(rating);
    }
}

package sep3.classes.service;

import org.springframework.stereotype.Service;
import sep3.classes.Model.AvailableDay;
import sep3.classes.socketClient.SocketClient;

import java.util.Date;
import java.util.List;

@Service
public class AvailableDayServiceImpl implements AvailableDayService {

    private SocketClient socketClient;

    public AvailableDayServiceImpl(SocketClient socketClient) {
        this.socketClient = socketClient;
        //socketClient.startClient();
    }

    @Override
    public void deleteAvailableDay(AvailableDay availableDay) {

    }

    @Override
    public void updateAvailableDay(AvailableDay availableDay) {

    }

    @Override
    public List<AvailableDay> getAvailableDays(int doctorId) {
        return null;
    }

    @Override
    public void addAvailableDay(AvailableDay availableDay) {

    }
}

package sep3.classes.service;

import org.springframework.stereotype.Service;
import sep3.classes.Model.Hospital;
import sep3.classes.socketClient.SocketClient;

import java.util.ArrayList;

@Service
public class HospitalServiceImpl implements HospitalService {

    private SocketClient socketClient;

    public HospitalServiceImpl(SocketClient socketClient) {
        this.socketClient = socketClient;
        //socketClient.startClient();
    }

    @Override
    public ArrayList<Hospital> getAllHospitals() {
        return null;
    }

    @Override
    public Hospital getHospital(int id) {
        return null;
    }

    @Override
    public void addHospital(Hospital hospital) {

    }

    @Override
    public void deleteHospital(int id) {

    }

    @Override
    public void editHospital(Hospital hospital) {

    }
}

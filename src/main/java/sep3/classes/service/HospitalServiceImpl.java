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
        return socketClient.getAllHospitals();
    }

    @Override
    public Hospital getHospital(int id) {
        return socketClient.getHospital(id);
    }

    @Override
    public void addHospital(Hospital hospital) {
        socketClient.addHospital(hospital);
    }

    @Override
    public void deleteHospital(int id) {
        socketClient.deleteHospital(id);
    }

    @Override
    public void editHospital(Hospital hospital) {
        socketClient.editHospital(hospital);
    }

    @Override
    public ArrayList<String> getDepartmentsOfHospital(int hospitalId) {
        return socketClient.getDepartmentsOfHospital(hospitalId);
    }
}

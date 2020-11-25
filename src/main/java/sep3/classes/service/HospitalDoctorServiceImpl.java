package sep3.classes.service;

import org.springframework.stereotype.Service;
import sep3.classes.Model.HospitalDoctor;
import sep3.classes.socketClient.SocketClient;

import java.util.ArrayList;

@Service
public class HospitalDoctorServiceImpl implements HospitalDoctorService{

    private SocketClient socketClient;

    public HospitalDoctorServiceImpl(SocketClient socketClient) {
        this.socketClient = socketClient;
        //socketClient.startClient();
    }

    @Override
    public ArrayList<HospitalDoctor> getHospitalDoctor(int doctorId) {
        return socketClient.getHospitalDoctor(doctorId);
    }

    @Override
    public void addHospitalDoctor(HospitalDoctor hospitalDoctor) {
        socketClient.addHospitalDoctor(hospitalDoctor);
    }

    @Override
    public void deleteHospitalDoctor(HospitalDoctor hospitalDoctor) {
        socketClient.deleteHospitalDoctor(hospitalDoctor);
    }
}

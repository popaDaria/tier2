package sep3.classes.service;

import org.springframework.stereotype.Service;
import sep3.classes.Model.MedicalRecord;
import sep3.classes.socketClient.SocketClient;

@Service
public class MedicalRecordServiceImpl implements MedicalRecordService {

    private SocketClient socketClient;

    public MedicalRecordServiceImpl(SocketClient socketClient) {
        this.socketClient = socketClient;
        //socketClient.startClient();
    }

    @Override
    public MedicalRecord getMedicalRecord(int patientId) {
        //socketClient.getMedicalRecord(patientId);
        return null;
    }
}

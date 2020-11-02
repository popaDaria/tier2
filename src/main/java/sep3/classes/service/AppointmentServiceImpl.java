package sep3.classes.service;

import org.springframework.stereotype.Service;
import sep3.classes.Model.Appointment;
import sep3.classes.socketClient.SocketClient;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService{

    private SocketClient socketClient;

    public AppointmentServiceImpl(SocketClient socketClient) {
        this.socketClient = socketClient;
        //socketClient.startClient();
    }

    @Override
    public void deleteAppointment(int patientId, int doctorId) {
        //socketClient.deleteAppointment(patientId,doctorId);
    }

    @Override
    public void updateAppointment(Appointment appointment) {
        //socketClient.updateAppointment(appointment);
    }

    @Override
    public void addAppointment(Appointment appointment) {
        //socketClient.addAppointment(appointment);
    }

    @Override
    public Appointment getAppointment(int patientId, int doctorId) {
        return null;
        //return socketClient.getAppointment(patientId,doctorId);
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return null;
        //return socketClient.getAllAppointments();
    }
}

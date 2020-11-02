package sep3.classes.service;

import sep3.classes.Model.Appointment;

import java.util.List;

public interface AppointmentService {

    void deleteAppointment(int patientId, int doctorId);
    void updateAppointment(Appointment appointment);
    void addAppointment(Appointment appointment);
    Appointment getAppointment(int patientId, int doctorId);
    List<Appointment> getAllAppointments();
}

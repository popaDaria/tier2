package sep3.classes.socketClient;

import sep3.classes.Model.*;

import java.util.ArrayList;

public interface SocketClient {

    //USERS
    ArrayList<User> getAllUsers();
    User getUser(int id);
    void addUser(User user);
    void deleteUser(int id);
    void editUser(User user);
    void startClient();

    //HOSPITALS
    ArrayList<Hospital> getAllHospitals();
    Hospital getHospital(int id);
    void addHospital(Hospital hospital);
    void deleteHospital(int id);
    void editHospital(Hospital hospital);
    ArrayList<String> getDepartmentsOfHospital(int hospitalId);

    //MEDICAL RECORDS
    MedicalRecord getMedicalRecord(int id);
    void addMedicalRecord(MedicalRecord medicalRecord);
    //void deleteMedicalRecord(int id);
    void editMedicalRecord(MedicalRecord medicalRecord);

    //RATINGS
    ArrayList<Rating> getAllRatings();
    ArrayList<Rating> getRating(int id);
    void addRating(Rating rating);
    //void deleteRating(int id);
    void editRating(Rating rating);
    double getAvgRating(int hospitalId);

    //MESSAGES
    ArrayList<Message> getAllMessages();
    ArrayList<Message> getUserMessages(int userId);
    void addMessage(Message message);  //send message
    void deleteMessage(Message message);

    //APPOINTMENTS
    ArrayList<Appointment> getAllAppointments();
    //public User getAppointment(int doctorId);
    void addAppointment(Appointment appointment);
    void deleteAppointment(Appointment appointment);
    //public void editAppointment(Appointment appointment);

    //AVAILABLE DAYS
    ArrayList<AvailableDay> getAvailableDays(int doctorId);
    void addAvailableDay(AvailableDay availableDay);
    void deleteAvailableDay(AvailableDay availableDay);

    //HOSPITAL-DOCTOR
    ArrayList<HospitalDoctor> getHospitalDoctor(int doctorId);
    void addHospitalDoctor(HospitalDoctor hospitalDoctor);
    void deleteHospitalDoctor(HospitalDoctor hospitalDoctor);


    void disconnect();
}

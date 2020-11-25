package sep3.classes.service;

import sep3.classes.Model.Hospital;
import sep3.classes.Model.User;

import java.util.ArrayList;

public interface HospitalService {
    ArrayList<Hospital> getAllHospitals();
    Hospital getHospital(int id);
    void addHospital(Hospital hospital);
    void deleteHospital(int id);
    void editHospital(Hospital hospital);
    ArrayList<String> getDepartmentsOfHospital(int hospitalId);
}

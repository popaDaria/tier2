package sep3.classes.service;

import sep3.classes.Model.HospitalDoctor;

import java.util.ArrayList;

public interface HospitalDoctorService {
    ArrayList<HospitalDoctor> getHospitalDoctor(int doctorId);
    void addHospitalDoctor(HospitalDoctor hospitalDoctor);
    void deleteHospitalDoctor(HospitalDoctor hospitalDoctor);
}

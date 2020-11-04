package sep3.classes.service;

import sep3.classes.Model.MedicalRecord;

public interface MedicalRecordService {

    MedicalRecord getMedicalRecord(int patientId);
    void editMedicalRecord(MedicalRecord medicalRecord);
    void addMedicalRecord(MedicalRecord medicalRecord);
}

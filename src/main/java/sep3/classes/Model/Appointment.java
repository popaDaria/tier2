package sep3.classes.Model;

import java.sql.Timestamp;
import java.util.Date;

public class Appointment {

    private int patientId;
    private int doctorId;
    private Date apptDate;
    private Date apptTime;

    public Appointment(int patientId, int doctorId, Date apptDate, Date apptTime) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.apptDate = apptDate;
        this.apptTime = apptTime;
    }

    public Appointment(int doctorId, Date apptDate, Date apptTime) {
        this.doctorId = doctorId;
        this.apptDate = apptDate;
        this.apptTime = apptTime;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public Date getApptDate() {
        return apptDate;
    }

    public void setApptDate(Date apptDate) {
        this.apptDate = apptDate;
    }

    public Date getApptTime() {
        return apptTime;
    }

    public void setApptTime(Date apptTime) {
        this.apptTime = apptTime;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "patientId=" + patientId +
                ", doctorId=" + doctorId +
                ", apptDate=" + apptDate +
                ", apptTime=" + apptTime +
                '}';
    }
}

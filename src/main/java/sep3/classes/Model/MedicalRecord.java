package sep3.classes.Model;

public class MedicalRecord {

    private int patientId;
    //maybe string buffer for now(can parse the byte[] to this)
    private StringBuffer content;

    public MedicalRecord(int patientId, StringBuffer content) {
        this.patientId = patientId;
        this.content = content;
    }

    public MedicalRecord(StringBuffer content) {
        this.content = content;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public StringBuffer getContent() {
        return content;
    }

    public void setContent(StringBuffer content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "MedicalRecord{" +
                "patientId=" + patientId +
                ", content=" + content +
                '}';
    }
}

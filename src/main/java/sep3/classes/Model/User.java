package sep3.classes.Model;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

    private int idNr;
    private String password;
    private String email;
    private String userType;
    private String firstname;
    private String lastname;
    private String gender;
    private Date birthday;
    private String telNo;
    private String address;
    private boolean validated;
    private byte[] image;

    public User() {
    }


    public User(int idNr, String password, String email, String userType, String firstname,
                String lastname, String gender, java.util.Date birthday, String telNo, String address,
                boolean validated, byte[] image) {
        this.idNr = idNr;
        this.password = password;
        this.email = email;
        this.userType = userType;
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.birthday = birthday;
        this.telNo = telNo;
        this.address = address;
        this.validated = validated;
        this.image = image;
    }

    public User(String password, String email, String userType, String firstname,
                String lastname, String gender, java.util.Date birthday, String telNo, String address,
                boolean validated, byte[] image)
    {

        this.password = password;
        this.email = email;
        this.userType = userType;
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.birthday = birthday;
        this.telNo = telNo;
        this.address = address;
        this.validated = validated;
        this.image = image;
    }

    public int getIdNr() {
        return idNr;
    }

    public void setIdNr(int idNr) {
        this.idNr = idNr;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public java.util.Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isValidated() {
        return validated;
    }

    public void setValidated(boolean validated) {
        this.validated = validated;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "User{" +
                "idNr=" + idNr +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", userType='" + userType + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", telNo='" + telNo + '\'' +
                ", address='" + address + '\'' +
                ", validated=" + validated +
                '}';
    }
}
package sep3.classes.Model;

import java.io.Serializable;

public class Hospital implements Serializable {

    private int id;
    private String type;
    private String name;
    private int postalCode;
    private String address;
    private int managerId;
    private int avgRating;
    private String validated;
    private String info;

    public Hospital(int id, String type, String name, int postalCode, String address, int managerId, int avgRating, String validated, String info) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.postalCode = postalCode;
        this.address = address;
        this.managerId = managerId;
        this.avgRating = avgRating;
        this.validated = validated;
        this.info = info;
    }

    public Hospital(String type, String name, int postalCode, String address, int managerId, int avgRating, String validated, String info) {
        this.type = type;
        this.name = name;
        this.postalCode = postalCode;
        this.address = address;
        this.managerId = managerId;
        this.avgRating = avgRating;
        this.validated = validated;
        this.info = info;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public int getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(int avgRating) {
        this.avgRating = avgRating;
    }

    public String getValidated() {
        return validated;
    }

    public void setValidated(String validated) {
        this.validated = validated;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", postalCode=" + postalCode +
                ", address='" + address + '\'' +
                ", managerId=" + managerId +
                ", avgRating=" + avgRating +
                ", validated='" + validated + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}

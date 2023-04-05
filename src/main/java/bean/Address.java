package bean;

import java.io.Serializable;

public class Address implements Serializable {
    private int id;
    private String detail;
    private String district;

    private int city;

    public Address() {
    }

    public Address(int id, String detail, String district, int city) {
        this.id = id;
        this.detail = detail;
        this.district = district;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getCity() {
        return city;
    }

    public void setCity(int city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", detail='" + detail + '\'' +
                ", district='" + district + '\'' +
                ", city=" + city +
                '}';
    }

    public String formatAddress() {
        return getDetail() + ", " + getDistrict() + ", " + getCity() + ".";
    }
}

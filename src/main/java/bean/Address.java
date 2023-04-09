package bean;

import java.io.Serializable;

public class Address implements Serializable {
    private String detail;
    private String district;

    private String city;

    public Address() {
    }

    public Address( String detail, String district, String city) {
        this.detail = detail;
        this.district = district;
        this.city = city;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                ", detail='" + detail + '\'' +
                ", district='" + district + '\'' +
                ", city=" + city +
                '}';
    }

    public String formatAddress() {
        return getDetail() + ", " + getDistrict() + ", " + getCity() + ".";
    }
}

package bean;

import java.io.Serializable;

public class AddressDetail implements Serializable {
    private int addressDetailId;

    private String detail;
    private String district;
    private String city;

    public AddressDetail() {
    }

    public AddressDetail(int addressDetailId, String detail, String district, String city) {
        this.addressDetailId = addressDetailId;
        this.detail = detail;
        this.district = district;
        this.city = city;
    }

    public int getAddressDetailId() {
        return addressDetailId;
    }

    public void setAddressDetailId(int addressDetailId) {
        this.addressDetailId = addressDetailId;
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
        return "AddressDetail{" +
                "addressDetailId=" + addressDetailId +
                ", detail='" + detail + '\'' +
                ", district='" + district + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}

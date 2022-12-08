package bean;

import java.io.Serializable;

public class Address implements Serializable {
    private int addressId;
    private int userId;
    private String name;
    private String phone;
    private String country;
    private String city;
    private String addressDetail;

    public Address() {
    }

    public Address(int addressId, int userId, String name, String phone, String country, String city, String addressDetail) {
        this.addressId = addressId;
        this.userId = userId;
        this.name = name;
        this.phone = phone;
        this.country = country;
        this.city = city;
        this.addressDetail = addressDetail;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }
}

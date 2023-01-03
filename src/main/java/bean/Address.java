package bean;

import java.io.Serializable;

public class Address implements Serializable {
    private int addressId;
    private int userId;
    private String name;
    private String phone;
    private String country;
    private String city;
    private int addressDetailId;
    private AddressDetail addressDetail;

    public Address() {
    }

    public Address(int addressId, int userId, String name, String phone, String country, String city, int addressDetailId, AddressDetail addressDetail) {
        this.addressId = addressId;
        this.userId = userId;
        this.name = name;
        this.phone = phone;
        this.country = country;
        this.city = city;
        this.addressDetailId = addressDetailId;
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

    public int getAddressDetailId() {
        return addressDetailId;
    }

    public void setAddressDetailId(int addressDetailId) {
        this.addressDetailId = addressDetailId;
    }

    public AddressDetail getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(AddressDetail addressDetail) {
        this.addressDetail = addressDetail;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", userId=" + userId +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", addressDetailId=" + addressDetailId +
                ", addressDetail=" + addressDetail +
                '}';
    }
}

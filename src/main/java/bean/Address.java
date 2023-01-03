package bean;

import java.io.Serializable;

public class Address implements Serializable {
    private int addressId;
    private int userId;
    private String name;
    private String phoneNumber;

    private int addressDetailId;
    private AddressDetail addressDetail;

    public Address() {
    }

    public Address(int addressId, int userId, String name, String phoneNumber, int addressDetailId, AddressDetail addressDetail) {
        this.addressId = addressId;
        this.userId = userId;
        this.name = name;
        this.phoneNumber = phoneNumber;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
                ", phone='" + phoneNumber + '\'' +
                ", addressDetailId=" + addressDetailId +
                ", addressDetail=" + addressDetail +
                '}';
    }
}

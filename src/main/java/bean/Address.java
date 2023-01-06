package bean;

import java.io.Serializable;

public class Address implements Serializable {
    private int addressId;
    private int userId;
    private String name;
    private String phoneNumber;

    private int addressDetailId;
    private AddressDetail addressDetail;
    private int stt;

    public Address() {
    }

    public Address(int addressId, int userId, String name, String phoneNumber, int addressDetailId, AddressDetail addressDetail, int stt) {
        this.addressId = addressId;
        this.userId = userId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.addressDetailId = addressDetailId;
        this.addressDetail = addressDetail;
        this.stt = stt;
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

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", userId=" + userId +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", addressDetailId=" + addressDetailId +
                ", addressDetail=" + addressDetail +
                ", stt=" + stt +
                '}';
    }

    public String formatAddress() {
        return getAddressDetail().getDetail() + ", " + getAddressDetail().getDistrict() + ", " + getAddressDetail().getCity() + ".";
    }
}

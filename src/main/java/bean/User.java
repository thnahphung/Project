package bean;

import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    private int userId;
    private String fullName;
    private String email;
    private String phoneNumber;
    private String pass;
    private int varieties;
    private String avatar;
    private int stt;

    public User() {

    }

    public User(int userId, String fullName, String email, String phoneNumber, String pass, int varieties, String avatar, int stt) {
        this.userId = userId;
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.pass = pass;
        this.varieties = varieties;
        this.avatar = avatar;
        this.stt = stt;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public User(int userId, String fullName, String avatar) {
        this.userId = userId;
        this.fullName = fullName;
        this.avatar = avatar;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getVarieties() {
        return varieties;
    }

    public void setVarieties(int varieties) {
        this.varieties = varieties;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getVarietiesUser() {
        if (this.varieties == 1) {
            return "Cộng tác viên";
        }
        if (this.varieties == 2) {
            return "Quản lý";
        }
        return "Khách hàng";
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userId +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", pass='" + pass + '\'' +
                ", varieties='" + varieties + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}

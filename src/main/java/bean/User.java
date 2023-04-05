package bean;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {

    private int id;
    private String name;
    private String email;
    private String phone;
    private String password;
    private String avatar;
    private List<Information> listInformation;
    private List<LineItem> listCartItem;
    private List<Order> listOrder;
    private String idThirdParty;
    private int varieties;
    private int status;


    public User() {

    }

    public User(int id, String name, String email, String phone, String password, String avatar, List<Information> listInformation, List<LineItem> listCartItem, List<Order> listOrder, String idThirdParty, int varieties, int status) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.avatar = avatar;
        this.listInformation = listInformation;
        this.listCartItem = listCartItem;
        this.listOrder = listOrder;
        this.idThirdParty = idThirdParty;
        this.varieties = varieties;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public List<Information> getListInformation() {
        return listInformation;
    }

    public void setListInformation(List<Information> listInformation) {
        this.listInformation = listInformation;
    }

    public List<LineItem> getListCartItem() {
        return listCartItem;
    }

    public void setListCartItem(List<LineItem> listCartItem) {
        this.listCartItem = listCartItem;
    }

    public List<Order> getListOrder() {
        return listOrder;
    }

    public void setListOrder(List<Order> listOrder) {
        this.listOrder = listOrder;
    }

    public String getIdThirdParty() {
        return idThirdParty;
    }

    public void setIdThirdParty(String idThirdParty) {
        this.idThirdParty = idThirdParty;
    }

    public int getVarieties() {
        return varieties;
    }

    public void setVarieties(int varieties) {
        this.varieties = varieties;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", avatar='" + avatar + '\'' +
                ", listInformation=" + listInformation +
                ", listCartItem=" + listCartItem +
                ", listOrder=" + listOrder +
                ", idThirdParty='" + idThirdParty + '\'' +
                ", varieties=" + varieties +
                ", status=" + status +
                '}';
    }
}

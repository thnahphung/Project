package services;

import bean.User;
import db.JDBIConnector;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.stream.Collectors;

public class UserService {

    private static UserService instance;

    private UserService() {

    }

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    public List<User> getListUser() {
        return JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT user_id, full_name, email, phone_number, pass, varieties, avatar  FROM user").mapToBean(User.class).stream().collect(Collectors.toList());
        });
    }

    public User getUserById(int id) {
        List<User> users = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT user_id, full_name, email, phone_number, pass, varieties, avatar  FROM user where user_id " + "=" + id).mapToBean(User.class).stream().collect(Collectors.toList());
        });
        if (users.size() != 1) return null;
        return users.get(0);
    }

    public User checkLogin(String userName, String password) {
        List<User> users = JDBIConnector.get().withHandle(handle ->
                handle.createQuery("select user_id, full_name, email, phone_number, pass, varieties, avatar from user where email=? or phone_number=?")
                        .bind(0, userName).bind(1, userName)
                        .mapToBean(User.class)
                        .stream()
                        .collect(Collectors.toList())
        );
        if (users.size() != 1) return null;
        User user = users.get(0);
        if (!user.getPass().equals((password))
                || !(user.getEmail().equals(userName) || user.getPhoneNumber().equals(userName))) {
            return null;
        }
        return user;
    }

    public String hashPassword(String password) {
        try {
            MessageDigest sha256 = null;
            sha256 = MessageDigest.getInstance("SHA-256");
            byte[] hash = sha256.digest(password.getBytes());
            BigInteger number = new BigInteger(1, hash);
            return number.toString(16);
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    public boolean checkExistEmail(String email) {
        List<String> emails = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT user_id, full_name, email, phone_number, pass, varieties, avatar \n" +
                            "from user\n" +
                            " where email=?").bind(0, email)
                    .mapTo(String.class).stream().collect(Collectors.toList());
        });
        if (emails.size() != 0) {

            return true;
        }
        return false;

    }

    public boolean checkExistPhone(String phone) {
        List<String> phones = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT user_id, full_name, email, phone_number, pass, varieties, avatar \n" +
                            "from user\n" +
                            " where phone_number=?").bind(0, phone)
                    .mapTo(String.class).stream().collect(Collectors.toList());
        });
        if (phones.size() != 0) {

            return true;
        }
        return false;

    }

    public boolean checkSamePass(String pass, String passAgain) {
        return pass.equals(passAgain);
    }


    public void addUser(User user) {
        JDBIConnector.get().withHandle(handle -> {
            return handle.createUpdate("INSERT INTO user values (:id, :name, :email, :phone, :pass, :varieties, :ava)")
                    .bind("id", user.getUserId())
                    .bind("name", user.getFullName())
                    .bind("email", user.getEmail())
                    .bind("phone", user.getPhoneNumber())
                    .bind("pass", user.getPass())
                    .bind("varieties", user.getVarieties())
                    .bind("ava", user.getAvatar())
                    .execute();
        });
    }

    public void editInfor(int id, String fName, String phone, String mail) {
        JDBIConnector.get().withHandle(handle -> {
            return handle.createUpdate("UPDATE user SET full_name=?, email=?, phone_number=? WHERE user_id=?;")
                    .bind(0, fName)
                    .bind(1, mail)
                    .bind(2, phone)
                    .bind(3, id)
                    .execute();
        });
    }

    public void changePass(String phoneEmail, String newPass){
         JDBIConnector.get().withHandle(handle -> {
            return handle.createUpdate("UPDATE `user` SET pass=?  WHERE phone_number=?;")
                    .bind(0, newPass)
                    .bind(1, phoneEmail)
                    .execute();
        });
    }

    public boolean checkPhoneEmail(String phoneEmail) {
        return JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT COUNT(user_id)  FROM `user` WHERE phone_number = ? OR email = ?;")
                    .bind(0, phoneEmail)
                    .bind(1, phoneEmail)
                    .mapTo(Integer.class)
                    .one() == 1;

        });
    }

    public static void main(String[] args) {

        System.out.println(UserService.getInstance().checkPhoneEmail("090000005"));
    }


}

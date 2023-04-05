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
            return handle.createQuery("SELECT user_id, full_name, email, phone_number, pass, varieties, avatar,stt  FROM user").mapToBean(User.class).stream().collect(Collectors.toList());
        });
    }

    public User getUserById(int id) {
        List<User> users = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT user_id, full_name, email, phone_number, pass, varieties, avatar,stt  FROM user where user_id " + "=" + id).mapToBean(User.class).stream().collect(Collectors.toList());
        });
        if (users.size() != 1) return null;
        return users.get(0);
    }

    public User getUserById3rd(String id) {
        List<User> users = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT user_id, full_name, email, phone_number, pass, varieties, avatar,stt  FROM user where id3rd " + "=" + id).mapToBean(User.class).stream().collect(Collectors.toList());
        });
        if (users.size() != 1) return null;
        return users.get(0);
    }

    public User checkLogin(String userName, String password) {
        List<User> users = JDBIConnector.get().withHandle(handle ->
                handle.createQuery("select user_id, full_name, email, phone_number, pass, varieties, avatar, stt from user where email=? or phone_number=?")
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
    public boolean checkExistId3rd(String id3rd) {
        List<String> id3rds = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT user_id, full_name, email, phone_number, pass, varieties, avatar,stt, id3rd \n" +
                            "from user\n" +
                            " where id3rd=?").bind(0, id3rd)
                    .mapTo(String.class).stream().collect(Collectors.toList());
        });
        if (id3rds.size() != 0) {

            return true;
        }
        return false;

    }

    public boolean checkSamePass(String pass, String passAgain) {
        return pass.equals(passAgain);
    }


    public void addUser(User user) {
        JDBIConnector.get().withHandle(handle -> {
            return handle.createUpdate("INSERT INTO user values (:id, :name, :email, :phone, :pass, :varieties, :ava,0, 0)")
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

    public void changePass(String phoneEmail, String newPass) {
        JDBIConnector.get().withHandle(handle -> {
            return handle.createUpdate("UPDATE `user` SET pass=?  WHERE email=?;")
                    .bind(0, UserService.getInstance().hashPassword(newPass))
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

    public int nextId() {
        return 1 + JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT MAX(`user_id`) as numberOfUser FROM `user`").mapTo(Integer.class).one();
        });
    }

    public void editVarietiesUser(int id, int varieties) {
        JDBIConnector.get().withHandle(handle -> {
            return handle.createUpdate("UPDATE `user` SET varieties=? where user_id= " + id + " ;")
                    .bind(0, varieties)
                    .execute();
        });
    }

    public void editSttUser(int id, int stt) {
        JDBIConnector.get().withHandle(handle -> {
            return handle.createUpdate("UPDATE `user` SET stt=? where user_id= " + id + " ;")
                    .bind(0, stt)
                    .execute();
        });
    }


    public void addUserLoginBy3rdParty(User user) {
        JDBIConnector.get().withHandle(handle -> {
            return handle.createUpdate("INSERT INTO user values (:id, :name, :email, :phone,:pass, :varieties, :ava,:stt, :id3rd)")
                    .bind("id", user.getUserId())
                    .bind("name", user.getFullName())
                    .bind("email", user.getEmail())
                    .bind("phone", user.getPhoneNumber())
                    .bind("pass", user.getPass())
                    .bind("varieties", 0)
                    .bind("ava", user.getAvatar())
                    .bind("stt", 0)
                    .bind("id3rd", user.getId3rd())
                    .execute();
        });}
    public void editAvatar(int id, String url) {
        JDBIConnector.get().withHandle(handle -> {
            return handle.createUpdate("UPDATE `user` SET avatar=? where user_id= ? ;")
                    .bind(0, url)
                    .bind(1, id)
                    .execute();
        });
    }



    public void changeName(String name, String id3rd) {
        JDBIConnector.get().withHandle(handle -> {
            return handle.createUpdate("UPDATE user set full_name = :name where id3rd = :id3rd")
                    .bind("name", name)
                    .bind("id3rd", id3rd)
                    .execute();
        });
    }

    public static void main(String[] args) {
        User user = new User();
        user.setUserId(UserService.getInstance().nextId());
        user.setFullName(null);
        user.setPhoneNumber(null);
        user.setEmail(null);
        user.setId3rd("234");
        System.out.println(UserService.getInstance().checkExistId3rd("234"));
    }
}

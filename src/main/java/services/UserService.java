package services;

import bean.Product;
import bean.User;
import db.JDBIConnector;

import java.util.List;
import java.util.stream.Collectors;

public class UserService {

    private static UserService instance;

    private UserService() {

    }

    private static UserService getInstance() {
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

    public static void main(String[] args) {
        System.out.println(UserService.getInstance().getListUser());
    }


}

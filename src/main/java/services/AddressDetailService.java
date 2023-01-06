package services;

import bean.AddressDetail;
import bean.OrderDetail;
import db.JDBIConnector;

import java.util.jar.JarEntry;

public class AddressDetailService {
    private static AddressDetailService instance;

    private AddressDetailService() {

    }

    public static AddressDetailService getInstance() {
        if (instance == null) {
            instance = new AddressDetailService();
        }
        return instance;
    }

    public AddressDetail getAddressDetailByAddressDetailId(int addressDetailId) {
        return JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery(
                    "select address_detail_id,detail, district, city\n" +
                    "from address_detail\n" +
                    "WHERE address_detail_id = ?;")
                    .bind(0, addressDetailId)
                    .mapToBean(AddressDetail.class)
                    .one();
        });
    }
    public void add(AddressDetail addressDetail) {
        JDBIConnector.get().withHandle(handle -> {
            return handle.createUpdate("INSERT INTO `address_detail` VALUES (:address_detail_id,:detail,:district,:city)")
                    .bind("address_detail_id", addressDetail.getAddressDetailId())
                    .bind("detail", addressDetail.getDetail())
                    .bind("district", addressDetail.getDistrict())
                    .bind("city", addressDetail.getCity())
                    .execute();
        });
    }


}

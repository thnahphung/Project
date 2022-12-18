package services;

import bean.AddressDetail;
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
}

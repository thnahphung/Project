package services;

import bean.Address;
import bean.AddressDetail;
import db.JDBIConnector;

import java.util.List;
import java.util.stream.Collectors;

public class AddressService {
    private static AddressService instance;

    private AddressService() {

    }

    public static AddressService getInstance() {
        if (instance == null) {
            instance = new AddressService();
        }
        return instance;
    }

    public Address getAddressByAddressId(int addressId) {
        return JDBIConnector.get().withHandle(handle -> {
            Address address = handle.createQuery("select a.address_id,a.user_id, a.`name`, a.phone_number, a.address_detail_id\n" +
                            "from address a " +
                            "WHERE a.address_id = ?;")
                    .bind(0, addressId)
                    .mapToBean(Address.class)
                    .one();
            address.setAddressDetail(AddressDetailService.getInstance().getAddressDetailByAddressDetailId(address.getAddressDetailId()));
            return address;
        });
    }

    public List<Address> getListAddressByUserId(int id) {
        return JDBIConnector.get().withHandle(handle -> {
            List<Address> result = handle.createQuery("select a.address_id,a.user_id, a.`name`, a.phone_number, a.address_detail_id\n" +
                            "from address a\n" +
                            " WHERE a.user_id = ?;")
                    .bind(0, id)
                    .mapToBean(Address.class)
                    .stream().collect(Collectors.toList());
            for (Address address : result) {
                address.setAddressDetail(AddressDetailService.getInstance().getAddressDetailByAddressDetailId(address.getAddressDetailId()));
            }
            return result;
        });
    }


}

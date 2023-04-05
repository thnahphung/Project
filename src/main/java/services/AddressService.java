package services;

import bean.Address;
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
            Address address = handle.createQuery("select a.address_id, a.address_detail_id, a.stt\n" +
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
            List<Address> result = handle.createQuery("select a.address_id,a.user_id, a.`name`, a.phone_number, a.address_detail_id, a.stt\n" +
                            "from address a\n" +
                            " WHERE a.user_id = ? and a.stt not like 1;")
                    .bind(0, id)
                    .mapToBean(Address.class)
                    .stream().collect(Collectors.toList());
            for (Address address : result) {
                address.setAddressDetail(AddressDetailService.getInstance().getAddressDetailByAddressDetailId(address.getAddressDetailId()));
            }
            return result;
        });
    }

    public void editAddress(int id, String name, String phone, String city, String district, String detail) {
        JDBIConnector.get().withHandle(handle -> {
            return handle.createUpdate("UPDATE address a join address_detail ad on a.address_detail_id =ad.address_detail_id SET `name`=?, phone_number=?, city=?, district=?, detail=? WHERE address_id=?;")
                    .bind(0, name)
                    .bind(1, phone)
                    .bind(2, city)
                    .bind(3, district)
                    .bind(4, detail)
                    .bind(5, id)
                    .execute();
        });
    }

    public void deleteAddress(int id) {
        JDBIConnector.get().withHandle(handle -> {
            return handle.createUpdate("UPDATE address SET stt=1 WHERE address_id=?;")
                    .bind(0, id)
                    .execute();
        });
    }

    public List<Address> getListAddressExistOfUser(int userId) {
        return JDBIConnector.get().withHandle(handle -> {
            List<Address> result = handle.createQuery("select a.address_id,a.user_id, a.`name`, a.phone_number, a.address_detail_id, a.stt\n" +
                            "from address a\n" +
                            " WHERE a.user_id = ? and a.stt = ?;")
                    .bind(0, userId)
                    .bind(1, 0)
                    .mapToBean(Address.class)
                    .stream().collect(Collectors.toList());
            for (Address address : result) {
                address.setAddressDetail(AddressDetailService.getInstance().getAddressDetailByAddressDetailId(address.getAddressDetailId()));
            }
            return result;
        });
    }

    public int nextId() {
        return 1 + JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT MAX(`address_id`) as numberOfOrder FROM `address`").mapTo(Integer.class).one();
        });
    }

    public void addNewAddress(Address address) {
        AddressDetailService.getInstance().add(address.getAddressDetail());
        JDBIConnector.get().withHandle(handle -> {
            int num = handle.createUpdate("INSERT INTO address() VALUES (:address_id,:user_id,:name,:phone_number,:address_detail_id,:stt)")
                    .bind("address_id", address.getAddressId())
                    .bind("user_id", address.getUserId())
                    .bind("name", address.getName())
                    .bind("phone_number", address.getPhoneNumber())
                    .bind("address_detail_id", address.getAddressDetail().getAddressDetailId())
                    .bind("stt", address.getStt())
                    .execute();

            return num;
        });
    }

    public void deleteAllAddress() {
        JDBIConnector.get().withHandle(handle -> {
            return handle.createUpdate("UPDATE address SET `stt`=1;")
                    .execute();
        });
    }

    public static void main(String[] args) {
        AddressDetail addressDetail = new AddressDetail(AddressService.getInstance().nextId(), "112 thon 1", "quan 1", " HCM");

        Address address = new Address(addressDetail.getAddressDetailId(), 3, "hung", "0819541", addressDetail.getAddressDetailId(), addressDetail, 0);
        AddressService.getInstance().addNewAddress(address);
        AddressService.getInstance().deleteAllAddress();
    }
}
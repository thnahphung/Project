package services;

import bean.Information;
import bean.ThirdParty;
import db.JDBIConnector;

import java.util.List;
import java.util.stream.Collectors;

public class ThirdPartyService {
    private static ThirdPartyService instance;

    private ThirdPartyService() {

    }

    public static ThirdPartyService getInstance() {
        if (instance == null) {
            instance = new ThirdPartyService();
        }
        return instance;
    }

    public int maxId() {
        return JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT MAX(`id`) as numberOfInformation FROM `information`").mapTo(Integer.class).one();
        });
    }

    public ThirdParty getIdThirdPartyByUserId(int id) {
        return JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("select tp.id, tp.name, tp.value from third_party tp join `user` u on tp.id = u.id_third_party where u.id = ?;")
                    .bind(0, id).mapToBean(ThirdParty.class).one();
        });
    }
}

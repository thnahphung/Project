package services;

import db.JDBIConnector;

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
}

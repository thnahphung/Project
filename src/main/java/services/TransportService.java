package services;

import bean.Transport;
import db.JDBIConnector;

public class TransportService {

    private static TransportService instance;

    private TransportService() {

    }

    public static TransportService getInstance() {
        if (instance == null) {
            instance = new TransportService();
        }
        return instance;
    }

    public Transport getTransportById(int idTransportService) {
        return JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery(
                            "select id,name,transport_fee\n" +
                                    "from transport\n" +
                                    "WHERE id = ?;")
                    .bind(0, idTransportService)
                    .mapToBean(Transport.class)
                    .one();
        });
    }
    public Transport getTransportByOrderId(int id){
        return JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("select t.id, t.name, t.fee, t.time from transport t join `order` o on t.id = o.transport_id where o.id =?")
                    .bind(0,id)
                    .mapToBean(Transport.class)
                    .one();
        });
    }
}

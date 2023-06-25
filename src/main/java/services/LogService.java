package services;

import bean.Log;
import bean.User;
import db.JDBIConnector;

import java.util.List;
import java.util.stream.Collectors;

public class LogService {
    private static LogService instance;

    private LogService() {

    }

    public static LogService getInstance() {
        if (instance == null) {
            instance = new LogService();
        }
        return instance;
    }

    public Log getLogById(int id) {
        return null;
    }

    public void insert(Log log) {
        if (log.getUser() == null) {
            JDBIConnector.get().withHandle(
                    handle ->
                            handle.createUpdate("insert into log(ip, severity_level, event, description, create_date) \n" +
                                            "values(:ip, :severity_level, :event, :description, :create_date) ")
                                    .bind("ip", log.getIp())
                                    .bind("severity_level", log.getSeverityLevel())
                                    .bind("event", log.getEvent())
                                    .bind("description", log.getDescription())
                                    .bind("create_date", log.getCreateDate())
                                    .execute());
        } else {
            JDBIConnector.get().withHandle(
                    handle ->
                            handle.createUpdate("insert into log(ip, user_id, severity_level, event, description, create_date) \n" +
                                            "values(:ip, :user_id, :severity_level, :event, :description, :create_date) ")
                                    .bind("ip", log.getIp())
                                    .bind("user_id", log.getUser().getId())
                                    .bind("severity_level", log.getSeverityLevel())
                                    .bind("event", log.getEvent())
                                    .bind("description", log.getDescription())
                                    .bind("create_date", log.getCreateDate())
                                    .execute());
        }

    }

    public List<Log> getAllLog() {
        return JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("select id, ip,user_id, severity_level, event, description, create_date from log where status = 0")
                    .mapToBean(Log.class).stream().collect(Collectors.toList());
        });
    }
    public void deleteLog(int id){
        JDBIConnector.get().withHandle(handle -> {
            return handle.createUpdate("UPDATE log SET status =1 where id=:id")
                    .bind("id", id)
                    .execute();
        });
    }
}

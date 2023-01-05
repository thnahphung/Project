package services;

import bean.Banner;
import db.JDBIConnector;

import java.util.List;
import java.util.stream.Collectors;

public class BannerService {
    private static BannerService instance;
    public BannerService(){

    }

    public static BannerService getInstance() {
        if(instance==null)
            instance =new BannerService();
        return instance;
    }
    public List<Banner> getListBanner(){
        return JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT id, name, image_src from banner").mapToBean(Banner.class).stream().collect(Collectors.toList());
        });
    }
}

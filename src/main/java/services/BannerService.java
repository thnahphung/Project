package services;

import bean.Banner;
import db.JDBIConnector;

import java.util.List;
import java.util.stream.Collectors;

public class BannerService {
    private static BannerService instance;

    public BannerService() {

    }

    public static BannerService getInstance() {
        if (instance == null)
            instance = new BannerService();
        return instance;
    }

    public Banner getBannerbyId(int id) {
        return JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT `id`, name,`image_src` from banner where `id`=" + id + ";").mapToBean(Banner.class).one();
        });
    }


    public List<Banner> getListBanner() {
        return JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT  `id`, name, `image_src` from banner;").mapToBean(Banner.class).stream().collect(Collectors.toList());
        });
    }
    public List<Banner> getListBannerInPage(String page){
        return JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT  `id`, name, `image_src` from banner where name like '"+page+"';").mapToBean(Banner.class).stream().collect(Collectors.toList());
        });
    }

    public int nextId() {
        return 1 + JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT MAX(`id`) as numberBanner FROM `banner`").mapTo(Integer.class).one();
        });
    }

    public void addBanner(String name, String src) {
        JDBIConnector.get().withHandle(handle -> {
            return handle.createUpdate("INSERT INTO banner values (:id,:name,:image_src)")
                    .bind("id", nextId())
                    .bind("name", name)
                    .bind("image_src", src).execute();

        });
    }

    public void editBanner(int id, String name, String src) {
        JDBIConnector.get().withHandle(handle -> {
            return handle.createUpdate("UPDATE banner SET name=?, image_src=? where `id`=" + id + ";")
                    .bind(0, name)
                    .bind(1, src).execute();
        });
    }


    public void deleteBannerById(int id) {
        JDBIConnector.get().withHandle(handle -> {
            return handle.createUpdate("DELETE from banner where id=" + id + ";").execute();
        });
    }
}

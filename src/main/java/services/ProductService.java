package services;

import bean.Category;
import bean.Comment;
import bean.PaCategory;
import bean.Product;
import db.JDBIConnector;

import java.util.*;
import java.util.stream.Collectors;

public class ProductService {
    private static ProductService instance;
    //    kind
    public static final int ALL = 0;
    public static final int WOOD = 1;
    public static final int RECAMIC = 2;
    public static final int PAINT = 3;
    public static final int SALE = 4;
    public static final int NEW = 5;

    //    group;
    public static final int TRANGTRI = 1;
    public static final int MOHINH = 2;
    public static final int GIADUNG = 3;
    public static final int VANPHONG = 4;
    public static final int TRANGSUC = 5;
    public static final int SONDAU = 6;
    public static final int SONMAI = 7;
    public static final int VAI = 8;


    private ProductService() {

    }

    public static ProductService getInstance() {
        if (instance == null) {
            instance = new ProductService();
        }
        return instance;
    }

    public List<Product> getListProduct() {
        return JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT product_id, category_id, product_name, price, price_real, image_src, rate  FROM product").mapToBean(Product.class).stream().collect(Collectors.toList());
        });
    }

    public Product getProductById(int id) {
        List<Product> products = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("select product_id, category_id, product_name, price, price_real, image_src, rate from product where product_id " + "=" + id).mapToBean(Product.class).stream().collect(Collectors.toList());
        });
        if (products.size() != 1) return null;
        return products.get(0);
    }

    //    Danh sach san pham theo loai
    public List<Product> getListProductByKind(int kind) {
        if (kind == ALL) {
            return JDBIConnector.get().withHandle(handle -> {
                List<Product> productList = handle.createQuery("SELECT product_id, category_id, product_name, price, price_real,    image_src,      rate FROM product").mapToBean(Product.class).stream().collect(Collectors.toList());
                for (Product product : productList) {
                    product.setCategory(handle.createQuery("SELECT category_id, pa_category_id, name FROM category where category_id=" + product.getCategoryId()).mapToBean(Category.class).stream().collect(Collectors.toList()).get(0));
                }
                return productList;
            });
        } else if (kind == SALE) {
            return JDBIConnector.get().withHandle(handle -> {
                List<Product> productList = handle.createQuery("SELECT pro.product_id, pro.category_id, pro.product_name, pro.price, pro.price_real, pro.image_src, pro.rate FROM product pro join category ca on pro.category_id = ca.category_id join pa_category pa on pa.pa_category_id = ca.pa_category_id WHERE pro.price_real is not null ").mapToBean(Product.class).stream().collect(Collectors.toList());
                for (Product product : productList) {
                    product.setCategory(handle.createQuery("SELECT category_id, pa_category_id, name FROM category where category_id=" + product.getCategoryId()).mapToBean(Category.class).stream().collect(Collectors.toList()).get(0));
                }
                return productList;

            });
        } else if (kind == NEW) {
            return JDBIConnector.get().withHandle(handle -> {
                List<Product> productList = handle.createQuery("SELECT pro.product_id, pro.category_id, pro.product_name, pro.price, pro.price_real, pro.image_src, pro.rate FROM product pro join category ca on pro.category_id = ca.category_id join pa_category pa on pa.pa_category_id = ca.pa_category_id JOIN product_detail prod on pro.product_id= prod.product_detail_id WHERE prod.stt=0 ").mapToBean(Product.class).stream().collect(Collectors.toList());
                for (Product product : productList) {
                    product.setCategory(handle.createQuery("SELECT category_id, pa_category_id, name FROM category where category_id=" + product.getCategoryId()).mapToBean(Category.class).stream().collect(Collectors.toList()).get(0));
                }
                return productList;

            });
        }
        return JDBIConnector.get().withHandle(handle -> {
            List<Product> productList = handle.createQuery("SELECT pro.product_id, pro.category_id, pro.product_name, pro.price, pro.price_real, pro.image_src, pro.rate FROM product pro join category ca on pro.category_id = ca.category_id join pa_category pa on pa.pa_category_id = ca.pa_category_id WHERE pa.pa_category_id= " + kind).mapToBean(Product.class).stream().collect(Collectors.toList());
            for (Product product : productList) {
                product.setCategory(handle.createQuery("SELECT category_id, pa_category_id, name FROM category where category_id=" + product.getCategoryId()).mapToBean(Category.class).stream().collect(Collectors.toList()).get(0));
            }
            return productList;

        });


    }

    //    Danh sach san pham theo nhom
    public List<Product> getListProductInGroup(int kind, int group) {

        List<Product> list = getListProductByKind(kind);
        List<Product> listResult = new ArrayList<Product>();

        for (Product product : list) {
            if (group == 0) {
                return list;
            } else if (product.getCategory().getCategoryId() == group) {
                listResult.add(product);
            }

        }

        return listResult;

    }

    //  danh sach san pham o 1 trang
    public List<Product> getListProductInPage(int kind, String sort, int group, int page) {
        List<Product> list = getSortListProduct(kind, group, sort);
        List<Product> listResult = new ArrayList<Product>();
        int start = (page - 1) * 15 < 0 ? 0 : (page - 1) * 15;
        int end = page <= list.size() / 15 ? page * 15 : list.size() - ((page - 1) * 15) + start;
        for (int i = start; i < end; i++) {
            listResult.add(list.get(i));
        }

        return listResult;
    }

    public List<Product> getListFavouriteProduct() {
        return JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT product_id, category_id, product_name, price, price_real, create_date, update_date, stt, quantity_sold, image_src, rate\n" +
                    "FROM product \n" +
                    "ORDER BY rate DESC\n" +
                    "LIMIT 3;").mapToBean(Product.class).stream().collect(Collectors.toList());
        });

    }

    public List<Product> getTopWoodProducts() {
        return JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT product_id, category_id, product_name, price, price_real, create_date, update_date, stt, quantity_sold, image_src, rate\n" +
                    "FROM product\n" +
                    "WHERE category_id = 1\n" +
                    "ORDER BY quantity_sold DESC\n" +
                    "LIMIT 16;").mapToBean(Product.class).stream().collect(Collectors.toList());
        });
    }

    public List<Product> getTopPotteryProducts() {
        return JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT product_id, category_id, product_name, price, price_real, create_date, update_date, stt, quantity_sold, image_src, rate\n" +
                    "FROM product\n" +
                    "WHERE category_id = 2\n" +
                    "ORDER BY quantity_sold DESC\n" +
                    "LIMIT 16;").mapToBean(Product.class).stream().collect(Collectors.toList());
        });
    }

    public List<Product> getTopPaintingProducts() {
        return JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT product_id, category_id, product_name, price, price_real, create_date, update_date, stt, quantity_sold, image_src, rate\n" +
                    "FROM product\n" +
                    "WHERE category_id = 3\n" +
                    "ORDER BY quantity_sold DESC\n" +
                    "LIMIT 16;").mapToBean(Product.class).stream().collect(Collectors.toList());
        });
    }

    public List<String> getImageOfProductById(int id) {
        return JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("select image_src from image where product_id " + "=" + id).mapTo(String.class).stream().collect(Collectors.toList());
        });
    }

    public int getcountProduct(int kind, int group) {

        return getListProductInGroup(kind, group).size();
    }

    public List<Product> getSortListProduct(int kind, int group, String sort) {
        List<Product> list = getListProductInGroup(kind, group);
        switch (sort) {
            case "a-z":
                Collections.sort(list, new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        return o1.getProductName().compareTo(o2.getProductName());
                    }
                });
                break;
            case "price":
                Collections.sort(list, new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        return o1.getPrice() - o2.getPrice();
                    }
                });
                break;
            case "ratting":
                Collections.sort(list, new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        return o2.getRate() - o1.getRate();
                    }
                });
                break;
        }

        return list;
    }

    //    public List<Comment> getCommentOfProductById(int id) {
//
//    }
    public List<Comment> getCommentOfProductById(int id) {

        return JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT cmt.comment_id, cmt.rate,cmt.document,u.user_id,u.full_name,u.avatar from `comment` cmt join `user` u on cmt.user_id= u.user_id WHERE cmt.product_id = " + id).mapToBean(Comment.class).stream().collect(Collectors.toList());
        });
    }


//    public Map<Integer,List<String>> getCommentOfProductById(int id){
//       JDBIConnector.get().
//    }


    public List<Product> getNewProducts() {
        return JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("select product_id, category_id, product_name, price, price_real, create_date, update_date, stt, quantity_sold, image_src, rate\n" +
                    "FROM product\n " +
                    "ORDER BY create_date DESC limit 6;").mapToBean(Product.class).stream().collect(Collectors.toList());
        });
    }

    public static void main(String[] args) {
//        System.out.println(ProductService.getInstance().getProductById(1));
//        System.out.println(ProductService.getInstance().getListProduct());
//        System.out.println(ProductService.getInstance().getListTopProduct());

//        System.out.println(ProductService.getInstance().getProductById(1));

//        System.out.println(ProductService.getInstance().getListFavouriteProduct());
//        System.out.println(ProductService.getInstance().getImageOfProductById(1));

//        System.out.println(ProductService.getInstance().getNewProducts());
//        System.out.println(ProductService.getInstance().getCommentOfProductById(1));

//        System.out.println(ProductService.getInstance().getTopWoodProducts());
//        System.out.println(ProductService.getInstance().getListProductByKind(ALL));
        System.out.println(ProductService.getInstance().getListProductInGroup(ALL, TRANGTRI));
    }


}

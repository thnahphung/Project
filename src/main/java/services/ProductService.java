package services;

import bean.*;
import db.JDBIConnector;

import java.util.*;
import java.util.stream.Collectors;

public class ProductService {
    private static ProductService instance;
    //    kind
    public static final int ALL = 0;
    public static final int WOOD = 1;
    public static final int CERAMIC = 2;
    public static final int PAINT = 3;
    public static final int SALE = 4;
    public static final int NEW = 5;

    //    group;
    public static final int MOHINH = 1;
    public static final int GIADUNG = 2;
    public static final int VANPHONG = 3;
    public static final int TRANGSUC = 4;
    public static final int TRANGTRI = 5;
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
            List<Product> list = handle.createQuery("SELECT product_id, category_id, product_name, price, price_real, image_src, rate  FROM product").mapToBean(Product.class).stream().collect(Collectors.toList());
            for (Product product : list) {
                ProductDetail productDetail = handle.createQuery("SELECT product_detail_id,decription,detail,inventory,create_date,update_date,stt,quantity_sold,user_id FROM product_detail where product_detail_id = ?").bind(0, product.getProductId()).mapToBean(ProductDetail.class).stream().collect(Collectors.toList()).get(0);
                product.setProductDetail(productDetail);
                Category category = handle.createQuery("SELECT category_id,pa_category_id,name FROM category WHERE category_id=?").bind(0, product.getCategoryId()).mapToBean(Category.class).collect(Collectors.toList()).get(0);
                product.setCategory(category);
                PaCategory paCategory = handle.createQuery("SELECT pa_category_id,name FROM category WHERE category_id=?").bind(0, product.getCategory().getPaCategoryId()).mapToBean(PaCategory.class).collect(Collectors.toList()).get(0);
                product.getCategory().setPaCategory(paCategory);
            }
            return list;
        });
    }

    public Product getProductById(int id) {
        List<Product> products = JDBIConnector.get().withHandle(handle -> {
            List<Product> list = handle.createQuery("select product_id, category_id, product_name, price, price_real, image_src, rate from product where product_id " + "=" + id).mapToBean(Product.class).stream().collect(Collectors.toList());
            for (Product product : list) {
                ProductDetail productDetail = handle.createQuery("SELECT product_detail_id,decription,detail,inventory,create_date,update_date,stt,quantity_sold,user_id FROM product_detail where product_detail_id = ?").bind(0, product.getProductId()).mapToBean(ProductDetail.class).stream().collect(Collectors.toList()).get(0);
                product.setProductDetail(productDetail);
                Category category = handle.createQuery("SELECT category_id,pa_category_id,name FROM category WHERE category_id=?").bind(0, product.getCategoryId()).mapToBean(Category.class).collect(Collectors.toList()).get(0);
                product.setCategory(category);
                PaCategory paCategory = handle.createQuery("SELECT pa_category_id,name FROM category WHERE category_id=?").bind(0, product.getCategory().getPaCategoryId()).mapToBean(PaCategory.class).collect(Collectors.toList()).get(0);
                product.getCategory().setPaCategory(paCategory);
            }
            return list;
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

    public List<Product> getListProductInGroupName(int kind, String group) {

        List<Product> list = getListProductByKind(kind);
        List<Product> listResult = new ArrayList<Product>();

        for (Product product : list) {
            if ("".equals(group)) {
                return list;
            } else if (product.getCategory().getName().equals(group)) {
                listResult.add(product);
            }

        }

        return listResult;

    }

    //  danh sach san pham o 1 trang
    public List<Product> getListProductInPage(int kind, int group, int page, String sort) {
        List<Product> list = getSortListProduct(kind, sort, group);
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

            return handle.createQuery("SELECT product_id, category_id, product_name, price, price_real, rate, image_src, product_detail_id\n" +
                    "FROM product \n" +
                    "ORDER BY rate DESC\n" +
                    "LIMIT 3;").mapToBean(Product.class).stream().collect(Collectors.toList());


        });

    }


    public List<Product> getTopProducts(int kind) {
        return JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT p.product_id, p.product_name, p.price, p.price_real,p.rate, p.image_src,p.product_detail_id\n" +
                    "FROM product p JOIN category c on p.category_id = c.category_id JOIN product_detail pd on p.product_detail_id = pd.product_detail_id\n" +
                    "WHERE pa_category_id = " + kind + "\n" +
                    "ORDER BY quantity_sold DESC limit 16;").mapToBean(Product.class).stream().collect(Collectors.toList());
        });
    }

    public List<Product> getListSameProduct(int kind) {
        return JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT p.product_id, p.product_name, p.price, p.price_real,p.rate, p.image_src,p.product_detail_id\n" +
                    "FROM product p \n" +
                    "WHERE p.category_id = " + kind + "\n" +
                    "limit 16;").mapToBean(Product.class).stream().collect(Collectors.toList());
        });
    }


    public List<Product> getListWoodProduct() {
        return JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("select product_id, category_id, product_name, price, price_real, create_date, update_date, stt, quantity_sold, image_src, rate\n" +
                    "FROM product\n" +
                    "WHERE category_id = 1;").mapToBean(Product.class).stream().collect(Collectors.toList());
        });
    }


    public List<String> getImageOfProductById(int id) {
        return JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("select image_src from image where product_id " + "=" + id).mapTo(String.class).stream().collect(Collectors.toList());
        });
    }

    public int getCountProduct(int kind, int group) {

        return getListProductInGroup(kind, group).size();
    }

    public List<Product> getSortListProduct(int kind, String sort, int group) {
        List<Product> list = getListProductInGroup(kind, group);
        switch (sort) {
            case "nameA":
                Collections.sort(list, new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        return o1.getProductName().compareTo(o2.getProductName());
                    }
                });
                break;
            case "nameZ":
                Collections.sort(list, new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        return o2.getProductName().compareTo(o1.getProductName());
                    }
                });
                break;
            case "priceHigh":
                Collections.sort(list, new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        return o1.getPrice() - o2.getPrice();
                    }
                });
                break;
            case "priceLow":
                Collections.sort(list, new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        return o2.getPrice() - o1.getPrice();
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

    //    tim kiem
    public List<Product> getListProductInSearch(String search) {
        List<Product> list = new ArrayList<>();
        List<Product> pr = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT product_id, category_id, product_name, price, price_real, image_src, rate  FROM product").mapToBean(Product.class).stream().collect(Collectors.toList());
        });
        for (Product p : pr) {
            if (p.getProductName().contains(search)) {
                list.add(p);
            }
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
            return handle.createQuery("SELECT p.product_id, p.product_name, p.price, p.price_real,rate, p.image_src,p.product_detail_id\n" +
                    "FROM product p JOIN product_detail pd on p.product_detail_id = pd.product_detail_id\n" +
                    "ORDER BY pd.create_date DESC LIMIT 8;").mapToBean(Product.class).stream().collect(Collectors.toList());
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

//        System.out.println(ProductService.getInstance().getListProductInGroup(ALL, TRANGTRI));
//        System.out.println(ProductService.getInstance().getTopProducts(WOOD));
        System.out.println(getInstance().getListSameProduct(1));


        System.out.println(ProductService.getInstance().getListProductInGroup(ALL, TRANGTRI));
//        System.out.println(ProductService.getInstance().getTopProducts(WOOD));


    }


}

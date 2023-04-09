package services;

import bean.*;
import db.JDBIConnector;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
            List<Product> list = handle.createQuery("select p.id, p.name, p.description, p.detail, p.rate, p.status from product p where p.status not like 1").mapToBean(Product.class).stream().collect(Collectors.toList());
            for (Product product : list) {
                ProductService.getInstance()

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
        return JDBIConnector.get().withHandle(handle -> {
            Product product = handle.createQuery("select product_id, category_id, product_name, price, price_real, image_src, rate from product where product_id " + "=" + id).mapToBean(Product.class).one();
            product.setCategory(CaterogyService.getInstance().getCategoryById(product.getCategoryId()));
            product.setProductDetail(ProductDetailService.getInstance().getById(id));
            return product;
        });
    }

    //---------------------------- Danh sach san pham theo loai -----------------------
    public List<Product> getListProductByKind(int kind) {

        if (kind == ALL) {
            return JDBIConnector.get().withHandle(handle -> {

                List<Product> productList = handle.createQuery("SELECT pd.id,pd.`name`, pd.description, pd.detail, pd.rate,pd.category_id, pd.user_add_id,pd.`status` from product pd").mapToBean(Product.class).stream().collect(Collectors.toList());
                for (Product product : productList) {
                    product.setCategory(handle.createQuery("SELECT id, `name`, pa_category, status FROM category where category_id=" + product.getCategory().getId()).mapToBean(Category.class).stream().collect(Collectors.toList()).get(0));
                    product.setListHistoryPrice(handle.createQuery("SELECT hp.id, hp.price, hp.price_sale, hp.create_date, hp.`status` FROM history_price hp join product pd on hp.product_id=pd.id where(pd.id=" + product.getId() + "and where pd.id="+maxId()+")").mapToBean(HistoryPrice.class).stream().collect(Collectors.toList()));
                    product.setListImage(handle.createQuery("SELECT i.id, i.source FROM product_image pi join image i on pi.image_id = i.id where pi.product_id= " + product.getId() + ";").mapToBean(Image.class).stream().collect(Collectors.toList()));
                }
                return productList;
            });
        } else if (kind == SALE) {
            return JDBIConnector.get().withHandle(handle -> {
                List<Product> productList = handle.createQuery("SELECT pd.id,pd.`name`, pd.description, pd.detail, pd.rate,pd.category_id, pd.user_add_id,pd.`status` from product pd join history_price hp on hp.product_id=pd.id where hp.price_sale is not null ").mapToBean(Product.class).stream().collect(Collectors.toList());
                for (Product product : productList) {
                    product.setCategory(handle.createQuery("SELECT id, `name`, pa_category, status FROM category where category_id=" + product.getCategory().getId()).mapToBean(Category.class).stream().collect(Collectors.toList()).get(0));
                    product.setListHistoryPrice(handle.createQuery("SELECT hp.id, hp.price, hp.price_sale, hp.create_date, hp.`status` FROM history_price hp join product pd on hp.product_id=pd.id where(pd.id=" + product.getId() + "and  pd.id="+maxId()+")").mapToBean(HistoryPrice.class).stream().collect(Collectors.toList()));
                    product.setListImage(handle.createQuery("SELECT i.id, i.source FROM product_image pi join image i on pi.image_id = i.id where pi.product_id= " + product.getId() + ";").mapToBean(Image.class).stream().collect(Collectors.toList()));
                }
                return productList;

            });
        } else if (kind == NEW) {
            return JDBIConnector.get().withHandle(handle -> {
                List<Product> productList = handle.createQuery("SELECT pd.id,pd.`name`, pd.description, pd.detail, pd.rate,pd.category_id, pd.user_add_id,pd.`status` from product pd where pd.status=0").mapToBean(Product.class).stream().collect(Collectors.toList());
                for (Product product : productList) {
                    product.setCategory(handle.createQuery("SELECT id, `name`, pa_category, status FROM category where category_id=" + product.getCategory().getId()).mapToBean(Category.class).stream().collect(Collectors.toList()).get(0));
                    product.setListHistoryPrice(handle.createQuery("SELECT hp.id, hp.price, hp.price_sale, hp.create_date, hp.`status` FROM history_price hp join product pd on hp.product_id=pd.id where(pd.id=" + product.getId() + "and where pd.id="+maxId()+")").mapToBean(HistoryPrice.class).stream().collect(Collectors.toList()));
                    product.setListImage(handle.createQuery("SELECT i.id, i.source FROM product_image pi join image i on pi.image_id = i.id where pi.product_id= " + product.getId() + ";").mapToBean(Image.class).stream().collect(Collectors.toList()));
                }
                return productList;

            });
        }
        return JDBIConnector.get().withHandle(handle -> {
            List<Product> productList = handle.createQuery("SELECT pd.id,pd.`name`, pd.description, pd.detail, pd.rate,pd.category_id, pd.user_add_id,pd.`status` from product pd join category c on pd.category_id = c.id WHERE c.pa_category = " + kind).mapToBean(Product.class).stream().collect(Collectors.toList());
            for (Product product : productList) {
                product.setCategory(CaterogyService.getInstance().getCategoryById(product.getId()));
                product.setListHistoryPrice(HistoryPriceService.getInstance().getPriceNow(product.getId()));
                product.setListImage(handle.createQuery("SELECT i.id, i.source FROM product_image pi join image i on pi.image_id = i.id where pi.product_id= " + product.getId() + ";").mapToBean(Image.class).stream().collect(Collectors.toList()));
            }
            return productList;

        });


    }

    public

    // -------------------- Loc san pham theo nhom --------------------------------
    public List<Product> getListProductInGroupName(int kind, String group) {

        List<Product> list = getListProductByKind(kind);
        List<Product> listResult = new ArrayList<Product>();
        if ("".equals(group))
            return list;
        for (Product product : list) {
            if (product.getCategory().getName().equals(group)) {
                listResult.add(product);
            }
        }

        return listResult;

    }


//------------------------ Danh sach san pham o 1 trang ---------------------------------------

    public List<Product> getListProductInPageName(int kind, String group, String page) {
        List<Product> list = getListProductInGroupName(kind, group);
//        List<Product> list = getSortListProductName(kind, group, sort);
        List<Product> listResult = new ArrayList<Product>();
        int pageInt = Integer.parseInt(page);
        int start = (pageInt - 1) * 15 < 0 ? 0 : (pageInt - 1) * 15;
        int end = pageInt <= list.size() / 15 ? pageInt * 15 : list.size() - ((pageInt - 1) * 15) + start;
        for (int i = start; i < end; i++) {
            listResult.add(list.get(i));
        }

        return listResult;
    }

    public List<Product> getListFavouriteProduct() {
        return JDBIConnector.get().withHandle(handle -> {

            return handle.createQuery("select id, name, description, detail, rate, category_id, user_add_id, status from product order by rate desc limit 3;").mapToBean(Product.class).stream().collect(Collectors.toList());


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

    public List<Product> getListSameProduct(int paCategoryId) {
        return JDBIConnector.get().withHandle(handle -> {
            List<Product> productList = handle.createQuery("SELECT p.product_id, p.price,p.price_real,p.product_name,p.rate,p.category_id,p.image_src \n" +
                    "FROM product p JOIN category c on p.category_id=c.category_id \n" +
                    "JOIN pa_category pa ON c.pa_category_id = pa.pa_category_id \n" +
                    "WHERE pa.pa_category_id = :paCategoryId LIMIT 16").bind("paCategoryId", paCategoryId).mapToBean(Product.class).stream().collect(Collectors.toList());

            for (Product product : productList) {
                product.setCategory(CaterogyService.getInstance().getCategoryById(product.getCategoryId()));
            }
            return productList;

        });
    }

    public List<String> getImageOfProductById(int id) {
        return JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("select image_src from image where product_id " + "=" + id).mapTo(String.class).stream().collect(Collectors.toList());
        });
    }

    //------------------ Tong so san pham theo nhom ---------------------
    public int getCountProduct(int kind, String group) {

        return getListProductInGroupName(kind, group).size();
    }

    //----------------------------- Sap xep san pham ---------------------------
    public List<Product> getSortListProductName(int kind, String sort, String group) {
        List<Product> list = getListProductInGroupName(kind, group);
        switch (sort) {
            case "nameA":
                Collections.sort(list, new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        return o1.getName().compareTo(o2.getName());
                    }
                });
                break;
            case "nameZ":
                Collections.sort(list, new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        return o2.getName().compareTo(o1.getName());
                    }
                });
                break;
            case "priceHigh":
                Collections.sort(list, new Comparator<Product>() {

                    @Override
                    public int compare(Product o1, Product o2) {
                        return o1.getListHistoryPrice().get(0).getPrice() - o2.getListHistoryPrice().get(0).getPrice();
                    }
                });
                break;
            case "priceLow":
                Collections.sort(list, new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        return o2.getListHistoryPrice().get(0).getPrice() - o1.getListHistoryPrice().get(0).getPrice();
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

    //------------------------------ Tim kiem----------------------------------------
    public List<Product> getListProductInSearch(String search) {
        List<Product> list = new ArrayList<>();
//        List<Product> pr = JDBIConnector.get().withHandle(handle -> {
//            return handle.createQuery("SELECT pd.id,pd.`name`, pd.description, pd.detail, pd.rate,pd.category_id, pd.user_add_id,pd.`status` from product pd").mapToBean(Product.class).stream().collect(Collectors.toList());
//        });
        List<Product> pr = getListProduct();
        for (Product p : pr) {
            if (p.getName().toUpperCase().contains(search.toUpperCase())) {
                list.add(p);
            }
        }
        return list;
    }

    //--------------------- Lay id lon nhat trong ban ----------------------------
    public int nextId() {
        return 1 + JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT MAX(`id`) as numberProduct FROM `product`").mapTo(Integer.class).one();
        });
    }

    //    --------------------------- Them san pham ----------------------------
    public int maxId() {
        return JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT MAX(`id`) as numberProduct FROM `product`").mapTo(Integer.class).one();
        });
    }

    public void addProduct(Product product) {
        JDBIConnector.get().withHandle(handle -> {
            return handle.createUpdate("INSERT INTO product VALUES (:id, :name, :description,  :detail, :rate, :categoryId,:user_add_id, :status);")
                    .bind("productId", nextId())
                    .bind("name", product.getName())
                    .bind("description", product.getDescription())
                    .bind("detail", product.getDetail())
                    .bind("rate", product.getRate())
                    .bind("categoryId", product.getCategory().getId())
                    .bind("user_add_id", product.getUserAdd().getId())
                    .bind("status", product.getStatus())
                    .execute();
        });
    }

    // ------------------------- Sua san pham ----------------------------------
    public void editProduct(int id, String name, Category category, String descriptin, String detail, User user,int status) {
        JDBIConnector.get().withHandle(handle -> {
            return handle.createUpdate("UPDATE product SET name=?,description=?, detail=?,category_id=?,user_add_id=?,status=? where id= " + id + ";")
                    .bind(0, name)
                    .bind(1, descriptin)
                    .bind(2, detail)
                    .bind(3, category.getId())
                    .bind(4,user.getId())
                    .bind(5, status)
                    .execute();
        });
    }
    public List<Product> getNewProducts() {
        return JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT p.product_id, p.product_name, p.price, p.price_real,rate, p.image_src,p.product_detail_id\n" +
                    "FROM product p JOIN product_detail pd on p.product_detail_id = pd.product_detail_id\n" +
                    "ORDER BY pd.create_date DESC LIMIT 8;").mapToBean(Product.class).stream().collect(Collectors.toList());
        });
    }

    public void editImageProduct(int id, String src) {
        JDBIConnector.get().withHandle(handle -> {
            return handle.createUpdate("UPDATE product SET image_src =:src where product_id=:id")
                    .bind("src", src)
                    .bind("id", id)
                    .execute();
        });
    }

    public void deleteProduct(int id) {
        JDBIConnector.get().withHandle(handle -> {
            return handle.createUpdate("UPDATE product_detail SET stt =1 where product_detail_id=:id")
                    .bind("id", id)
                    .execute();
        });
    }

    public List<Integer> statisticalProduct(int kind) {
        List<Integer> result = new ArrayList<>();
        int sum = 0;
        for (int i = 1; i < 12; i++) {
            sum = statisticalProductInMonth(kind, i);
            result.add(sum);
        }
        return result;
    }

    public int statisticalProductInMonth(int kind, int month) {
        return JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("Select count(*) from ord o join  order_detail od on o.order_id=od.order_id join product pd on od.product_id = pd.product_id join category c on pd.category_id =c.category_id join pa_category pc on c.pa_category_id = pc.pa_category_id where ( MONTH(o.order_date)=" + month + ") and pc.pa_category_id= " + kind + ";").mapTo(Integer.class).one();
        });
    }

    //    public static void main(String[] args) {
//        System.out.println(getInstance().statisticalProduct(1));
//        System.out.println(getInstance().statisticalProductInMonth(1,1));
//    }
    public static void main(String[] args) {
//        getInstance().deleteProduct(1);
//        System.out.println(ProductService.getInstance().getProductById(9));
//        System.out.println(ProductService.getInstance().getListProduct());
//        System.out.println(ProductService.getInstance().getListTopProduct());

//        System.out.println(ProductService.getInstance().getProductById(1));

//        System.out.println(ProductService.getInstance().getListFavouriteProduct());
//        System.out.println(ProductService.getInstance().getImageOfProductById(1));

//        System.out.println(ProductService.getInstance().getNewProducts());
//        System.out.println(ProductService.getInstance().getCommentOfProductById(1));


//        System.out.println(ProductService.getInstance().getTopWoodProducts());
        System.out.println(ProductService.getInstance().getListProductByKind(ALL));

//        System.out.println(ProductService.getInstance().getListProductInGroup(ALL, TRANGTRI));
//        System.out.println(ProductService.getInstance().getTopProducts(WOOD));
//        getInstance().getListSameProduct(2);


//        System.out.println(ProductService.getInstance().getListProductInGroup(ALL, TRANGTRI));
//        System.out.println(ProductService.getInstance().getTopProducts(WOOD));
//        System.out.println(ProductService.getInstance().getListProductInGroupName(0, ""));
//        ProductDetail productDetail = new ProductDetail(getInstance().getListProduct().size() + 1, "ádsa", "ádad", null, 10, LocalDateTime.now(), LocalDateTime.of(2022, 12, 11, 3, 3, 2), 0, 3);
//        ProductService.getInstance().addProductDetail(productDetail);
//        Product product = new Product(getInstance().getListProduct().size() + 1, 1, "dsad", 1312, 13, 0, "", productDetail);
//
//        ProductService.getInstance().addProduct(product);
//
    }


}

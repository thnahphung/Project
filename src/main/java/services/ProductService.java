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
            List<Product> list = handle.createQuery("SELECT p.product_id, p.category_id, p.product_name, p.price, p.price_real, p.image_src, p.rate FROM product p join product_detail pd on p.product_detail_id= pd.product_detail_id where pd.stt not like 1").mapToBean(Product.class).stream().collect(Collectors.toList());
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

    //------------------------------ Tim kiem----------------------------------------
    public List<Product> getListProductInSearch(String search) {
        List<Product> list = new ArrayList<>();
        List<Product> pr = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT product_id, category_id, product_name, price, price_real, image_src, rate  FROM product").mapToBean(Product.class).stream().collect(Collectors.toList());
        });
        for (Product p : pr) {
            if (p.getProductName().toUpperCase().contains(search.toUpperCase())) {
                list.add(p);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(getInstance().getListProductInSearch("Cú"));
    }

    //--------------------- Lay id lon nhat trong ban ----------------------------
    public int nextId() {
        return 1 + JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT MAX(`product_id`) as numberProduct FROM `product`").mapTo(Integer.class).one();
        });
    }

    //    --------------------------- Them san pham ----------------------------
    public void addProduct(Product product) {
        JDBIConnector.get().withHandle(handle -> {
            return handle.createUpdate("INSERT INTO product VALUES (:productId, :categoryId, :name, :price, :priceReal, :rate, :imgSrc, :proDetailId)")
                    .bind("productId", nextId())
                    .bind("categoryId", product.getCategoryId())
                    .bind("name", product.getProductName())
                    .bind("price", product.getPrice())
                    .bind("priceReal", product.getPriceReal())
                    .bind("rate", product.getRate())
                    .bind("imgSrc", product.getImageSrc())
                    .bind("proDetailId", product.getProductDetail().getProductDetailId())
                    .execute();
        });
    }

    //------------------------- Them chi tiet san pham ---------------------------

    public void addProductDetail(ProductDetail product) {
        JDBIConnector.get().withHandle(handle -> {
            return handle.createUpdate("INSERT INTO product_detail VALUES (:productDetailId, :decription, :detail, :inventory, :createDate, :updateDate, :stt, :quantitySold,:user)")
                    .bind("productDetailId", nextId())
                    .bind("decription", product.getDecription())
                    .bind("detail", product.getDetail())
                    .bind("inventory", product.getInventory())
                    .bind("createDate", LocalDateTime.now())
                    .bind("updateDate", LocalDateTime.now())
                    .bind("stt", 0)
                    .bind("quantitySold", 3)
                    .bind("user", 1)
                    .execute();
        });
    }

    // ------------------------- Sua san pham ----------------------------------
    public void editProduct(int id, String name, int price, int priceReal, int group, String img) {
        JDBIConnector.get().withHandle(handle -> {
            return handle.createUpdate("UPDATE product SET category_id=?, product_name=?, price=?,price_real=?,image_src=? where product_id= " + id + ";")
                    .bind(0, group)
                    .bind(1, name)
                    .bind(2, price)
                    .bind(3, priceReal)
                    .bind(4, img)
                    .execute();
        });
    }

    //-------------------------- Sua chi tiet san pham -------------------------------------
    public void editProductDetail(int id, String decription, String detail, int inventory, int stt, int userId) {
        JDBIConnector.get().withHandle(handle -> {
            return handle.createUpdate("UPDATE product_detail SET decription=?, detail=?, inventory=?, update_date=?, stt=?, user_id=?")
                    .bind(0, decription)
                    .bind(1, detail)
                    .bind(2, inventory)
                    .bind(3, LocalDateTime.now())
                    .bind(4, stt)
                    .bind(5, userId)
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
    public void deleteProduct(int id){
        JDBIConnector.get().withHandle(handle -> {
            return handle.createUpdate("UPDATE product_detail SET stt =1 where product_detail_id=:id")
                    .bind("id", id)
                    .execute();
        });
    }
//    public static void main(String[] args) {
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
//        System.out.println(ProductService.getInstance().getListProductByKind(ALL));

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
//    }


}

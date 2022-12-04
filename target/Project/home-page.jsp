<%@ page import="bean.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="services.ProductService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trang chủ</title>
    <link rel="stylesheet" href="css/reset.css">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css">

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
          integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"/>

    <link rel="stylesheet" href="css/general.css">
    <link rel="stylesheet" href="css/home-page.css">
</head>

<body>
<ul class="nav nav-home ">
    <li class=" left">
        <a href="http://localhost:8080/homepage"><img src="images/logo/logo-rmbg1.png" alt=""></a>
    </li>
    <li class="nav-item center">
        <a class="nav-link" href="http://localhost:8080/listProduct?kind=<%=ProductService.ALL%>&page=1">Sản Phẩm</a>
        <a class="nav-link" href="http://localhost:8080/listProduct?kind=<%=ProductService.WOOD%>&page=1">Gỗ</a>
        <a class="nav-link" href="http://localhost:8080/listProduct?kind=<%=ProductService.RECAMIC%>&page=1">Gốm</a>
        <a class="nav-link" href="list-product.jsp">giảm giá</a>
        <a class="nav-link" href="list-product.jsp">Bán Chạy</a>
    </li>
    <li class=" right">
        <div class="item-right search-item">
            <input type="text" id="search" placeholder="Tìm kiếm..."/>
            <span class="icon"><i class="fa fa-search"></i></span>

        </div>
        <a href="login.jsp" class="item-right"> <i class="fa-solid fa-user"></i>
            <p>Đăng nhập</p>
        </a>
        <a href="cart.jsp" class="item-right"><i class="fa-solid fa-cart-shopping"></i>
            <p>Giỏ hàng (2)</p>
        </a>
    </li>
</ul>

<div class="banner-slider">
    <div id="carouselExampleFade" class="carousel slide carousel-fade" data-ride="carousel">
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img src="images/home-page/main-banner-1-1903x975.jpg" class="d-block w-100" alt="...">
            </div>
            <div class="carousel-item">
                <img src="images/home-page/main-banner-2-1903x975.jpg" class="d-block w-100" alt="...">
            </div>
            <div class="carousel-item">
                <img src="images/home-page/main-banner-2-1903x975.jpg" class="d-block w-100" alt="...">
            </div>
        </div>
        <button class="carousel-control-prev" type="button" data-target="#carouselExampleFade" data-slide="prev">

        </button>
        <button class="carousel-control-next" type="button" data-target="#carouselExampleFade" data-slide="next">

        </button>
    </div>


</div>
<!-- favourite -->
<div class="container favourite bd-bottom ">
    <div class="title top-favourite">
        <h2>Sản phẩm được yêu thích nhất</h2>
    </div>
    <%List<Product> favouriteProducts = (List<Product>) request.getAttribute("favouriteProducts");%>
    <div class="favourite top-product">
        <% for (Product product : favouriteProducts) { %>
        <div class="top-product-img">
            <a href="http://localhost:8080/detail-product?id=<%= product.getProductId()%>"><img
                    src="<%= product.getImageSrc()%>" alt=""></a>
        </div>

        <% } %>
    </div>
</div>
<!-- new-product -->
<div class="container new-products bd-bottom ">
    <div class="title new-product">
        <h2>Sản phẩm mới nhất</h2>
    </div>
    <%List<Product> newProducts = (List<Product>) request.getAttribute("newProducts");%>

    <div class="slider-new-products">
        <% for(Product product:newProducts){ %>
        <div class="product">
            <div class="thumbnail">
                <div class="cont-item ">
                    <a href="http://localhost:8080/detail-product?id=<%= product.getProductId()%>"><img
                            src="<%=product.getImageSrc()%>"
                            alt="">
                    </a>
                </div>

                <div class="caption">
                    <h3><a href=""> <%=product.getProductName()%></a></h3>
                    <div class="ratting">
                        <i class="fa fa-star yellow"></i>
                        <i class="fa fa-star yellow"></i>
                        <i class="fa fa-star yellow"></i>
                        <i class="fa fa-star yellow"></i>
                        <i class="fa fa-star "></i>
                    </div>
                    <h3 class="price">
                        <%=product.getPrice()%>VND
                        <span class="price-real"><%=product.getPriceReal()%>VND</span>
                    </h3>
                </div>
            </div>
        </div>
        <% } %>
<%--        <div class="product">--%>
<%--            <div class="thumbnail">--%>
<%--                <div class="cont-item ">--%>
<%--                    <a href="#"><img--%>
<%--                            src="https://i.etsystatic.com/14458095/r/il/095d0c/3905526261/il_794xN.3905526261_b4o9.jpg"--%>
<%--                            alt="">--%>
<%--                    </a>--%>
<%--                </div>--%>

<%--                <div class="caption">--%>
<%--                    <h3><a href=""> Bộ cốc bầu trời xanh dễ thương </a></h3>--%>
<%--                    <div class="ratting">--%>
<%--                        <i class="fa fa-star yellow"></i>--%>
<%--                        <i class="fa fa-star yellow"></i>--%>
<%--                        <i class="fa fa-star yellow"></i>--%>
<%--                        <i class="fa fa-star yellow"></i>--%>
<%--                        <i class="fa fa-star "></i>--%>
<%--                    </div>--%>
<%--                    <h3 class="price">--%>
<%--                        760.000 VND--%>
<%--                        <!-- <span class="price-real">760.000 VND</span> -->--%>
<%--                    </h3>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <div class="product">--%>
<%--            <div class="thumbnail">--%>
<%--                <div class="cont-item ">--%>
<%--                    <a href="#"><img--%>
<%--                            src="https://i.etsystatic.com/36832986/r/il/5a7e1a/4127630124/il_794xN.4127630124_ktlk.jpg"--%>
<%--                            alt="">--%>
<%--                    </a>--%>
<%--                </div>--%>

<%--                <div class="caption">--%>
<%--                    <h3><a href=""> Bình gốm trang trí nội thất</a></h3>--%>
<%--                    <div class="ratting">--%>
<%--                        <i class="fa fa-star yellow"></i>--%>
<%--                        <i class="fa fa-star yellow"></i>--%>
<%--                        <i class="fa fa-star yellow"></i>--%>
<%--                        <i class="fa fa-star yellow"></i>--%>
<%--                        <i class="fa fa-star "></i>--%>
<%--                    </div>--%>
<%--                    <h3 class="price">--%>
<%--                        596.000 VND--%>
<%--                        <!-- <span class="price-real">490.000 VND</span> -->--%>
<%--                    </h3>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <div class="product">--%>
<%--            <div class="thumbnail">--%>
<%--                <div class="cont-item ">--%>
<%--                    <a href="#"><img--%>
<%--                            src="https://i.etsystatic.com/27431999/r/il/d76074/4160030118/il_794xN.4160030118_bdy0.jpg"--%>
<%--                            alt="">--%>
<%--                    </a>--%>
<%--                </div>--%>

<%--                <div class="caption">--%>
<%--                    <h3><a href=""> Cốc gốm thảo mộc</a></h3>--%>
<%--                    <div class="ratting">--%>
<%--                        <i class="fa fa-star yellow"></i>--%>
<%--                        <i class="fa fa-star yellow"></i>--%>
<%--                        <i class="fa fa-star yellow"></i>--%>
<%--                        <i class="fa fa-star yellow"></i>--%>
<%--                        <i class="fa fa-star "></i>--%>
<%--                    </div>--%>
<%--                    <h3 class="price">--%>
<%--                        369.000 VND--%>
<%--                        <!-- <span class="price-real">490.000 VND</span> -->--%>
<%--                    </h3>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <div class="product">--%>
<%--            <div class="thumbnail">--%>
<%--                <div class="cont-item ">--%>
<%--                    <a href="#"><img--%>
<%--                            src="https://i.etsystatic.com/18808630/r/il/53972b/3812956630/il_794xN.3812956630_2gct.jpg"--%>
<%--                            alt="">--%>
<%--                    </a>--%>
<%--                </div>--%>

<%--                <div class="caption">--%>
<%--                    <h3><a href=""> Đĩa tròn gỗ thủ công</a></h3>--%>
<%--                    <div class="ratting">--%>
<%--                        <i class="fa fa-star yellow"></i>--%>
<%--                        <i class="fa fa-star yellow"></i>--%>
<%--                        <i class="fa fa-star yellow"></i>--%>
<%--                        <i class="fa fa-star yellow"></i>--%>
<%--                        <i class="fa fa-star "></i>--%>
<%--                    </div>--%>
<%--                    <h3 class="price">--%>
<%--                        329.000 VND--%>
<%--                        <span class="price-real">490.000 VND</span>--%>
<%--                    </h3>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
    </div>
</div>
<!-- featured -->
<div class="container featured ">
    <div class="title featured-product">
        <h2>Sản phẩm nổi bật</h2>
    </div>
    <div class="featured-list">
        <div class="wood featured-img-list">
            <div class="product">
                <div class="thumbnail">
                    <div class="cont-item ">
                        <a href="#"><img
                                src="https://i.etsystatic.com/9623213/r/il/7cc5cb/995912283/il_794xN.995912283_mnbb.jpg"
                                alt="">

                        </a>
                    </div>

                    <div class="caption">
                        <h3><a href=""> Thớt gỗ óc chó</a></h3>
                        <div class="ratting">
                            <i class="fa fa-star yellow"></i>
                            <i class="fa fa-star yellow"></i>
                            <i class="fa fa-star yellow"></i>
                            <i class="fa fa-star yellow"></i>
                            <i class="fa fa-star "></i>
                        </div>
                        <h3 class="price">
                            750.000 VND
                            <!-- <span class="price-real">490.000 VND</span> -->
                        </h3>
                    </div>
                </div>
            </div>
            <div class="product">
                <div class="thumbnail">
                    <div class="cont-item ">
                        <a href="#"><img
                                src="https://i.etsystatic.com/11286611/r/il/d113cd/1582087127/il_794xN.1582087127_30q1.jpg"
                                alt="">

                        </a>
                    </div>

                    <div class="caption">
                        <h3><a href=""> Chụp đèn gỗ</a></h3>
                        <div class="ratting">
                            <i class="fa fa-star yellow"></i>
                            <i class="fa fa-star yellow"></i>
                            <i class="fa fa-star yellow"></i>
                            <i class="fa fa-star yellow"></i>
                            <i class="fa fa-star "></i>
                        </div>
                        <h3 class="price">
                            2.334.000 VND
                            <span class="price-real">2.917.000 VND</span>
                        </h3>
                    </div>
                </div>
            </div>
            <div class="product">
                <div class="thumbnail">
                    <div class="cont-item ">
                        <a href="#"><img
                                src="https://i.etsystatic.com/28083097/r/il/4d0be8/3478700194/il_794xN.3478700194_lwhz.jpg"
                                alt="">

                        </a>
                    </div>

                    <div class="caption">
                        <h3><a href=""> Bình hoa tối giản</a></h3>
                        <div class="ratting">
                            <i class="fa fa-star yellow"></i>
                            <i class="fa fa-star yellow"></i>
                            <i class="fa fa-star yellow"></i>
                            <i class="fa fa-star yellow"></i>
                            <i class="fa fa-star "></i>
                        </div>
                        <h3 class="price">
                            466.000 VND
                            <!-- <span class="price-real">490.000 VND</span> -->
                        </h3>
                    </div>
                </div>
            </div>
            <div class="product">
                <div class="thumbnail">
                    <div class="cont-item ">
                        <a href="#"><img
                                src="https://i.etsystatic.com/11707818/r/il/f87020/2047935892/il_794xN.2047935892_n5xr.jpg"
                                alt="">

                        </a>
                    </div>

                    <div class="caption">
                        <h3><a href=""> Dụng cụ mở chai treo tường</a></h3>
                        <div class="ratting">
                            <i class="fa fa-star yellow"></i>
                            <i class="fa fa-star yellow"></i>
                            <i class="fa fa-star yellow"></i>
                            <i class="fa fa-star yellow"></i>
                            <i class="fa fa-star "></i>
                        </div>
                        <h3 class="price">
                            875.000 VND
                            <!-- <span class="price-real">490.000 VND</span> -->
                        </h3>
                    </div>
                </div>
            </div>
            <div class="product">
                <div class="thumbnail">
                    <div class="cont-item ">
                        <a href="#"><img
                                src="https://i.etsystatic.com/32000242/r/il/9cfdf7/3389038003/il_794xN.3389038003_42cu.jpg"
                                alt="">

                        </a>
                    </div>

                    <div class="caption">
                        <h3><a href=""> Lót ly hình mèo</a></h3>
                        <div class="ratting">
                            <i class="fa fa-star yellow"></i>
                            <i class="fa fa-star yellow"></i>
                            <i class="fa fa-star yellow"></i>
                            <i class="fa fa-star yellow"></i>
                            <i class="fa fa-star "></i>
                        </div>
                        <h3 class="price">
                            338.000 VND
                            <span class="price-real">397.000 VND</span>
                        </h3>
                    </div>
                </div>
            </div>
            <div class="product">
                <div class="thumbnail">
                    <div class="cont-item ">
                        <a href="#"><img
                                src="https://i.etsystatic.com/34036755/r/il/87793e/3786324874/il_794xN.3786324874_j0l4.jpg"
                                alt="">

                        </a>
                    </div>

                    <div class="caption">
                        <h3><a href=""> Lá nghệ thuật</a></h3>
                        <div class="ratting">
                            <i class="fa fa-star yellow"></i>
                            <i class="fa fa-star yellow"></i>
                            <i class="fa fa-star yellow"></i>
                            <i class="fa fa-star yellow"></i>
                            <i class="fa fa-star "></i>
                        </div>
                        <h3 class="price">
                            132.000 VND
                            <span class="price-real">264.000 VND</span>
                        </h3>
                    </div>
                </div>
            </div>
            <div class="product">
                <div class="thumbnail">
                    <div class="cont-item ">
                        <a href="#"><img
                                src="https://i.etsystatic.com/19076644/r/il/3388bd/4352543767/il_794xN.4352543767_gr5d.jpg"
                                alt="">

                        </a>
                    </div>

                    <div class="caption">
                        <h3><a href=""> Cặp đôi chim ruồi</a></h3>
                        <div class="ratting">
                            <i class="fa fa-star yellow"></i>
                            <i class="fa fa-star yellow"></i>
                            <i class="fa fa-star yellow"></i>
                            <i class="fa fa-star yellow"></i>
                            <i class="fa fa-star "></i>
                        </div>
                        <h3 class="price">
                            1.023.000 VND
                            <!-- <span class="price-real">490.000 VND</span> -->
                        </h3>
                    </div>
                </div>
            </div>
            <div class="product">
                <div class="thumbnail">
                    <div class="cont-item ">
                        <a href="#"><img
                                src="https://i.etsystatic.com/8105101/r/il/c0872d/568014834/il_794xN.568014834_mgmv.jpg"
                                alt="">

                        </a>
                    </div>

                    <div class="caption">
                        <h3><a href=""> Giá đỡ ipad</a></h3>
                        <div class="ratting">
                            <i class="fa fa-star yellow"></i>
                            <i class="fa fa-star yellow"></i>
                            <i class="fa fa-star yellow"></i>
                            <i class="fa fa-star yellow"></i>
                            <i class="fa fa-star "></i>
                        </div>
                        <h3 class="price">
                            492.000 VND
                            <!-- <span class="price-real">490.000 VND</span> -->
                        </h3>
                    </div>
                </div>
            </div>
            <div class="product">
                <div class="thumbnail">
                    <div class="cont-item ">
                        <a href="#"><img
                                src="https://i.etsystatic.com/9475846/r/il/36bde4/2220393418/il_794xN.2220393418_adja.jpg"
                                alt="">

                        </a>
                    </div>

                    <div class="caption">
                        <h3><a href=""> Khay đựng trứng</a></h3>
                        <div class="ratting">
                            <i class="fa fa-star yellow"></i>
                            <i class="fa fa-star yellow"></i>
                            <i class="fa fa-star yellow"></i>
                            <i class="fa fa-star yellow"></i>
                            <i class="fa fa-star "></i>
                        </div>
                        <h3 class="price">
                            795.000 VND
                            <!-- <span class="price-real">490.000 VND</span> -->
                        </h3>
                    </div>
                </div>
            </div>


        </div>
        <div class="pottery featured-img-list">
            <div class="product">
                <div class="thumbnail">
                    <div class="cont-item ">
                        <a href="#"><img
                                src="https://i.etsystatic.com/27431999/r/il/d76074/4160030118/il_794xN.4160030118_bdy0.jpg"
                                alt="">

                        </a>
                    </div>

                    <div class="caption">
                        <h3><a href=""> Tách trà thảo mộc gốm sứ</a></h3>
                        <div class="ratting">
                            <i class="fa fa-star yellow"></i>
                            <i class="fa fa-star yellow"></i>
                            <i class="fa fa-star yellow"></i>
                            <i class="fa fa-star yellow"></i>
                            <i class="fa fa-star "></i>
                        </div>
                        <h3 class="price">
                            1.269.000 VND
                            <!-- <span class="price-real">490.000 VND</span> -->
                        </h3>
                    </div>
                </div>
            </div>
            <div class="product">
                <div class="thumbnail">
                    <div class="cont-item ">
                        <a href="#"><img
                                src="https://i.etsystatic.com/22036630/r/il/ca5eae/2459501157/il_794xN.2459501157_95l3.jpg"
                                alt="">

                        </a>
                    </div>

                    <div class="caption">
                        <h3><a href=""> Hoa tulip gốm trang trí</a></h3>
                        <div class="ratting">
                            <i class="fa fa-star yellow"></i>
                            <i class="fa fa-star yellow"></i>
                            <i class="fa fa-star yellow"></i>
                            <i class="fa fa-star yellow"></i>
                            <i class="fa fa-star "></i>
                        </div>
                        <h3 class="price">
                            155.000 VND
                            <!-- <span class="price-real">490.000 VND</span> -->
                        </h3>
                    </div>
                </div>
            </div>
            <div class="product">
                <div class="thumbnail">
                    <div class="cont-item ">
                        <a href="#"><img
                                src="https://i.etsystatic.com/33871523/r/il/3dc2cf/3838096200/il_794xN.3838096200_6reo.jpg"
                                alt="">

                        </a>
                    </div>

                    <div class="caption">
                        <h3><a href=""> Thìa thủ công</a></h3>
                        <div class="ratting">
                            <i class="fa fa-star yellow"></i>
                            <i class="fa fa-star yellow"></i>
                            <i class="fa fa-star yellow"></i>
                            <i class="fa fa-star yellow"></i>
                            <i class="fa fa-star "></i>
                        </div>
                        <h3 class="price">
                            259.000 VND
                            <span class="price-real">324.000 VND</span>
                        </h3>
                    </div>
                </div>
            </div>
            <div class="product">
                <div class="thumbnail">
                    <div class="cont-item ">
                        <a href="#"><img
                                src="https://i.etsystatic.com/36818774/r/il/58ddbf/4359951979/il_794xN.4359951979_kyeo.jpg"
                                alt="">

                        </a>
                    </div>

                    <div class="caption">
                        <h3><a href=""> Cốc trà với trái tim vẽ tay</a></h3>
                        <div class="ratting">
                            <i class="fa fa-star yellow"></i>
                            <i class="fa fa-star yellow"></i>
                            <i class="fa fa-star yellow"></i>
                            <i class="fa fa-star yellow"></i>
                            <i class="fa fa-star "></i>
                        </div>
                        <h3 class="price">
                            397.000 VND
                            <!-- <span class="price-real">490.000 VND</span> -->
                        </h3>
                    </div>
                </div>
            </div>
            <div class="product">
                <div class="thumbnail">
                    <div class="cont-item ">
                        <a href="#"><img
                                src="https://i.etsystatic.com/34419527/r/il/5d30ba/3890127857/il_794xN.3890127857_a41m.jpg"
                                alt="">

                        </a>
                    </div>

                    <div class="caption">
                        <h3><a href=""> Bộ tách trà</a></h3>
                        <div class="ratting">
                            <i class="fa fa-star yellow"></i>
                            <i class="fa fa-star yellow"></i>
                            <i class="fa fa-star yellow"></i>
                            <i class="fa fa-star yellow"></i>
                            <i class="fa fa-star "></i>
                        </div>
                        <h3 class="price">
                            912.847 VND
                            <span class="price-real">1.069.430 VND</span>
                        </h3>
                    </div>
                </div>
            </div>
            <div class="product">
                <div class="thumbnail">
                    <div class="cont-item ">
                        <a href="#"><img
                                src="https://i.etsystatic.com/35949208/r/il/0b950c/4244262239/il_794xN.4244262239_dcew.jpg"
                                alt="">

                        </a>
                    </div>

                    <div class="caption">
                        <h3><a href=""> Cốc hoa thẩm mỹ Kawaii</a></h3>
                        <div class="ratting">
                            <i class="fa fa-star yellow"></i>
                            <i class="fa fa-star yellow"></i>
                            <i class="fa fa-star yellow"></i>
                            <i class="fa fa-star yellow"></i>
                            <i class="fa fa-star "></i>
                        </div>
                        <h3 class="price">
                            791.016 VND
                            <span class="price-real">878.906 VND</span>
                        </h3>
                    </div>
                </div>
            </div>
            <div class="product">
                <div class="thumbnail">
                    <div class="cont-item ">
                        <a href="#"><img
                                src="https://i.etsystatic.com/32760853/r/il/974d95/3547268727/il_794xN.3547268727_4dwp.jpg"
                                alt="">

                        </a>
                    </div>

                    <div class="caption">
                        <h3><a href=""> Bình cắm hoa</a></h3>
                        <div class="ratting">
                            <i class="fa fa-star yellow"></i>
                            <i class="fa fa-star yellow"></i>
                            <i class="fa fa-star yellow"></i>
                            <i class="fa fa-star yellow"></i>
                            <i class="fa fa-star "></i>
                        </div>
                        <h3 class="price">
                            499.642 VND
                            <span class="price-real">555.158 VND</span>
                        </h3>
                    </div>
                </div>
            </div>
            <div class="product">
                <div class="thumbnail">
                    <div class="cont-item ">
                        <a href="#"><img
                                src="https://i.etsystatic.com/28475776/r/il/0217dd/3194568106/il_794xN.3194568106_2q9v.jpg"
                                alt="">

                        </a>
                    </div>

                    <div class="caption">
                        <h3><a href=""> Bình cắm hoa nhiều kiểu dáng</a></h3>
                        <div class="ratting">
                            <i class="fa fa-star yellow"></i>
                            <i class="fa fa-star yellow"></i>
                            <i class="fa fa-star yellow"></i>
                            <i class="fa fa-star yellow"></i>
                            <i class="fa fa-star "></i>
                        </div>
                        <h3 class="price">
                            530.000 VND
                            <!-- <span class="price-real">490.000 VND</span> -->
                        </h3>
                    </div>
                </div>
            </div>
            <div class="product">
                <div class="thumbnail">
                    <div class="cont-item ">
                        <a href="#"><img
                                src="https://i.etsystatic.com/26537856/r/il/6a2c53/3466089182/il_794xN.3466089182_rc6k.jpg"
                                alt="">
                        </a>
                    </div>

                    <div class="caption">
                        <h3><a href=""> Con mèo gốm</a></h3>
                        <div class="ratting">
                            <i class="fa fa-star yellow"></i>
                            <i class="fa fa-star yellow"></i>
                            <i class="fa fa-star yellow"></i>
                            <i class="fa fa-star yellow"></i>
                            <i class="fa fa-star "></i>
                        </div>
                        <h3 class="price">
                            308.290 VND
                            <!-- <span class="price-real">490.000 VND</span> -->
                        </h3>
                    </div>
                </div>
            </div>
            <div class="product">
                <div class="thumbnail">
                    <div class="cont-item ">
                        <a href="#"><img
                                src="https://i.etsystatic.com/21154540/r/il/874bf2/4359626909/il_794xN.4359626909_j546.jpg"
                                alt="">

                        </a>
                    </div>

                    <div class="caption">
                        <h3><a href=""> Cây thông Noel</a></h3>
                        <div class="ratting">
                            <i class="fa fa-star yellow"></i>
                            <i class="fa fa-star yellow"></i>
                            <i class="fa fa-star yellow"></i>
                            <i class="fa fa-star yellow"></i>
                            <i class="fa fa-star "></i>
                        </div>
                        <h3 class="price">
                            1.606.000 VND
                            <!-- <span class="price-real">490.000 VND</span> -->
                        </h3>
                    </div>
                </div>
            </div>
            <div class="product">
                <div class="thumbnail">
                    <div class="cont-item ">
                        <a href="#"><img
                                src="https://i.etsystatic.com/34878446/r/il/e74dd8/3801559837/il_794xN.3801559837_7hlo.jpg"
                                alt="">

                        </a>
                    </div>

                    <div class="caption">
                        <h3><a href=""> Bình gốm rỗng hình tròn</a></h3>
                        <div class="ratting">
                            <i class="fa fa-star yellow"></i>
                            <i class="fa fa-star yellow"></i>
                            <i class="fa fa-star yellow"></i>
                            <i class="fa fa-star yellow"></i>
                            <i class="fa fa-star "></i>
                        </div>
                        <h3 class="price">
                            487.000 VND
                            <!-- <span class="price-real">490.000 VND</span> -->
                        </h3>
                    </div>
                </div>
            </div>
            `

        </div>
    </div>

</div>
<!-- Footer -->

<footer class="footer row">
    <div class="col-1"></div>
    <div class="col-2">
        <img src="images/logo/logo2.png" alt="">
    </div>
    <div class="col-2">
        <div class="title">Sản phẩm</div>
        <div><a href="">Đồ gỗ</a></div>
        <div><a href="">Đồ gốm</a></div>
    </div>
    <div class="col-2">
        <div class="title">Về Craft</div>
        <div><a href="">Tuyển cộng tác viên</a></div>
        <div><a href="">Địa chỉ</a></div>
        <div><a href="">Thông tin thành lập</a></div>
        <div><a href="">Người thành lập</a></div>
    </div>
    <div class="col-2">
        <div class="title">Liên hệ</div>
        <div><a href="">Facebook</a></div>
        <div><a href="">Instagram</a></div>
        <div><a href="">Twitter</a></div>
    </div>
    <div class="col-2">
        <div class="title">Hỗ trợ</div>
        <div><a href="">Thông tin bảo hành</a></div>
        <div><a href="">Thông tin đổi trả</a></div>
        <div><a href="">Liên hệ nhân viên chăm sóc</a></div>
    </div>

    <div class="col-1"></div>

</footer>

<a href="#" class="scrolltotop"><i class="fa fa-arrow-up"></i></a>


<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script type="text/javascript" src="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
        integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js"
        integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+"
        crossorigin="anonymous"></script>

<script src="js/general.js"></script>
<script src="js/home-page.js"></script>
</body>

</html>
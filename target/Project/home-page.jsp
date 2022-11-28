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
            <a href="http://localhost:8080/detail-product?id=<%= product.getProductId()%>&page=1"><img
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
        <% for (Product product : newProducts) { %>
        <div class="product">
            <div class="thumbnail">
                <div class="cont-item ">
                    <a href="http://localhost:8080/detail-product?id=<%= product.getProductId()%>&page=1"><img
                            src="<%=product.getImageSrc()%>"
                            alt="">
                    </a>
                </div>

                <div class="caption">
                    <h3><a href="http://localhost:8080/detail-product?id=<%= product.getProductId()%>&page=1"><%=product.getProductName()%>
                    </a></h3>
                    <div class="ratting">
                        <% int count = product.getRate();
                            for (int i = 0; i < 5; i++) {
                                if (count > 0) {%>
                        <i class="fa fa-star yellow"></i>
                        <%} else {%>
                        <i class="fa fa-star  "></i>
                        <%
                            }
                            count--;
                        %>

                        <%}%>
                    </div>
                    <h3 class="price">
                        <%=product.getPriceFormat()%> VND
                        <% if(product.getPriceReal() != 0) {%>
                        <span class="price-real"><%=product.getPriceRealFormat()%> VND</span>
                        <% } %>
                    </h3>
                </div>
            </div>
        </div>
        <% } %>

    </div>
</div>

<!-- featured -->
<div class="container featured ">
    <div class="title featured-product">
        <h2>Sản phẩm nổi bật</h2>
    </div>
    <div class="featured-list">
        <%List<Product> topWoodProducts = (List<Product>) request.getAttribute("topWoodProducts");%>
        <div class="wood featured-img-list">
            <% for (Product product : topWoodProducts) {%>
            <div class="product">
                <div class="thumbnail">
                    <div class="cont-item ">
                        <a href="http://localhost:8080/detail-product?id=<%= product.getProductId()%>&page=1"><img
                                src="<%=product.getImageSrc()%>"
                                alt="">

                        </a>
                    </div>

                    <div class="caption">
                        <h3><a href="http://localhost:8080/detail-product?id=<%= product.getProductId()%>&page=1"><%=product.getProductName()%>
                        </a></h3>
                       <div class="ratting">
                                <% int count = product.getRate();
                                    for (int i = 0; i < 5; i++) {
                                        if (count > 0) {%>
                                <i class="fa fa-star yellow"></i>
                                <%} else {%>
                                <i class="fa fa-star  "></i>
                                <%
                                    }
                                    count--;
                                %>

                                <%}%>
                            </div>
                        <h3 class="price">
                            <%=product.getPriceFormat()%> VND
                            <% if(product.getPriceReal() != 0) {%>
                            <span class="price-real"><%=product.getPriceRealFormat()%> VND</span>
                            <%}%>
                        </h3>
                    </div>
                </div>
            </div>

            <%} %>

        </div>

        <%List<Product> topPotteryProducts = ProductService.getInstance().getTopPotteryProducts();%>
        <div class="pottery featured-img-list">
            <% for(Product product: topPotteryProducts) {%>
            <div class="product">
                <div class="thumbnail">
                    <div class="cont-item ">
                        <a href="http://localhost:8080/detail-product?id=<%= product.getProductId()%>&page=1"><img
                                src="<%=product.getImageSrc()%>"
                                alt="">

                        </a>
                    </div>

                    <div class="caption">
                        <h3><a href="http://localhost:8080/detail-product?id=<%= product.getProductId()%>&page=1"> <%=product.getProductName()%></a></h3>
                        <div class="ratting">
                            <% int count = product.getRate();
                                for (int i = 0; i < 5; i++) {
                                    if (count > 0) {%>
                            <i class="fa fa-star yellow"></i>
                            <%} else {%>
                            <i class="fa fa-star  "></i>
                            <%
                                }
                                count--;
                            %>

                            <%}%>
                        </div>
                        <h3 class="price">
                            <%=product.getPriceFormat()%> VND
                            <% if(product.getPriceReal() != 0) {%>
                            <span class="price-real"><%=product.getPriceRealFormat()%> VND</span>
                            <% } %>
                        </h3>
                    </div>
                </div>
            </div>
            <% } %>
        </div>

        <%List<Product> topPaintingProducts = ProductService.getInstance().getTopWoodProducts();%>
        <div class="painting featured-img-list">
            <% for(Product product: topPaintingProducts) {%>
            <div class="product">
                <div class="thumbnail">
                    <div class="cont-item ">
                        <a href="http://localhost:8080/detail-product?id=<%= product.getProductId()%>&page=1"><img
                                src="<%=product.getImageSrc()%>"
                                alt="">

                        </a>
                    </div>

                    <div class="caption">
                        <h3><a href="http://localhost:8080/detail-product?id=<%= product.getProductId()%>&page=1"> <%=product.getProductName()%></a></h3>
                        <div class="ratting">
                            <% int count = product.getRate();
                                for (int i = 0; i < 5; i++) {
                                    if (count > 0) {%>
                            <i class="fa fa-star yellow"></i>
                            <%} else {%>
                            <i class="fa fa-star  "></i>
                            <%
                                }
                                count--;
                            %>

                            <%}%>
                        </div>
                        <h3 class="price">
                            <%=product.getPriceFormat()%> VND
                            <% if(product.getPriceReal() != 0) {%>
                            <span class="price-real"><%=product.getPriceRealFormat()%> VND</span>
                            <% } %>
                        </h3>
                    </div>
                </div>
            </div>
            <% } %>
        </div>
    </div>

</div>
<!-- Footer -->

<%@include file="footer.jsp" %>
<%@include file="scroll-to-top.jsp" %>

<%--<a href="#" class="scrolltotop"><i class="fa fa-arrow-up"></i></a>--%>


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
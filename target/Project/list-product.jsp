<%@ page import="java.util.List" %>
<%@ page import="bean.Product" %>
<%@ page import="services.ProductService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sản phẩm</title>
    <link rel="stylesheet" href="css/reset.css">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css">

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
          integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"/>

    <link rel="stylesheet" href="css/general.css">
    <link rel="stylesheet" href="css/list-product.css">
</head>

<body>
<%@include file="header.jsp" %>
<div class="address-book-background">
    <div class="container address-book-vs-sort">
        <div class="address-book">
            <span><a href="home-page.jsp">Trang chủ</a></span><span>|</span>
            <span><a href="list-product.jsp">Danh sách sản phẩm</a></span>
        </div>

        <div class="sort">
            <span>Sắp xếp</span>
        </div>
    </div>

</div>
<div class="container content">
    <div class="left">
        <div class="container-of-left ">
            <div class="row">
                <div class="row type-left">
                    <ul class="">
                        <li class="drivider"><a href="">Tất cả</a></li>
                        <li class="line"><a href="">|</a></li>
                        <li class="drivider"><a href="">Gỗ</a></li>
                        <li class="line"><a href="">|</a></li>
                        <li class="drivider"><a href="">Gốm</a></li>
                    </ul>
                </div>
            </div>
            <div class="row boder-line">
            </div>
            <div class="row type-item">
                <div class="state">
                    <ul>
                        <li class="item"><a href=""> Giảm giá</a></li>
                        <li class="item"><a href=""> Sản phẩm mới</a></li>
                        <li class="item"><a href=""> Bán chạy</a></li>
                    </ul>
                </div>
            </div>
            <div class="row boder-line"></div>
            <div class="row type-group">
                <div class="group">
                    <h3>Nhóm sản phẩm</h3>
                    <ul>
                        <li class="item"><a href=""> Phòng khách</a></li>
                        <li class="item"><a href=""> Nhà bếp</a></li>
                        <li class="item"><a href=""> Phong thủy</a></li>
                        <li class="item"><a href=""> Phòng ngủ</a></li>
                        <li class="item"><a href=""> Giải trí</a></li>
                        <li class="item"><a href=""> Trang trí tường</a></li>
                        <!-- <li class="item"> <a href=""> chăm sóc tóc</a></li> -->
                    </ul>
                </div>
            </div>
        </div>

    </div>

    <div class="right">
        <!-- slider -->
        <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
            <ol class="carousel-indicators">
                <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <a href=""><img class="d-block w-100" src="images/list-product/cms-banner.jpg"
                                    alt="First slide"></a>
                </div>
                <div class="carousel-item">
                    <a href=""> <img class="d-block w-100" src="images/list-product/BIOPHILIA_10.jpg"
                                     alt="Second slide"></a>
                </div>
                <div class="carousel-item">
                    <a href=""><img class="d-block w-100 "
                                    src="https://i.etsystatic.com/15645889/r/il/12a570/1253369484/il_794xN.1253369484_12vn.jpg"
                                    alt="Third slide"></a>
                </div>
            </div>
            <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
        <!-- list product -->
        <div class="list-product">
            <div class="row">

                <%
                    List<Product> list = (List<Product>) request.getAttribute("list");
                    for (Product product : list) {
                %>
                <div class="col-4">
                    <div class="thumbnail">
                        <div class="cont-item ">
                            <a href="http://localhost:8080/detail-product?id=<%= product.getProductId()%>"><img
                                    src="<%= product.getImageSrc()%>" alt="">
                            </a>
                        </div>
                        <div class="button">
                            <a href="http://localhost:8080/detail-product?id=<%= product.getProductId()%>"
                               class="buy-now"> Mua ngay</a>
                            <a href="" class="wish-list "><i class="fa-solid fa-cart-plus"></i></a>
                        </div>
                        <div class="caption">
                            <h3><a href=""><%= product.getProductName()%> </a></h3>
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
                                <%= product.getPrice()%> VNĐ
                                <span class="price-real"><%= product.getPriceReal()%> VND</span>
                            </h3>
                        </div>
                    </div>
                </div>
                <% }%>

            </div>
        </div>
        <!-- pagination -->
        <nav aria-label="Page navigation example" class="pagination-page">
            <ul class="pagination">
                <li class="page-item">
                    <a class="page-link" href="http://localhost:8080/listProduct?kind=<%= request.getAttribute("kind")%>&page=<%=Integer.parseInt(request.getAttribute("page").toString())-1%>" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                        <span class="sr-only">Previous</span>
                    </a>
                </li>
                <% int count = ProductService.getInstance().getcountProduct(request.getAttribute("kind").toString())/15;


                for(int i =0; i<count;i++) {
                %>
                <li class="page-item "><a class="page-link" href="http://localhost:8080/listProduct?kind=<%= request.getAttribute("kind")%>&page=<%=i+1%>"><%=i+1%></a></li>
                <%}%>
                 <li class="page-item">
                    <a class="page-link" href="http://localhost:8080/listProduct?kind=<%= request.getAttribute("kind")%>&page=<%=Integer.parseInt(request.getAttribute("page").toString())+1%>" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                        <span class="sr-only">Next</span>
                    </a>
                </li>
            </ul>
        </nav>
    </div>

</div>


<%@include file="footer.jsp" %>
<%@include file="scroll-to-top.jsp" %>

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
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"
        integrity="sha512-aVKKRRi/Q/YV+4mjoKBsE4x3H+BkegoM/em46NNlCqNTmUYADjBbeNefNxYV7giUp0VxICtqdrbqU7iVaeZNXA=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script src="js/general.js"></script>
<script src="js/list-product.js"></script>
</body>

</html>
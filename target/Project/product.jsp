<%@ page import="java.util.List" %>

<%@ page import="bean.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
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
    <link rel="stylesheet" href="css/product.css">
</head>

<body>

<%Product product = (Product) request.getAttribute("product");%>
<%@include file="header.jsp" %>
<div class="address-book-background">
    <div class="container address-book-vs-sort">
        <div class="address-book">
            <span><a href="/homepage">Trang chủ</a></span><span>|</span>
            <span><a
                    href="http://localhost:8080/listProduct?kind=0"><%=product.getCategory().getPaCategory().getName()%></a></span><span>|</span>
            <span><a
                    href="http://localhost:8080/listProduct?kind=0"><%=product.getCategory().getName()%></a></span><span>|</span>
            <span><a href="#"><%=product.getName()%></a></span>
        </div>
    </div>

</div>

<div class="container infomation-product bd-bottom">
    <div class="row">
        <div class="col-sm left">
            <div class="slider-show-img">
                <%List<Image> listImg = product.getListImage();%>
                <%for (Image image : listImg) {%>
                <div><img src="<%=image.getSource()%>" alt=""></div>
                <%}%>
            </div>
            <div class="slider-img">
                <%for (Image image : listImg) {%>
                <div class="image"><img src="<%=image.getSource()%>" alt=""></div>
                <%}%>
            </div>
        </div>
        <div class="col-sm right">
            <div class="top bd-bottom">
                <h3 class="name-product uppercase"><%=product.getName()%>
                </h3>
                <div class="cost">
                    <%if (product.getPriceSale() != 0) {%>
                    <span class="price uppercase"><%=Format.format(product.getPrice())%> VND</span>
                    <span class="sale uppercase"><%=Format.format(product.getPriceSale())%> VND</span>
                    <%} else {%>
                    <span class="sale uppercase"><%=Format.format(product.getPrice())%> VND</span>
                    <%}%>
                </div>
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
            </div>
            <div class="bottom">
                <h5 class="text uppercase">số lượng</h5>
                <input type="number" id="quantity" class="input" name="quantity" min="1" max="20" placeholder=" "
                       value="1">
                <button class="btn-add-cart uppercase submit" value="<%=product.getId()%>">thêm vào giỏ hàng
                </button>
                <button class="btn-buy uppercase submit">thanh toán</button>
            </div>

        </div>
    </div>
    <div class="row">
        <div class="col-sm rate">
            <h3 class="uppercase">Đánh giá sản phẩm</h3>
            <div class="ratting bd-bottom">
                <span><%=product.getRate()%>/5</span>
                <% count = product.getRate();
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
            <ul class="list-comment"></ul>
            <nav aria-label="Page navigation example">

                <ul class="pagination">
                    <li class="page-item">
                        <button class="page-link previous" aria-label="Previous">
                            <span aria-hidden="true"><i class="fa-solid fa-angle-left"></i></span>
                            <span class="sr-only">Previous</span>
                        </button>
                    </li>
                    <%
                        for (int i = 1; i <= (int) request.getAttribute("countPage"); i++) {
                            String active = "active";
                    %>
                    <li class="page-item <%if(i==1){%><%=active%><%}%>">
                        <button class="page-link"><%=i%>
                        </button>
                    </li>
                    <%}%>
                    <li class="page-item">
                        <button class="page-link next" aria-label="Next">
                            <span aria-hidden="true"><i class="fa-solid fa-angle-right"></i></span>
                            <span class="sr-only">Next</span>
                        </button>
                    </li>
                </ul>
            </nav>
            <div class="write-ratting">
                <h5 class="lb-cmt uppercase">đánh giá của bạn</h5>
                <div class="ratting">
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                </div>
                <textarea class="write-cmt input" name="" id="" cols="30" rows="10"></textarea>
                <button id="submit-cmt" class="uppercase submit">Đăng bình luận</button>
            </div>
        </div>
        <div class="col-sm detail-product">
            <div id="accordion">
                <div class="card bd-bottom">
                    <div class="card-header bd-bottom" id="headingOne">
                        <h5 class="mb-0">
                            <button class="collapsed uppercase" data-toggle="collapse" data-target="#collapseOne"
                                    aria-expanded="true" aria-controls="collapseOne">
                                Thông tin chi tiết
                            </button>
                        </h5>
                    </div>

                    <div id="collapseOne" class="collapse" aria-labelledby="headingOne" data-parent="#accordion">
                        <p class="card-body">
                            <%=product.getDetail()%>
                        </p>
                    </div>
                </div>
                <div class="card bd-bottom">
                    <div class="card-header bd-bottom" id="headingTwo">
                        <h5 class="mb-0">
                            <button class="collapsed uppercase" data-toggle="collapse" data-target="#collapseTwo"
                                    aria-expanded="false" aria-controls="collapseTwo">
                                Mô tả sản phẩm
                            </button>
                        </h5>
                    </div>
                    <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordion">
                        <p class="card-body">
                            <%=product.getDescription()%>
                        </p>
                    </div>
                </div>
                <div class="card bd-bottom">
                    <div class="card-header bd-bottom" id="headingThree">
                        <h5 class="mb-0">
                            <button class="collapsed uppercase" data-toggle="collapse" data-target="#collapseThree"
                                    aria-expanded="false" aria-controls="collapseThree">
                                Chi tiết đổi trả
                            </button>
                        </h5>
                    </div>
                    <div id="collapseThree" class="collapse" aria-labelledby="headingThree"
                         data-parent="#accordion">
                        <div class="card-body">
                            Thông tin chi tiết đổi trả sản phẩm
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<%--<div class="container similar-product">--%>
<%--    <div class="title-similar-product uppercase">--%>
<%--        <h3>Sản phẩm tương tự</h3>--%>
<%--    </div>--%>
<%--    <div class="slider-similar-product">--%>
<%--        <%for (Product productItem : (List<Product>) request.getAttribute("listSameProduct")) {%>--%>
<%--        <div class="product">--%>
<%--            <div class="thumbnail">--%>
<%--                <div class="cont-item ">--%>
<%--                    <a href="http://localhost:8080/detail-product?id=<%=productItem.getId()%>"><img--%>
<%--                            src="<%=productItem.getMainImage().getSource()%>"--%>
<%--                            alt="">--%>
<%--                    </a>--%>
<%--                </div>--%>

<%--                <div class="caption">--%>
<%--                    <h3>--%>
<%--                        <a href="http://localhost:8080/detail-product?id=<%=productItem.getId()%>"><%=productItem.getName()%>--%>
<%--                        </a></h3>--%>
<%--                    <div class="ratting">--%>
<%--                        <% count = productItem.getRate();--%>
<%--                            for (int i = 0; i < 5; i++) {--%>
<%--                                if (count > 0) {%>--%>
<%--                        <i class="fa fa-star yellow"></i>--%>
<%--                        <%} else {%>--%>
<%--                        <i class="fa fa-star  "></i>--%>
<%--                        <%--%>
<%--                            }--%>
<%--                            count--;--%>
<%--                        %>--%>
<%--                        <%}%>--%>
<%--                    </div>--%>
<%--                    <h3 class="price">--%>
<%--                        <%if (product.getPriceSale() != 0) {%>--%>
<%--                        <span class="price uppercase"><%=Format.format(product.getPrice())%> VND</span>--%>
<%--                        <span class="sale uppercase"><%=Format.format(product.getPriceSale())%> VND</span>--%>
<%--                        <%} else {%>--%>
<%--                        <span class="sale uppercase"><%=Format.format(product.getPrice())%> VND</span>--%>
<%--                        <%}%>--%>

<%--&lt;%&ndash;                        <%=Format.format(productItem.getPrice())%> VND&ndash;%&gt;--%>
<%--&lt;%&ndash;                        <%if (productItem.getPriceReal() != 0) {%>&ndash;%&gt;--%>
<%--&lt;%&ndash;                        <span class="price-real"><%=Format.format(productItem.getPriceReal())%> VND</span>&ndash;%&gt;--%>
<%--&lt;%&ndash;                        <%}%>&ndash;%&gt;--%>
<%--                    </h3>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <%}%>--%>

<%--    </div>--%>
<%--</div>--%>

<%@include file="footer.jsp" %>
<%@include file="scroll-to-top.jsp" %>


<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script type="text/javascript" src="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
        integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js"
        integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+"
        crossorigin="anonymous"></script>
<script src="js/general.js"></script>
<script src="js/product.js"></script>
</body>

</html>
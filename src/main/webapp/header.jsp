<%@ page import="services.ProductService" %>
<%@ page import="java.util.List" %>
<%@ page import="bean.Product" %>
<%@ page import="services.ProductService" %>
<%@ page import="bean.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<ul class="nav nav-page">
    <li class=" left">
        <a href="/homepage"><img src="images/logo/logo-rmbg1.png" alt=""></a>
    </li>
    <% int kind = (Integer) request.getAttribute("kind");%>

    <li class="nav-item center" id="nav-items">

        <a class="nav-link" id="sanpham"
           href="http://localhost:8080/listProduct?kind=<%=ProductService.ALL%>&group=0&page=1&sort=0">Sản Phẩm</a>
        <a class="nav-link" id="go"
           href="http://localhost:8080/listProduct?kind=<%=ProductService.WOOD%>&group=0&page=1&sort=0">Gỗ</a>
        <a class="nav-link" id="gom"
           href="http://localhost:8080/listProduct?kind=<%=ProductService.CERAMIC%>&group=0&page=1&sort=0">Gốm</a>
        <a class="nav-link"
           href="http://localhost:8080/listProduct?kind=<%=ProductService.PAINT%>&group=0&page=1&sort=0">Tranh</a>
        <a class="nav-link"
           href="http://localhost:8080/listProduct?kind=<%=ProductService.SALE%>&group=0&page=1&sort=0">giảm giá</a>

    </li>
    <li class=" right">
        <div class="item-right search-item">

            <input type="text" class="search-input" placeholder="Tìm kiếm..." name="txName" value=""/>
            <span class="icon" id="search">
                    <i class=" fa fa-search" name="action"></i></a>
            </span>
        </div>

        <% User user = (User) session.getAttribute("auth");
            if (user != null) {%>
        <a href="/user-profile.jsp" class="item-right">
            <img src="<%=user.getAvatar()%>" alt="">
            <p><%=user.getFullName()%>
            </p></a>
        <%} else {%>
        <a href="login.jsp" class="item-right">
            <i class="fa-solid fa-user"></i>
            <p>Đăng nhập</p></a>
        <%}%>

        <a href="cart.jsp" class="item-right"><i class="fa-solid fa-cart-shopping"></i>
            <p>Giỏ hàng (<span class="amount-product">2</span>)</p>
        </a>
    </li>
</ul>

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
        <% int kind = (Integer)request.getAttribute("kind");
            String active = "ative";%>

    <li class="nav-item center" id="nav-items">

<<<<<<< HEAD
        <a class="nav-link" id="sanpham" href="http://localhost:8080/listProduct?kind=<%=ProductService.ALL%>&page=1&sort=0">Sản Phẩm</a>
        <a class="nav-link" id="go" href="http://localhost:8080/listProduct?kind=<%=ProductService.WOOD%>&page=1&sort=0">Gỗ</a>
        <a class="nav-link" id="gom" href="http://localhost:8080/listProduct?kind=<%=ProductService.CERAMIC%>&page=1&sort=0">Gốm</a>
        <a class="nav-link" href="list-product.jsp">giảm giá</a>
        <a class="nav-link" href="list-product.jsp">Bán Chạy</a>
=======
        <a class="nav-link" id="sanpham" href="http://localhost:8080/listProduct?kind=<%=ProductService.ALL%>&group=0&page=1&sort=0">Sản Phẩm</a>
        <a class="nav-link" id="go" href="http://localhost:8080/listProduct?kind=<%=ProductService.WOOD%>&group=0&page=1&sort=0">Gỗ</a>
        <a class="nav-link" id="gom" href="http://localhost:8080/listProduct?kind=<%=ProductService.RECAMIC%>&group=0&page=1&sort=0">Gốm</a>
        <a class="nav-link" href="http://localhost:8080/listProduct?kind=<%=ProductService.PAINT%>&group=0&page=1&sort=price">Tranh</a>
        <a class="nav-link" href="http://localhost:8080/listProduct?kind=<%=ProductService.SALE%>&group=0&page=1&sort=a-z">Giảm giá</a>
>>>>>>> d4ee894f2cced0c860fc7a9b639f7e6af6275220

    </li>
    <li class=" right">
        <div class="item-right search-item">
            <input type="text" id="search" placeholder="Tìm kiếm..." />
            <span class="icon"><i class="fa fa-search"></i></span>

        </div>
        <a href="login.jsp" class="item-right">
            <%   User user = (User) session.getAttribute("auth");
                if(user!=null){%>
            <img src="<%=user.getAvatar()%>" alt="">
            <p><%=user.getFullName()%></p>
            <%} else {%>
            <i class="fa-solid fa-user"></i>
            <p>Đăng nhập</p>
            <%}%>
        </a>
        <a href="cart.jsp" class="item-right"><i class="fa-solid fa-cart-shopping"></i>
            <p>Giỏ hàng (2)</p>
        </a>
    </li>
</ul>

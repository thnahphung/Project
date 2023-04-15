<%@ page import="services.ProductService" %>
<%@ page import="java.util.List" %>
<%@ page import="bean.Product" %>
<%@ page import="services.ProductService" %>
<%@ page import="bean.User" %>
<%@ page import="bean.Order" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<ul class="nav nav-page">
    <li class=" left">
        <a href="/homepage"><img src="images/logo/logo-rmbg1.png" alt=""></a>
    </li>
    <%-- <% int kind=(Integer) request.getAttribute("kind");--%>
    <%-- %>--%>

    <li class="nav-item center" id="nav-items">

        <a class="nav-link  " id="sanpham"
           href="http://localhost:8080/listProduct?kind=<%=ProductService.ALL%>">Sản
            Phẩm</a>
        <a class="nav-link  " id="go"
           href="http://localhost:8080/listProduct?kind=<%=ProductService.WOOD%>">Gỗ</a>
        <a class="nav-link  " id="gom"
           href="http://localhost:8080/listProduct?kind=<%=ProductService.CERAMIC%>">Gốm</a>
        <a class="nav-link "
           href="http://localhost:8080/listProduct?kind=<%=ProductService.PAINT%>">Tranh</a>
        <a class="nav-link  "
           href="http://localhost:8080/listProduct?kind=<%=ProductService.SALE%>">giảm
            giá</a>

    </li>
    <li class=" right">
        <div class="item-right search-item">

            <input type="text" class="search-input" placeholder="Tìm kiếm..."
                   name="txName" value=""/>
            <span class="icon" id="search">
                <i class=" fa fa-search" name="action"></i>
            </span>
        </div>


        <% User user = (User) session.getAttribute("auth");
            // TODO: 4/14/2023     List<LineItem> cartItems = user.getListCartItem();%>
        <a href="/cart" class="item-right"><i
                class="fa-solid fa-cart-shopping"></i>
<%--                        <%if (cartItems != null) {%>--%>
<%--            <p>Giỏ hàng (<span class="amount-product"><%=Cart.sumQuantity(cartItems)%></span>)</p>--%>
<%--                        <%}--%>
<%--                        else {%>--%>
<%--                        <p>Giỏ hàng (<span class="amount-product">0</span>)</p>--%>
<%--                        <%}%>--%>
        </a>
        <% if (user != null) {%>
        <a href="/userProfile" class="item-right">
            <img src="<%=user.getAvatar()%>" alt="">
        </a>
        <%} else {%>
        <a href="http://localhost:8080/doLogin" class="item-right">
            <i class="fa-solid fa-user"></i>
            <p>Đăng nhập</p>
        </a>
        <%}%>


    </li>
</ul>
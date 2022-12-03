<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<ul class="nav nav-page">
    <li class=" left">
        <a href="home-page.jsp"><img src="images/logo/logo-rmbg1.png" alt=""></a>
    </li>
    <li class="nav-item center">
        <a class="nav-link active" href="http://localhost:8080/listProduct?kind=all">Sản Phẩm</a>
        <a class="nav-link" href="http://localhost:8080/listProduct?kind=wood">Gỗ</a>
        <a class="nav-link" href="list-product.jsp">Gốm</a>
        <a class="nav-link" href="list-product.jsp">giảm giá</a>
        <a class="nav-link" href="list-product.jsp">Bán Chạy</a>
    </li>
    <li class=" right">
        <div class="item-right search-item">
            <input type="text" id="search" placeholder="Tìm kiếm..." />
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

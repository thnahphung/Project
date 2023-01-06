<%@ page import="bean.User" %><%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 26/11/2022
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<div class="header-top">
    <%String name = request.getAttribute("name").toString();%>
    <h3 class="title"><%=name%></h3>
    <div class="right">
        <div class="search item">
            <input type="text" id="search" placeholder="Search..."/>
            <span class="icon"><i class="fa fa-search"></i></span>
        </div>
        <div class="notifi ">
            <div class="item notifi-item">
                <i class="fa-solid fa-bell"></i>
                <p>thông báo</p>
                <p style="color: red;">(1)</p>
            </div>
            <div class="notifi-table">
                <a href="">Có một cái gì đó mới </a>
                <a href="">Ai đó đã mua hàng</a>
                <a href="">Có một thành viên mới</a>
                <a href="">Có một thành viên mới</a>

            </div>
        </div>
        <div class="user item">
            <%
                User user = (User) session.getAttribute("authAdmin");
            %>
            <a class="item-right"> <img class="user-avatar" src="<%=user.getAvatar()%>" alt="<%=user.getFullName()%>">

            </a>


        </div>


    </div>
</div>
<div class="header-left">
    <img src="images/logo/logo-rmbg1.png" alt="">
    <ul>

        <li><a class="nav-item" href="/orderManager">Quản lý đơn hàng</a></li>
        <li><a class="nav-item" href="/ProductManager">Quản lý sản phẩm</a></li>
        <li><a class="nav-item" href="/userManager">Quản lý tài khoản</a></li>
        <li><a class="nav-item" href="/generalManager">Quản lý chung</a></li>
        <li><a class="nav-item" href="/doLogin" id="logout">Đăng xuất</a></li>
    </ul>
</div>


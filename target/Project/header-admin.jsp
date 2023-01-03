<%@ page import="bean.User" %><%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 26/11/2022
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<div class="header-top">
    <h3 class="title">Quản lý sản phẩm</h3>
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
            <a class="item-right"> <img class="user-avatar" src="<%=user.getAvatar()%>" alt="">
                <p><%=user.getFullName()%>
                </p>
            </a>


        </div>


    </div>
</div>
<div class="header-left">
    <img src="images/logo/logo-rmbg1.png" alt="">
    <ul>

        <li><a href="/orderManager">Bản điều khiển</a></li>
        <li><a href="/ProductManager">Quản lý sản phẩm</a></li>
        <li><a href="/userManager">Quản lý khách hàng</a></li>
        <li><a href="">Quản lý tài khoản</a></li>
        <li><a href="/doLogin" id="logout">Đăng xuất</a></li>
    </ul>
</div>
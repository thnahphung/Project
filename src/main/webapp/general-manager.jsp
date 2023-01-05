<%@ page import="java.util.List" %>
<%@ page import="bean.Order" %>
<%@ page import="bean.Banner" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin</title>
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/jquery.dataTables.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css">
    <link rel="stylesheet" href="https://mdbootstrap.com/docs/b4/jquery/getting-started/cdn/">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
          integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"/>

    <link rel="stylesheet" href="css/admin.css">
    <link rel="stylesheet" href="css/general-manager.css">
</head>

<body>
<%@include file="header-admin.jsp" %>
<div class="content">
    <div class="table-wrapper-scroll-y my-custom-scrollbar table-banner">
        <h3>Quản lý quản cáo</h3>
        <p>                    </p>
        <table class="table table-bordered table-striped mb-0">
            <thead>
            <tr>
                <th>mã quản cáo</th>
                <th>Tên quản cáo</th>
                <th>Hình ảnh</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <%
                List<Banner> bannerList = (List<Banner>) request.getAttribute("listBanner");
                for (Banner banner : bannerList) {
            %>
            <tr>
                <td><%=banner.getId()%>
                </td>
                <td><%=banner.getName()%>
                </td>
                <td><img src="<%=banner.getImage_src()%>" alt="" style="width: 200px; height: 100px"></td>
                <td><button type="button" class="btn btn-indigo btn-sm m-0">Sữa</button> <button type="button" class="btn btn-indigo btn-sm m-0">Xóa</button></td>
            </tr>
            <%}%>

            </tbody>
        </table>

    </div>

</div>


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
<!-- <script src="js/general.js"></script> -->
<script src="js/jquery.dataTables.min.js"></script>
<script src="js/admin.js"></script>
</body>

</html>
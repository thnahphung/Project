<%@ page import="java.util.List" %>
<%@ page import="bean.Order" %>
<%@ page import="bean.Format" %>
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
</head>

<body>
<%@include file="header-admin.jsp" %>
<div class="content">
    <% List<Order> list = (List<Order>) request.getAttribute("orderList");%>
    <div class="row">
        <div class="col-sm">
            <div class="top">
                <div class="icon i-gray"><img src="" alt=""><i class="fa-solid fa-cash-register"></i></div>
                <div class="title-number">
                    <p class="title">Tổng doanh thu</p>
                    <p class="number"><%=Format.format((Integer) request.getAttribute("total"))%> VND</p>
                </div>
            </div>
            <div class="bottom">

                <p class="percent green">+55%</p>
                <p>so với hôm qua</p>

            </div>

        </div>
        <div class="col-sm">
            <div class="top">
                <div class="icon i-red"><img src="" alt=""><i class="fa-solid fa-user "></i></div>
                <div class="title-number">
                    <p class="title">Số lượng khách hàng</p>
                    <p class="number"><%=request.getAttribute("member")%> Người</p>
                </div>
            </div>
            <div class="bottom">

                <p class="percent red">-10%</p>
                <p>so với hôm qua</p>

            </div>

        </div>
        <div class="col-sm">
            <div class="top">
                <div class="icon i-green"><img src="" alt=""><i class="fa-solid fa-cart-shopping"></i></div>
                <div class="title-number">
                    <p class="title">Tổng số đơn hàng</p>
                    <p class="number"><%=list.size()%> Đơn</p>
                </div>
            </div>
            <div class="bottom">

                <p class="percent green">+25%</p>
                <p>so với hôm qua</p>

            </div>

        </div>
        <div class="col-sm">
            <div class="top">
                <div class="icon i-blue"><img src="" alt=""><i class="fa-solid fa-eye"></i></div>
                <div class="title-number">
                    <p class="title">Số lượt xem trang web</p>
                    <p class="number">720 lượt</p>
                </div>
            </div>
            <div class="bottom">

                <p class="percent red">-5%</p>
                <p>so với hôm qua</p>

            </div>

        </div>


    </div>
    <div class="table">
        <div class="table-cart">
            <h2>Lịch sử đơn hàng</h2>
            <table id="dtHorizontalVerticalExample" class="table table-striped table-bordered table-sm "
                   cellspacing="0" width="100%">
                <thead>
                <tr>
                    <th>Mã hóa đơn</th>
                    <th>Tên</th>
                    <th>Địa chỉ</th>
                    <th>Số điện thoại</th>
                    <th>Ngày tạo HĐ</th>
                    <th>Thành tiền</th>
                    <th>Trạng thái</th>
                    <th>Tình trạng</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <%

                    for (Order order : list) {
                %>
                <tr data-toggle="modal"
                    data-target="#exampleModalCenterEdit" >
                    <td class="order-id"><%=order.getId()%>
                    </td>
                    <td class="name"><%=order.getUser().getName()%>
                    </td>
                    <td><%=order.getInformation().getAddress().getDetail()%>
                        , <%=order.getInformation().getAddress().getDistrict()%>
                        , <%=order.getInformation().getAddress().getCity()%>
                    </td>
                    <td><%=order.getInformation().getPhone()%>
                    </td>
                    <td><%=order.getCreateDate()%>
                    </td>
                    <td><%=order.total()%>
                    </td>
                    <td><%=order.isPayment()   %>
                    </td>
                    <td><%=order.getStatusDelivery()%>
                    </td>
                    <td> <button class="detail-order submit" style="width: 130px" value="<%=order.getId()%>">Xem chi tiết</button></td>
                </tr>
                <%}%>

                </tbody>
            </table>

        </div>
    </div>
    <div class="modal fade" id="exampleModalCenterEdit" tabindex="-1" role="dialog"
         aria-labelledby="exampleModalCenterTitle" aria-hidden="true" style="width: 100%;">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title uppercase" id="Title">Chi tiết đơn hàng</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body form-detail">
                </div>
            </div>
        </div>
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
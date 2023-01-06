<%@ page import="services.OrderService" %>
<%@ page import="bean.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hồ sơ của tôi</title>
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css">

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
          integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <!-- <link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css" /> -->
    <link rel="stylesheet" href="css/general.css">
    <link rel="stylesheet" href="css/user-profile.css">
    <link rel="stylesheet" href="css/show-address.css">

</head>

<body>
<%
    List<Address> addressList = (List<Address>) request.getAttribute("addressList");

%>

<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<div id="container">
    <!-- header -->
    <%@include file="header.jsp" %>

    <!-- end header -->


    <div class="after-header">
        <!-- content -->

        <div id="content">
            <!-- Nav tabs -->
            <div id="title">
                <h1>Tài khoản của tôi</h1>
                <div class="border-h1"></div>
            </div>
            <div id="main">
                <ul class="nav nav-tabs" id="myTab" role="tablist">
                    <h3>Tài khoản</h3>
                    <li class="nav-item" role="presentation">

                        <button class="nav-link active" id="infor-tab" data-toggle="tab" data-target="#infor"
                                type="button" role="tab" aria-controls="home" aria-selected="true"><i
                                class="fa-solid fa-user"></i>Thông tin tài khoản
                        </button>
                    </li>
                    <li class="nav-item" role="presentation">
                        <button class="nav-link" id="address-tab" data-toggle="tab" data-target="#address" type="button"
                                role="tab" aria-controls="profile" aria-selected="false" value="<%=user.getUserId()%>">
                            <i class="fa-solid fa-location-dot"></i>Danh sách địa chỉ
                        </button>
                    </li>
                    <li class="nav-item" role="presentation">
                        <!-- <button class="nav-link" id="logout-tab" data-toggle="tab" data-target="#messages" type="button" role="tab" aria-controls="messages" aria-selected="false">Đăng xuất</button> -->
                        <a class="nav-link" href="home-page.jsp"><i class="fa-solid fa-right-from-bracket"></i>Đăng
                            xuất</a>
                    </li>

                </ul>

                <!-- Tab panes -->
                <div class="tab-content">
                    <div class="tab-pane" id="address" role="tabpanel" aria-labelledby="address-tab">
                        <div class="choose-address inf">
                            <h3>Địa chỉ</h3>

                            <%for (Address address : addressList) {%>
                            <div class="list-address<%=address.getAddressId()%>">
                                <div class="contain-address bd-bottom">
                                    <div class="contain-address<%=address.getAddressId()%> left">
                                        <p>
                                            <label><span class="name"><%=address.getName()%></span> <span
                                                    class="phone-number"><%=address.getPhoneNumber()%></span></label>
                                        </p>
                                        <div class="address">
                                            <%=address.formatAddress()%>
                                        </div>
                                    </div>
                                    <div class="contain-address right">
                                        <button class="btn-address edit-one button submit" id="edit-address"
                                                data-toggle="modal"
                                                data-target="#exampleEditAddress<%=address.getAddressId()%>">Sửa
                                        </button>
                                        <button class="btn-address delete-one button submit" id="delete-address"
                                                value="<%=address.getAddressId()%>">Xóa
                                        </button>
                                    </div>
                                </div>
                            </div>
                            <%}%>
                            <button type="button" class="btn-add-address button submit" data-toggle="modal"
                                    data-target="#exampleAddAddress">
                                Thêm địa chỉ mới
                            </button>
                            <button type="button" class="btn-delete-address button submit" data-toggle="modal-dele"
                                    data-target="#exampleModalCenter">
                                Xóa tất cả
                            </button>


                        </div>
                    </div>

                </div>
            </div>
        </div>
        <!-- end content -->

        <%--Modal edit address--%>
        <%for (Address address : addressList) {%>
        <div class="modal fade" id="exampleEditAddress<%=address.getAddressId()%>" tabindex="-1" role="dialog"
             aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title uppercase" id="exampleModalLongTitle">Sửa địa chỉ</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">

                        <div class="form-edit-address">
                            <input class="input" type="text" name="" id="input-edit-name<%=address.getAddressId()%>"
                                   placeholder="Họ tên" value="<%=address.getName()%>">
                            <input class="input" type="text" name="" id="input-edit-phone<%=address.getAddressId()%>"
                                   placeholder="Số điện thoại" value="<%=address.getPhoneNumber()%>">
                            <input class="input" type="text" name="" id="input-edit-detail<%=address.getAddressId()%>"
                                   placeholder="Số nhà, tên đường, thôn, ấp"
                                   value="<%=address.getAddressDetail().getDetail()%>">
                            <input class="input" type="text" name="" id="input-edit-district<%=address.getAddressId()%>"
                                   placeholder="Quận, huyện" value="<%=address.getAddressDetail().getDistrict()%>">
                            <input class="input" type="text" name="" id="input-edit-city<%=address.getAddressId()%>"
                                   placeholder="Tỉnh, thành phố" value="<%=address.getAddressDetail().getCity()%>">
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="button button-close submit" data-dismiss="modal">Hủy</button>
                        <button type="button" class="button button-save btn-save-address submit"
                                value="<%=address.getAddressId()%>">Lưu địa chỉ</button>
                    </div>
                </div>
            </div>
        </div>
        <%}%>
        <%--        end modal edit address--%>
        <!-- Modal add address-->
        <div class="modal fade" id="exampleAddAddress" tabindex="-1" role="dialog"
             aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title uppercase" id="exampleAddAddressTitle">Thêm địa chỉ mới</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="form-add-address">
                            <input class="input" type="text" name="" id="input-name" placeholder="Họ tên">
                            <input class="input" type="text" name="" id="input-number-phone" placeholder="Số điện thoại">
                            <input class="input" type="text" name="" id="input-detail" placeholder="Số nhà, tên đường, thôn, ấp">
                            <input class="input" type="text" name="" id="input-district" placeholder="Quận, huyện">
                            <input class="input" type="text" name="" id="input-city" placeholder="Thành phố">
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="button button-close submit" data-dismiss="modal">Hủy</button>
                        <button type="button" class="button button-save save-address btn-save submit">Lưu địa chỉ</button>
                    </div>
                </div>
            </div>
        </div>
        <%--end modal add address--%>
        <!-- footer -->

        <%@include file="footer.jsp" %>

        <!-- end footer -->
    </div>
</div>
<script type="text/javascript" src="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
        integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js"
        integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+"
        crossorigin="anonymous"></script>
<script src='https://cdn.jsdelivr.net/gh/vietblogdao/js/districts.min.js'></script>
<script src="js/general.js"></script>
<script src="js/show-address.js"></script>
</body>

</html>
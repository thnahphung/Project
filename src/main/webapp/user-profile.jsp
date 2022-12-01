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

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <!-- <link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css" /> -->
    <link rel="stylesheet" href="css/general.css">
    <link rel="stylesheet" href="css/user-profile.css">

</head>

<body>
    <div id="container">
        <!-- header -->
        <%@include file="header.jsp" %>
        <!-- end header -->



        <!-- content -->
        <div class="after-header">
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

                            <button class="nav-link active" id="infor-tab" data-toggle="tab" data-target="#infor" type="button" role="tab" aria-controls="home" aria-selected="true"><i class="fa-solid fa-user"></i>Thông tin tài khoản</button>
                        </li>
                        <li class="nav-item" role="presentation">
                            <button class="nav-link" id="address-tab" data-toggle="tab" data-target="#address" type="button" role="tab" aria-controls="profile" aria-selected="false"><i class="fa-solid fa-location-dot"></i>Danh sách địa chỉ</button>
                        </li>
                        <li class="nav-item" role="presentation">
                            <!-- <button class="nav-link" id="logout-tab" data-toggle="tab" data-target="#messages" type="button" role="tab" aria-controls="messages" aria-selected="false">Đăng xuất</button> -->
                            <a class="nav-link" href="home-page.jsp"><i class="fa-solid fa-right-from-bracket"></i>Đăng xuất</a>
                        </li>

                    </ul>

                    <!-- Tab panes -->
                    <div class="tab-content">
                        <div class="tab-pane active" id="infor" role="tabpanel" aria-labelledby="infor-tab">
                            <ul class="inf">
                                <h3>Thông tin tài khoản</h3>
                                <li>Phan Thị Quỳnh Như</li>
                                <li>0819541402</li>
                                <li>qinhuuuuu@gmail.com</li>

                            </ul>
                            <div class="order-list">
                                <table class="table">
                                    <h3>Danh sách đơn hàng</h3>
                                    <thead>
                                        <tr>
                                            <th scope="col">Mã đơn hàng</th>
                                            <th scope="col">Ngày đặt</th>
                                            <th scope="col">Thành tiền</th>
                                            <th scope="col">Trạng thái đơn hàng</th>
                                            <th scope="col">Vận chuyển</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <th scope="row">#215814</th>
                                            <td>22/11/2020</td>
                                            <td>573.000 VND</td>
                                            <td>Chưa thanh toán</td>
                                            <td>Đang giao</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">#215815</th>
                                            <td>3/10/2020</td>
                                            <td>900.000 VND</td>
                                            <td>Đã thanh toán</td>
                                            <td>Hoàn thành</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">#215816</th>
                                            <td>20/7/2020</td>
                                            <td>1.523.000 VND</td>
                                            <td>Đã thanh toán</td>
                                            <td>Hoàn thành</td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div class="tab-pane" id="address" role="tabpanel" aria-labelledby="address-tab">
                            <div class="choose-address">
                                <h6 class="title uppercase"><i class="fa-solid fa-location-dot"></i>Địa chỉ </h6>

                                <div class="list-address">
                                    <div class="contain-address bd-bottom">
                                        <p>
                                            <label for="test1"><span class="name">Quỳnh Như</span> <span
                                                    class="phone-number">0123456789</span></label>
                                        </p>
                                        <div class="address">
                                            Kí túc xá khu B đhqg, Đông Hòa, Dĩ An, Bình Dương.
                                        </div>
                                    </div>
                                    <div class="contain-address  bd-bottom">
                                        <p>
                                            <label for="test2"><span class="name">Thanh Phụng</span> 0123456789</label>
                                        </p>
                                        <div class="address">
                                            Kí túc xá khu B đhqg, Đông Hòa, Dĩ An, Bình Dương.
                                        </div>
                                    </div>
                                    <div class="contain-address">
                                        <p>

                                            <label for="test3"><span class="name">Bảo Đặng</span> 0123456789</label>
                                        </p>
                                        <div class="address">
                                            Kí túc xá khu B đhqg, Đông Hòa, Dĩ An, Bình Dương.
                                        </div>
                                    </div>
                                </div>
                                <button type="button" class="btn-add-address button submit" data-toggle="modal" data-target="#exampleModalCenter">
                                    Thêm địa chỉ mới
                                </button>
                                <button type="button" class="btn-delete-address button submit" data-toggle="modal-dele" data-target="#exampleModalCenter">
                                    Xóa tất cả
                                </button>

                                <!-- Modal -->
                                <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                                    <div class="modal-dialog modal-dialog-centered" role="document">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h5 class="modal-title uppercase" id="exampleModalLongTitle">Thêm địa chỉ mới</h5>
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                    <span aria-hidden="true">&times;</span>
                                                </button>
                                            </div>
                                            <div class="modal-body">
                                                <div class="form-add-address">
                                                    <input class="input" type="text" name="" id="input-name" placeholder="Họ tên">
                                                    <input class="input" type="text" name="" id="input-number-phone" placeholder="Số điện thoại">
                                                    <select class="select-address" name="calc_shipping_provinces" required="">
                                                        <option value="">Tỉnh / Thành phố</option>
                                                    </select>
                                                    <select class="select-address" name="calc_shipping_district" required="">
                                                        <option value="">Quận / Huyện</option>
                                                    </select>
                                                    <input class="billing_address_1" name="" type="hidden" value="">
                                                    <input class="billing_address_2" name="" type="hidden" value="">
                                                    <input class="input" type="text" name="" id="input-num-house" placeholder="Số nhà, tên đường">
                                                </div>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="button button-close submit" data-dismiss="modal">Hủy</button>
                                                <button type="button" class="button submit">Lưu địa chỉ</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
            <!-- end content -->



            <!-- footer -->

            <%@include file="footer.jsp" %>
            <%@include file="scroll-to-top.jsp" %>
            <!-- end footer -->
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <!-- <script type="text/javascript" src="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script> -->
    <!-- <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script> -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>
    <script src="js/general.js"></script>
    <script src="js/user-profile.js"></script>
</body>

</html>
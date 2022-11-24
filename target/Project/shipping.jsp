<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sản phẩm</title>
    <link rel="stylesheet" href="css/reset.css">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css">

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
        integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css" />

    <link rel="stylesheet" href="css/general.css">
    <link rel="stylesheet" href="css/shipping.css">
</head>

<body>
    <ul class="nav nav-page">
        <li class=" left"> <a href="home-page.jsp"><img src="images/logo/logo-rmbg1.png" alt=""></a>
        </li>
        <li class="nav-item center">
            <a class="nav-link active" href="list-product.jsp">Sản Phẩm</a>
            <a class="nav-link" href="list-product.jsp">Gỗ</a>
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

    <div class="container content">
        <div class="row">
            <div class="col-7 left">
                <h5 class="title uppercase">Thanh toán</h5>

                <div class="choose-address">
                    <h6 class="title uppercase"><i class="fa-solid fa-location-dot"></i>Địa chỉ </h6>

                    <div class="list-address">
                        <div class="contain-address bd-bottom">
                            <p>
                                <input type="radio" id="test1" name="address" checked>
                                <label for="test1"><span class="name">Quỳnh Như</span> <span
                                        class="phone-number">0123456789</span></label>
                            </p>
                            <div class="address">
                                Kí túc xá khu B đhqg, Đông Hòa, Dĩ An, Bình Dương.
                            </div>
                        </div>
                        <div class="contain-address  bd-bottom">
                            <p>
                                <input type="radio" id="test2" name="address">
                                <label for="test2"><span class="name">Thanh Phụng</span> 0123456789</label>
                            </p>
                            <div class="address">
                                Kí túc xá khu B đhqg, Đông Hòa, Dĩ An, Bình Dương.
                            </div>
                        </div>
                        <div class="contain-address">
                            <p>
                                <input type="radio" id="test3" name="address">
                                <label for="test3"><span class="name">Bảo Đặng</span> 0123456789</label>
                            </p>
                            <div class="address">
                                Kí túc xá khu B đhqg, Đông Hòa, Dĩ An, Bình Dương.
                            </div>
                        </div>
                    </div>
                    <button type="button" class="btn-add-address button submit" data-toggle="modal"
                        data-target="#exampleModalCenter">
                        Thêm địa chỉ mới
                    </button>

                    <!-- Modal -->
                    <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog"
                        aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
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
                                        <input class="input" type="text" name="" id="input-number-phone"
                                            placeholder="Số điện thoại">
                                        <select class="select-address" name="calc_shipping_provinces" required="">
                                            <option value="">Tỉnh / Thành phố</option>
                                        </select>
                                        <select class="select-address" name="calc_shipping_district" required="">
                                            <option value="">Quận / Huyện</option>
                                        </select>
                                        <input class="billing_address_1" name="" type="hidden" value="">
                                        <input class="billing_address_2" name="" type="hidden" value="">
                                        <input class="input" type="text" name="" id="input-num-house"
                                            placeholder="Số nhà, tên đường">
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="button button-close submit"
                                        data-dismiss="modal">Hủy</button>
                                    <button type="button" class="button submit">Lưu địa chỉ</button>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
                <div class="way-ship">
                    <h6 class="title uppercase"><i class="fa-solid fa-truck-fast"></i>Hình thức giao hàng </h6>
                    <div class="contain-way-ship">
                        <p class="bd-bottom">
                            <input type="radio" id="way1" name="way-ship" checked>
                            <label for="way1">
                                <span class="text">Giao hàng tiêu chuẩn (Từ 2-5 ngày)</span>
                                <span class="text fee">30.000 VND</span>
                            </label>
                        </p>
                        <p>
                            <input type="radio" id="way2" name="way-ship">
                            <label for="way2">
                                <span class="text">Giao hàng hỏa tốc (2 giờ)</span>
                                <span class="text fee">50.000 VND</span>
                            </label>
                        </p>
                    </div>
                </div>

                <div class="pay">
                    <h6 class="title uppercase"><i class="fa-regular fa-credit-card"></i>Hình thức thanh toán</h6>
                    <div class="contain-pay">
                        <p class="bd-bottom">
                            <input type="radio" id="pay1" name="pay" checked>
                            <label for="pay1">
                                <span class="text">Thanh toán trực tiếp khi giao hàng</span>
                            </label>
                        </p>
                        <p>
                            <input type="radio" id="pay2" name="pay">
                            <label for="pay2">
                                <span class="text">Giao hàng hỏa tốc (2 giờ)</span>
                                <span class="text fee">50.000 VND</span>
                            </label>
                        </p>
                    </div>
                </div>
            </div>
            <div class="col-5 bill p-0">
                <div class="contain-bill p-4">
                    <h5 class="title-bill uppercase">đơn hàng</h5>
                    <div class="top bd-bottom">
                        <div class="product-price row ">
                            <div class="col-8 name-product text ">Vintas Landforms - Low Top - Rain Drum</div>
                            <div class="col-4 amount text text-right">x 1</div>
                            <div class="col-8 text"></div>
                            <div class="col-4 price text text-right">720.000 VND</div>

                            <div class="col-8 name-product text">Vintas Landforms - Low Top - Rain Drum</div>
                            <div class="col-4 amount text text-right">x 1</div>
                            <div class="col-8 text"></div>
                            <div class="col-4 price text text-right">720.000 VND</div>

                            <div class="col-8 name-product text">Vintas Landforms - Low Top - Rain Drum</div>
                            <div class="col-4  text amount text-right">x 1</div>
                            <div class="col-8 text"></div>
                            <div class="col-4 price text text-right">720.000 VND</div>
                        </div>


                    </div>

                    <div class="mid bd-bottom">
                        <div class="total row">
                            <div class="col-8 name-product text">Tổng đơn hàng</div>
                            <div class="col-4  text text-right">3.000.000 VND</div>
                            <div class="col-8 text">Giảm</div>
                            <div class="col-4 price text text-right">300.000 VND</div>

                            <div class="col-8 name-product text">Phí vận chuyển</div>
                            <div class="col-4  text text-right">30.000 VND</div>
                            <div class="col-8 text">Phí thanh toán</div>
                            <div class="col-4 price text text-right">0 VND</div>
                        </div>



                    </div>

                    <div class="bottom">
                        <div class="row">
                            <div class="col-6 text uppercase">Tổng cộng</div>
                            <div class="col-6 text text-right">2.700.000 VND</div>
                        </div>
                        <button class="btn-total uppercase submit">Tiếp tục thanh toán</button>

                    </div>

                </div>
            </div>
        </div>
    </div>
    <footer class="footer row">
        <div class="col-1"></div>
        <div class="col-2">
            <img src="images/logo/logo2.png" alt="">
        </div>
        <div class="col-2">
            <div class="title">Sản phẩm</div>
            <div><a href="">Đồ gỗ</a></div>
            <div><a href="">Đồ gốm</a></div>
        </div>
        <div class="col-2">
            <div class="title">Về Craft</div>
            <div><a href="">Tuyển cộng tác viên</a></div>
            <div><a href="">Địa chỉ</a></div>
            <div><a href="">Thông tin thành lập</a></div>
            <div><a href="">Người thành lập</a></div>
        </div>
        <div class="col-2">
            <div class="title">Liên hệ</div>
            <div><a href="">Facebook</a></div>
            <div><a href="">Istagram</a></div>
            <div><a href="">Twiter</a></div>
        </div>
        <div class="col-2">
            <div class="title">Hỗ trợ</div>
            <div><a href="">Thông tin bảo hành</a></div>
            <div><a href="">Thông tin đổi trả</a></div>
            <div><a href="">Liên hệ nhân viên chăm sóc</a></div>
        </div>

        <div class="col-1"></div>
    </footer>
    <a href="#" class="scrolltotop"><i class="fa fa-arrow-up"></i></a>

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

    <script src="https://cdn.jsdelivr.net/gh/vietblogdao/js/districts.min.js"></script>
    <script src="js/shipping.js"></script>
    <script src="js/general.js"></script>
    <script src="js/list-product.js"></script>
</body>

</html>
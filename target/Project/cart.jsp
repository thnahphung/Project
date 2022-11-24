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

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css" />

    <link rel="stylesheet" href="css/general.css">
    <link rel="stylesheet" href="css/cart.css">
</head>

<body>
<ul class="nav nav-page">
    <li class=" left">
        <a href="home-page.jsp"><img src="images/logo/logo-rmbg1.png" alt=""></a>
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
        <div class="col-8 list-product">
            <h5 class="title uppercase">giỏ hàng</h5>
            <ul class="container-list-product">
                <li class="product bd-bottom pb-4 pt-4">
                    <div class="row">

                        <div class="col-3 p-0 left"> <img src="https://i.etsystatic.com/28083097/r/il/4d0be8/3478700194/il_794xN.3478700194_lwhz.jpg" alt=""></div>
                        <div class="col-6">
                            <div class="top">
                                <h5 class="product-name">Bình hoa tối giản</h5>
                                <div class="contain-price">
                                    <span>Giá:</span>
                                    <span class="price">466.000 VND</span>
                                    <!-- <span class="sale">820.000 VND</span> -->
                                </div>
                            </div>
                            <div class="bottom">
                                <div class="text">Số lượng</div>
                                <input type="number" id="quantity" class="input" name="quantity" min="1" max="20" placeholder=" ">
                            </div>

                        </div>
                        <div class="col-3 right">
                            <div class="top">
                                <div class="price">466.000 VND</div>
                                <div class="stocking">Còn hàng</div>
                            </div>
                            <div class="bottom">
                                <button class="btn-remove"><i class="fa-solid fa-trash"></i> Xóa</button>
                            </div>
                        </div>
                    </div>

                </li>
                <li class="product bd-bottom pb-4 pt-4">
                    <div class="row">

                        <div class="col-3 p-0 left"> <img src="https://i.etsystatic.com/19076644/r/il/549709/4240974539/il_794xN.4240974539_nji7.jpg" alt=""></div>
                        <div class="col-6">
                            <div class="top">
                                <h5 class="product-name">Tượng nấm bằng gỗ </h5>
                                <div class="contain-price">
                                    <span>Giá:</span>
                                    <span class="price">1.020.000 VND</span>
                                    <!-- <span class="sale">820.000 VND</span> -->
                                </div>
                            </div>
                            <div class="bottom">
                                <div class="text">Số lượng</div>
                                <input type="number" id="quantity" class="input" name="quantity" min="1" max="20" placeholder=" ">
                            </div>

                        </div>
                        <div class="col-3 right">
                            <div class="top">
                                <div class="price">1.020.000 VND</div>
                                <div class="stocking">Còn hàng</div>
                            </div>
                            <div class="bottom">
                                <button class="btn-remove"><i class="fa-solid fa-trash"></i> Xóa</button>
                            </div>
                        </div>
                    </div>

                </li>
                <li class="product bd-bottom pb-4 pt-4">
                    <div class="row">

                        <div class="col-3 p-0 left"> <img src="https://i.etsystatic.com/11707818/r/il/f87020/2047935892/il_794xN.2047935892_n5xr.jpg" alt=""></div>
                        <div class="col-6">
                            <div class="top">
                                <h5 class="product-name">Dụng cụ mở chai treo tường</h5>
                                <div class="contain-price">
                                    <span>Giá:</span>
                                    <span class="price">875.000 VND</span>
                                    <!-- <span class="sale">820.000 VND</span> -->
                                </div>
                            </div>
                            <div class="bottom">
                                <div class="text">Số lượng</div>
                                <input type="number" id="quantity" class="input" name="quantity" min="1" max="20" placeholder=" ">
                            </div>

                        </div>
                        <div class="col-3 right">
                            <div class="top">
                                <div class="price">875.000 VND</div>
                                <div class="stocking">Còn hàng</div>
                            </div>
                            <div class="bottom">
                                <button class="btn-remove"><i class="fa-solid fa-trash"></i> Xóa</button>
                            </div>
                        </div>
                    </div>

                </li>
                <li class="product bd-bottom pb-4 pt-4">
                    <div class="row">

                        <div class="col-3 p-0 left"> <img src="https://i.etsystatic.com/32000242/r/il/9cfdf7/3389038003/il_794xN.3389038003_42cu.jpg" alt=""></div>
                        <div class="col-6">
                            <div class="top">
                                <h5 class="product-name">Lót ly hình mèo</h5>
                                <div class="contain-price">
                                    <span>Giá:</span>
                                    <span class="price">338.000 VND</span>
                                    <!-- <span class="sale">820.000 VND</span> -->
                                </div>
                            </div>
                            <div class="bottom">
                                <div class="text">Số lượng</div>
                                <input type="number" id="quantity" class="input" name="quantity" min="1" max="20" placeholder=" ">
                            </div>

                        </div>
                        <div class="col-3 right">
                            <div class="top">
                                <div class="price">338.000 VND</div>
                                <div class="stocking">Còn hàng</div>
                            </div>
                            <div class="bottom">
                                <button class="btn-remove"><i class="fa-solid fa-trash"></i> Xóa</button>
                            </div>
                        </div>
                    </div>

                </li>
                <li class="product bd-bottom pb-4 pt-4">
                    <div class="row">

                        <div class="col-3 p-0 left"> <img src="https://i.etsystatic.com/9475846/r/il/36bde4/2220393418/il_794xN.2220393418_adja.jpg" alt=""></div>
                        <div class="col-6">
                            <div class="top">
                                <h5 class="product-name">Khay đựng trứng</h5>
                                <div class="contain-price">
                                    <span>Giá:</span>
                                    <span class="price">795.000 VND</span>
                                    <!-- <span class="sale">820.000 VND</span> -->
                                </div>
                            </div>
                            <div class="bottom">
                                <div class="text">Số lượng</div>
                                <input type="number" id="quantity" class="input" name="quantity" min="1" max="20" placeholder=" ">
                            </div>

                        </div>
                        <div class="col-3 right">
                            <div class="top">
                                <div class="price">795.000 VND</div>
                                <div class="stocking">Còn hàng</div>
                            </div>
                            <div class="bottom">
                                <button class="btn-remove"><i class="fa-solid fa-trash"></i> Xóa</button>
                            </div>
                        </div>
                    </div>

                </li>

            </ul>
            <div class="contain-btn">
                <button class="delete-all uppercase submit">Xóa tất cả</button>
                <button class="return uppercase submit">quay lại mua hàng</button>
            </div>
        </div>
        <div class="col-4 bill p-0">
            <div class="contain-bill p-4">
                <h5 class="title-bill uppercase">đơn hàng</h5>
                <div class="top">
                    <div class="text-bill uppercase">nhập mã khuyến mãi</div>
                    <div class="input-voucher bd-bottom pb-4">
                        <input class="input" type="text">
                        <button class="uppercase submit">áp dụng</button>
                    </div>
                </div>

                <div class="mid bd-bottom">
                    <div class="arow">
                        <span>Đơn hàng</span>
                        <span>3.000.000</span>
                    </div>
                    <div class="arow">
                        <span>Giảm</span>
                        <span>1.000.000</span>
                    </div>
                </div>

                <div class="bottom">
                    <div class="arow">
                        <span class="text uppercase">tạm tính</span>
                        <span class="total">2.000.000 VND</span>
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

<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script type="text/javascript" src="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js" integrity="sha512-aVKKRRi/Q/YV+4mjoKBsE4x3H+BkegoM/em46NNlCqNTmUYADjBbeNefNxYV7giUp0VxICtqdrbqU7iVaeZNXA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script src="js/general.js"></script>
<script src="js/list-product.js"></script>
</body>

</html>
<%@ page contentType="text/html; charsetUTF-8" language="java" pageEncoding="UTF-8" %> >
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
    <link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css" />

    <link rel="stylesheet" href="css/admin.css">
    <link rel="stylesheet" href="css/product-manager.css">
</head>

<body>
    <div class="header-top">
        <h3 class="title">Quản lý sản phẩm</h3>
        <div class="right">
            <div class="search item">
                <input type="text" id="search" placeholder="Search..." />
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
                <a href="login.jsp" class="item-right"> <img class="user-avatar" src="images/team-2.jpg" alt="">
                    <p>Thanh Phụng</p>
                </a>
            </div>



        </div>
    </div>
    <div class="header-left">
        <img src="images/logo/logo-rmbg1.png" alt="">
        <ul>
            <li><a href="admin.jsp">Bản điều khiển</a></li>
            <li><a href="product-manager.jsp">Quản lý sản phẩm</a></li>
            <li><a href="user-manager.jsp">Quản lý khách hàng</a></li>
            <li><a href="">Quản lý tài khoản</a></li>
            <li><a href="">Đăng xuất</a></li>

        </ul>
    </div>
    </div>
    <div class="header-left">
        <img src="images/logo/logo-rmbg1.png" alt="">
        <ul>
            <li><a href="admin.jsp">Bản điều khiển</a></li>
            <li><a href="product-manager.jsp">Quản lý sản phẩm</a></li>
            <li><a href="user-manager.jsp">Quản lý khách hàng</a></li>
            <li><a href="">Quản lý tài khoản</a></li>
            <li><a href="">Đăng xuất</a></li>

        </ul>
    </div>
    <div class="content">
        <div class="row">
            <div class="col-sm">
                <div class="top">
                    <div class="icon i-gray"><img src="" alt=""><i class="fa-solid fa-cash-register"></i></div>
                    <div class="title-number">
                        <p class="title">Tổng Sản phẩm</p>
                        <p class="number">100 sản phẩm</p>
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
                        <p class="title">Sản phẩm mới</p>
                        <p class="number">20 sản phẩm</p>
                    </div>
                </div>
                <div class="bottom">

                    <p class="percent red">-10%</p>
                    <p>so với tháng trước</p>

                </div>

            </div>
            <div class="col-sm">
                <div class="top">
                    <div class="icon i-green"><img src="" alt=""><i class="fa-solid fa-cart-shopping"></i></div>
                    <div class="title-number">
                        <p class="title">Sản phẩm hết hàng</p>
                        <p class="number">50 sản phẩm</p>
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
                        <p class="title">Số lượt đánh giá</p>
                        <p class="number">720.203 lượt</p>
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
                <h2>Danh sách sản phẩm</h2>
                <div class="right">
                    <button class="add">Thêm</button>
                    <button class="edit">Sửa</button>
                    <button class="delete">Xóa</button>
                </div>
                <table id="dtHorizontalVerticalExample" class="table table-striped table-bordered table-sm "
                    cellspacing="0" width="100%">
                    <thead>
                        <tr>
                            <th>Mã sản phẩm</th>
                            <th>Tên</th>
                            <th>Hình ảnh</th>
                            <th>Đánh Giá</th>
                            <th>Giá tiền</th>
                            <th>Giảm giá</th>
                            <th>Trạng thái</th>
                            <th>Thông tin chi tiết</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>SP0001</td>
                            <td>Con cú bằng gỗ</td>
                            <td>img</td>
                            <td>4</td>
                            <td>740.000 VND</td>
                            <td>650.000 VND</td>
                            <td>Còn</td>
                            <td>Hàng này là hàng chỉ có 1 trên đời mà thôi</td>
                        </tr>
                        <tr>
                            <td>SP0002</td>
                            <td>Tượng con chim ruồi bằng gỗ</td>
                            <td>img</td>
                            <td>5</td>
                            <td>740.000 VND</td>
                            <td>0 VND</td>
                            <td>hết</td>
                            <td>Hàng độc quyền từ nhà phân phối Crafts</td>
                        </tr>
                        <tr>
                            <td>SP0003</td>
                            <td>Tượng con chim ruồi bằng gỗ</td>
                            <td>img</td>
                            <td>5</td>
                            <td>740.000 VND</td>
                            <td>0 VND</td>
                            <td>hết</td>
                            <td>Hàng độc quyền từ nhà phân phối Crafts</td>
                        </tr>
                        <tr>
                            <td>SP0004</td>
                            <td>Tượng con chim ruồi bằng gỗ</td>
                            <td>img</td>
                            <td>0</td>
                            <td>740.000 VND</td>
                            <td>0 VND</td>
                            <td>hết</td>
                            <td>Hàng độc quyền từ nhà phân phối Crafts</td>
                        </tr>
                        <tr>
                            <td>SP0005</td>
                            <td>Tượng con chim ruồi bằng gỗ</td>
                            <td>img</td>
                            <td>5</td>
                            <td>740.000 VND</td>
                            <td>0 VND</td>
                            <td>hết</td>
                            <td>Hàng độc quyền từ nhà phân phối Crafts</td>
                        </tr>


                    </tbody>
                </table>




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
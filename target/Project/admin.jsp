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
    <div class="content">
        <div class="row">
            <div class="col-sm">
                <div class="top">
                    <div class="icon i-gray"><img src="" alt=""><i class="fa-solid fa-cash-register"></i></div>
                    <div class="title-number">
                        <p class="title">Tổng doanh thu</p>
                        <p class="number">124.342.234 VND</p>
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
                        <p class="title">Khách hàng mới</p>
                        <p class="number">324 Người</p>
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
                        <p class="title">Tổng tổng đơn hàng</p>
                        <p class="number">234 Đơn</p>
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
                <h2>Lịch sử đơn hàng</h2>
                <table id="dtHorizontalVerticalExample" class="table table-striped table-bordered table-sm "
                    cellspacing="0" width="100%">
                    <thead>
                        <tr>
                            <th>Mã hóa đơn</th>
                            <th>Tên</th>
                            <th>Địa chỉ</th>
                            <th>Số điện thoại</th>
                            <th>Email</th>
                            <th>Ngày tạo HĐ</th>
                            <th>Sản phẩm</th>
                            <th>Số lượng</th>
                            <th>Thành tiền</th>
                            <th>Trạng thái</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>HD0001</td>
                            <td>Dương Thanh Phụng</td>
                            <td>Đông Hòa, Dĩ An, Bình Dương</td>
                            <td>0938932040</td>
                            <td>20130010@st.hcmuaf.edu.vn</td>
                            <td>2011/04/25</td>
                            <td>Tượng gỗ con cú</td>
                            <td>1</td>
                            <td>2.320.800</td>
                            <td>GH thành công</td>
                        </tr>
                        <tr>
                            <td>HD0002</td>
                            <td>Dương Thanh Phụng</td>
                            <td>Đông Hòa, Dĩ An, Bình Dương</td>
                            <td>0938932040</td>
                            <td>20130010@st.hcmuaf.edu.vn</td>
                            <td>2011/04/25</td>
                            <td>Tượng gỗ con cú</td>
                            <td>1</td>
                            <td>2.320.800</td>
                            <td>GH thành công</td>
                        </tr>
                        <tr>
                            <td>HD0003</td>
                            <td>Dương Thanh Phụng</td>
                            <td>Đông Hòa, Dĩ An, Bình Dương</td>
                            <td>0938932040</td>
                            <td>20130010@st.hcmuaf.edu.vn</td>
                            <td>2011/04/25</td>
                            <td>Tượng gỗ con cú</td>
                            <td>1</td>
                            <td>2.320.800</td>
                            <td>GH thành công</td>
                        </tr>
                        <tr>
                            <td>HD0004</td>
                            <td>Dương Thanh Phụng</td>
                            <td>Đông Hòa, Dĩ An, Bình Dương</td>
                            <td>0938932040</td>
                            <td>20130010@st.hcmuaf.edu.vn</td>
                            <td>2011/04/25</td>
                            <td>Tượng gỗ con cú</td>
                            <td>1</td>
                            <td>2.320.800</td>
                            <td>GH thành công</td>
                        </tr>
                        <tr>
                            <td>HD0005</td>
                            <td>Dương Thanh Phụng</td>
                            <td>Đông Hòa, Dĩ An, Bình Dương</td>
                            <td>0938932040</td>
                            <td>20130010@st.hcmuaf.edu.vn</td>
                            <td>2011/04/25</td>
                            <td>Tượng gỗ con cú</td>
                            <td>1</td>
                            <td>2.320.800</td>
                            <td>GH thành công</td>
                        </tr>
                        <tr>
                            <td>HD0006</td>
                            <td>Dương Thanh Phụng</td>
                            <td>Đông Hòa, Dĩ An, Bình Dương</td>
                            <td>0938932040</td>
                            <td>20130010@st.hcmuaf.edu.vn</td>
                            <td>2011/04/25</td>
                            <td>Tượng gỗ con cú</td>
                            <td>1</td>
                            <td>2.320.800</td>
                            <td>GH thành công</td>
                        </tr>
                        <tr>
                            <td>HD0007</td>
                            <td>Dương Thanh Phụng</td>
                            <td>Đông Hòa, Dĩ An, Bình Dương</td>
                            <td>0938932040</td>
                            <td>20130010@st.hcmuaf.edu.vn</td>
                            <td>2011/04/25</td>
                            <td>Tượng gỗ con cú</td>
                            <td>1</td>
                            <td>2.320.800</td>
                            <td>GH thành công</td>
                        </tr>
                        <tr>
                            <td>HD0001</td>
                            <td>Dương Thanh Phụng</td>
                            <td>Đông Hòa, Dĩ An, Bình Dương</td>
                            <td>0938932040</td>
                            <td>20130010@st.hcmuaf.edu.vn</td>
                            <td>2011/04/25</td>
                            <td>Tượng gỗ con cú</td>
                            <td>1</td>
                            <td>2.320.800</td>
                            <td>GH thành công</td>
                        </tr>
                        <tr>
                            <td>HD0001</td>
                            <td>Dương Thanh Phụng</td>
                            <td>Đông Hòa, Dĩ An, Bình Dương</td>
                            <td>0938932040</td>
                            <td>20130010@st.hcmuaf.edu.vn</td>
                            <td>2011/04/25</td>
                            <td>Tượng gỗ con cú</td>
                            <td>1</td>
                            <td>2.320.800</td>
                            <td>GH thành công</td>
                        </tr>
                        <tr>
                            <td>HD0001</td>
                            <td>Dương Thanh Phụng</td>
                            <td>Đông Hòa, Dĩ An, Bình Dương</td>
                            <td>0938932040</td>
                            <td>20130010@st.hcmuaf.edu.vn</td>
                            <td>2011/04/25</td>
                            <td>Tượng gỗ con cú</td>
                            <td>1</td>
                            <td>2.320.800</td>
                            <td>GH thành công</td>
                        </tr>
                        <tr>
                            <td>HD0001</td>
                            <td>Dương Thanh Phụng</td>
                            <td>Đông Hòa, Dĩ An, Bình Dương</td>
                            <td>0938932040</td>
                            <td>20130010@st.hcmuaf.edu.vn</td>
                            <td>2011/04/25</td>
                            <td>Tượng gỗ con cú</td>
                            <td>1</td>
                            <td>2.320.800</td>
                            <td>GH thành công</td>
                        </tr>
                        <tr>
                            <td>HD0001</td>
                            <td>Dương Thanh Phụng</td>
                            <td>Đông Hòa, Dĩ An, Bình Dương</td>
                            <td>0938932040</td>
                            <td>20130010@st.hcmuaf.edu.vn</td>
                            <td>2011/04/25</td>
                            <td>Tượng gỗ con cú</td>
                            <td>1</td>
                            <td>2.320.800</td>
                            <td>GH thành công</td>
                        </tr>
                        <tr>
                            <td>HD0001</td>
                            <td>Dương Thanh Phụng</td>
                            <td>Đông Hòa, Dĩ An, Bình Dương</td>
                            <td>0938932040</td>
                            <td>20130010@st.hcmuaf.edu.vn</td>
                            <td>2011/04/25</td>
                            <td>Tượng gỗ con cú</td>
                            <td>1</td>
                            <td>2.320.800</td>
                            <td>GH thành công</td>
                        </tr>
                        <tr>
                            <td>HD0001</td>
                            <td>Dương Thanh Phụng</td>
                            <td>Đông Hòa, Dĩ An, Bình Dương</td>
                            <td>0938932040</td>
                            <td>20130010@st.hcmuaf.edu.vn</td>
                            <td>2011/04/25</td>
                            <td>Tượng gỗ con cú</td>
                            <td>1</td>
                            <td>2.320.800</td>
                            <td>GH thành công</td>
                        </tr>
                        <tr>
                            <td>HD0001</td>
                            <td>Dương Thanh Phụng</td>
                            <td>Đông Hòa, Dĩ An, Bình Dương</td>
                            <td>0938932040</td>
                            <td>20130010@st.hcmuaf.edu.vn</td>
                            <td>2011/04/25</td>
                            <td>Tượng gỗ con cú</td>
                            <td>1</td>
                            <td>2.320.800</td>
                            <td>GH thành công</td>
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
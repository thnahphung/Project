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
    <link rel="stylesheet" href="css/user-manager.css">
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
    <div class="card-body px-0 pb-2 content">
        <div class="table-responsive p-0">
            <table class="table align-items-center mb-0">
                <thead>
                    <tr>
                        <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Tên người dùng
                        </th>
                        <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">Cấp quyền
                        </th>
                        <th class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">
                            Trạng thái</th>
                        <th class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">
                            Ngày tạo tài khoản</th>
                        <th class="text-secondary opacity-7"></th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>
                            <div class="d-flex px-2 py-1">
                                <div>
                                    <img src="images/team-2.jpg" class="avatar avatar-sm me-3 border-radius-lg"
                                        alt="user1">
                                </div>
                                <div class="d-flex flex-column justify-content-center">
                                    <h6 class="mb-0 text-sm">Dương Thanh Phụng</h6>
                                    <p class="text-xs text-secondary mb-0">PhungThanhDuong@gmail.com</p>
                                </div>
                            </div>
                        </td>
                        <td>
                            <p class="text-xs font-weight-bold mb-0">Quản lý</p>
                            <p class="text-xs text-secondary mb-0">Quản lý trang web</p>
                        </td>
                        <td class="align-middle text-center text-sm">
                            <span class="badge badge-sm bg-gradient-success">Trực tuyến</span>
                        </td>
                        <td class="align-middle text-center">
                            <span class="text-secondary text-xs font-weight-bold">01/11/02</span>
                        </td>
                        <td class="align-middle">
                            <a href="javascript:;" class="text-secondary font-weight-bold text-xs" data-toggle="tooltip"
                                data-original-title="Edit user">
                                sửa
                            </a>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div class="d-flex px-2 py-1">
                                <div>
                                    <img src="images/team-2.jpg" class="avatar avatar-sm me-3 border-radius-lg"
                                        alt="user2">
                                </div>
                                <div class="d-flex flex-column justify-content-center">
                                    <h6 class="mb-0 text-sm">Phan Thị Quỳnh Như</h6>
                                    <p class="text-xs text-secondary mb-0">Nhuquynhphanthi@gmail.com</p>
                                </div>
                            </div>
                        </td>
                        <td>
                            <p class="text-xs font-weight-bold mb-0">Nhân viên</p>
                            <p class="text-xs text-secondary mb-0">Quản lý đơn hàng</p>
                        </td>
                        <td class="align-middle text-center text-sm">
                            <span class="badge badge-sm bg-gradient-secondary">Ngoại tuyến</span>
                        </td>
                        <td class="align-middle text-center">
                            <span class="text-secondary text-xs font-weight-bold">11/11/02</span>
                        </td>
                        <td class="align-middle">
                            <a href="javascript:;" class="text-secondary font-weight-bold text-xs" data-toggle="tooltip"
                                data-original-title="Edit user">
                                sửa
                            </a>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div class="d-flex px-2 py-1">
                                <div>
                                    <img src="images/team-2.jpg" class="avatar avatar-sm me-3 border-radius-lg"
                                        alt="user2">
                                </div>
                                <div class="d-flex flex-column justify-content-center">
                                    <h6 class="mb-0 text-sm">Lê Bảo Đặng</h6>
                                    <p class="text-xs text-secondary mb-0">Dangbaole@gmail.com</p>
                                </div>
                            </div>
                        </td>
                        <td>
                            <p class="text-xs font-weight-bold mb-0">Nhân viên</p>
                            <p class="text-xs text-secondary mb-0">Quản lý sản phẩm</p>
                        </td>
                        <td class="align-middle text-center text-sm">
                            <span class="badge badge-sm bg-gradient-secondary">Ngoại tuyến</span>
                        </td>
                        <td class="align-middle text-center">
                            <span class="text-secondary text-xs font-weight-bold">12/11/02</span>
                        </td>
                        <td class="align-middle">
                            <a href="javascript:;" class="text-secondary font-weight-bold text-xs" data-toggle="tooltip"
                                data-original-title="Edit user">
                                sửa
                            </a>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div class="d-flex px-2 py-1">
                                <div>
                                    <img src="images/team-2.jpg" class="avatar avatar-sm me-3 border-radius-lg"
                                        alt="user2">
                                </div>
                                <div class="d-flex flex-column justify-content-center">
                                    <h6 class="mb-0 text-sm">"Nguyễn Thị Xuân Hoa"</h6>
                                    <p class="text-xs text-secondary mb-0">Hoaxuanthinguyen@gmail.com</p>
                                </div>
                            </div>
                        </td>
                        <td>
                            <p class="text-xs font-weight-bold mb-0">khách hàng</p>
                            <p class="text-xs text-secondary mb-0">Bình thường</p>
                        </td>
                        <td class="align-middle text-center text-sm">
                            <span class="badge badge-sm bg-gradient-secondary">Trực tuyến</span>
                        </td>
                        <td class="align-middle text-center">
                            <span class="text-secondary text-xs font-weight-bold">13 /11/02</span>
                        </td>
                        <td class="align-middle">
                            <a href="javascript:;" class="text-secondary font-weight-bold text-xs" data-toggle="tooltip"
                                data-original-title="Edit user">
                                sửa
                            </a>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div class="d-flex px-2 py-1">
                                <div>
                                    <img src="images/team-2.jpg" class="avatar avatar-sm me-3 border-radius-lg"
                                        alt="user2">
                                </div>
                                <div class="d-flex flex-column justify-content-center">
                                    <h6 class="mb-0 text-sm">Phạm Gia Bảo</h6>
                                    <p class="text-xs text-secondary mb-0">Baogiapham@gmail.com</p>
                                </div>
                            </div>
                        </td>
                        <td>
                            <p class="text-xs font-weight-bold mb-0">khách hàng</p>
                            <p class="text-xs text-secondary mb-0">bình thường</p>
                        </td>
                        <td class="align-middle text-center text-sm">
                            <span class="badge badge-sm bg-gradient-secondary">Ngoại tuyến</span>
                        </td>
                        <td class="align-middle text-center">
                            <span class="text-secondary text-xs font-weight-bold">11/11/02</span>
                        </td>
                        <td class="align-middle">
                            <a href="javascript:;" class="text-secondary font-weight-bold text-xs" data-toggle="tooltip"
                                data-original-title="Edit user">
                                sửa
                            </a>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div class="d-flex px-2 py-1">
                                <div>
                                    <img src="images/team-2.jpg" class="avatar avatar-sm me-3 border-radius-lg"
                                        alt="user2">
                                </div>
                                <div class="d-flex flex-column justify-content-center">
                                    <h6 class="mb-0 text-sm">Hồ Thanh Hoài An</h6>
                                    <p class="text-xs text-secondary mb-0">Anhoaithanhho@gmail.com</p>
                                </div>
                            </div>
                        </td>
                        <td>
                            <p class="text-xs font-weight-bold mb-0">Khách hàng</p>
                            <p class="text-xs text-secondary mb-0">Bình thường</p>
                        </td>
                        <td class="align-middle text-center text-sm">
                            <span class="badge badge-sm bg-gradient-secondary">Ngoại tuyến</span>
                        </td>
                        <td class="align-middle text-center">
                            <span class="text-secondary text-xs font-weight-bold">13/11/02</span>
                        </td>
                        <td class="align-middle">
                            <a href="javascript:;" class="text-secondary font-weight-bold text-xs" data-toggle="tooltip"
                                data-original-title="Edit user">
                                sửa
                            </a>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div class="d-flex px-2 py-1">
                                <div>
                                    <img src="images/team-2.jpg" class="avatar avatar-sm me-3 border-radius-lg"
                                        alt="user2">
                                </div>
                                <div class="d-flex flex-column justify-content-center">
                                    <h6 class="mb-0 text-sm">Võ Khôi Nhơn</h6>
                                    <p class="text-xs text-secondary mb-0">Nhonkhoivo@gmail.com</p>
                                </div>
                            </div>
                        </td>
                        <td>
                            <p class="text-xs font-weight-bold mb-0">Khách hàng</p>
                            <p class="text-xs text-secondary mb-0">Bình thường</p>
                        </td>
                        <td class="align-middle text-center text-sm">
                            <span class="badge badge-sm bg-gradient-secondary">Trực tuyến</span>
                        </td>
                        <td class="align-middle text-center">
                            <span class="text-secondary text-xs font-weight-bold">11/11/02</span>
                        </td>
                        <td class="align-middle">
                            <a href="javascript:;" class="text-secondary font-weight-bold text-xs" data-toggle="tooltip"
                                data-original-title="Edit user">
                                sửa
                            </a>
                        </td>
                    </tr>



                </tbody>
            </table>
        </div>
    </div>



    </body>

</html>
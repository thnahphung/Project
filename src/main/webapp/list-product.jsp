<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %> >
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
    <link rel="stylesheet" href="css/list-product.css">
</head>

<body>
<%@include file="header.jsp"%>
<div class="address-book-background">
    <div class="container address-book-vs-sort">
        <div class="address-book">
            <span><a href="home-page.jsp">Trang chủ</a></span><span>|</span>
            <span><a href="list-product.jsp">Danh sách sản phẩm</a></span>
        </div>

        <div class="sort">
            <span>Sắp xếp</span>
        </div>
    </div>

</div>
<div class="container content">
    <div class="left">
        <div class="container-of-left ">
            <div class="row">
                <div class="row type-left">
                    <ul class="">
                        <li class="drivider"><a href="">Tất cả</a></li>
                        <li class="line"><a href="">|</a></li>
                        <li class="drivider"><a href="">Gỗ</a></li>
                        <li class="line"><a href="">|</a></li>
                        <li class="drivider"><a href="">Gốm</a></li>
                    </ul>
                </div>
            </div>
            <div class="row boder-line">
            </div>
            <div class="row type-item">
                <div class="state">
                    <ul>
                        <li class="item"> <a href=""> Giảm giá</a></li>
                        <li class="item"> <a href=""> Sản phẩm mới</a></li>
                        <li class="item"> <a href=""> Bán chạy</a></li>
                    </ul>
                </div>
            </div>
            <div class="row boder-line"></div>
            <div class="row type-group">
                <div class="group">
                    <h3>Nhóm sản phẩm</h3>
                    <ul>
                        <li class="item"> <a href=""> Phòng khách</a></li>
                        <li class="item"> <a href=""> Nhà bếp</a></li>
                        <li class="item"> <a href=""> Phong thủy</a></li>
                        <li class="item"> <a href=""> Phòng ngủ</a></li>
                        <li class="item"> <a href=""> Giải trí</a></li>
                        <li class="item"> <a href=""> Trang trí tường</a></li>
                        <!-- <li class="item"> <a href=""> chăm sóc tóc</a></li> -->
                    </ul>
                </div>
            </div>
        </div>

    </div>

    <div class="right">
        <!-- slider -->
        <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
            <ol class="carousel-indicators">
                <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <a href=""><img class="d-block w-100" src="images/list-product/cms-banner.jpg" alt="First slide"></a>
                </div>
                <div class="carousel-item">
                    <a href=""> <img class="d-block w-100" src="images/list-product/BIOPHILIA_10.jpg" alt="Second slide"></a>
                </div>
                <div class="carousel-item">
                    <a href=""><img class="d-block w-100 " src="https://i.etsystatic.com/15645889/r/il/12a570/1253369484/il_794xN.1253369484_12vn.jpg" alt="Third slide"></a>
                </div>
            </div>
            <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
        <!-- list product -->
        <div class="list-product">
            <div class="row">
                <div class="col-4">
                    <div class="thumbnail">
                        <div class="cont-item ">
                            <a href="product.jsp"><img src="https://i.etsystatic.com/34082332/r/il/40eca9/3697370969/il_794xN.3697370969_s1yf.jpg" alt="">
                            </a>
                        </div>
                        <div class="button">
                            <a href="" class="buy-now"> Mua ngay</a>
                            <a href="" class="wish-list "><i class="fa-solid fa-cart-plus"></i></a>
                        </div>
                        <div class="caption">
                            <h3><a href="">Cú gỗ trên cây</a></h3>
                            <div class="ratting">
                                <i class="fa fa-star yellow"></i>
                                <i class="fa fa-star yellow"></i>
                                <i class="fa fa-star yellow"></i>
                                <i class="fa fa-star yellow"></i>
                                <i class="fa fa-star "></i>
                            </div>
                            <h3 class="price">
                                713,000 VND
                                <span class="price-real">839.000 VND</span>
                            </h3>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <div class="thumbnail">
                        <div class="cont-item ">
                            <a href="#"><img src="https://i.etsystatic.com/28326759/r/il/145f2f/2997173961/il_794xN.2997173961_b29o.jpg" alt="">
                            </a>
                        </div>
                        <div class="button">
                            <a href="" class="buy-now"> Mua ngay</a>
                            <a href="" class="wish-list "><i class="fa-solid fa-cart-plus"></i></a>
                        </div>
                        <div class="caption">
                            <h3><a href="">Cặp đôi chim ruồi</a></h3>
                            <div class="ratting">
                                <i class="fa fa-star yellow"></i>
                                <i class="fa fa-star yellow"></i>
                                <i class="fa fa-star yellow"></i>
                                <i class="fa fa-star yellow"></i>
                                <i class="fa fa-star "></i>
                            </div>
                            <h3 class="price">
                                1,241,000 VND
                                <!-- <span class="price-real">490.000 VND</span> -->
                            </h3>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <div class="thumbnail">
                        <div class="cont-item ">
                            <a href="#"><img src="https://i.etsystatic.com/27431999/r/il/d76074/4160030118/il_794xN.4160030118_bdy0.jpg" alt="">
                            </a>
                        </div>
                        <div class="button">
                            <a href="" class="buy-now"> Mua ngay</a>
                            <a href="" class="wish-list "><i class="fa-solid fa-cart-plus"></i></a>
                        </div>
                        <div class="caption">
                            <h3><a href=""> Cốc gốm thảo mộc </a></h3>
                            <div class="ratting">
                                <i class="fa fa-star yellow"></i>
                                <i class="fa fa-star yellow"></i>
                                <i class="fa fa-star yellow"></i>
                                <i class="fa fa-star yellow"></i>
                                <i class="fa fa-star "></i>
                            </div>
                            <h3 class="price">
                                369.000 VND
                                <!-- <span class="price-real">490.000 VND</span> -->
                            </h3>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <div class="thumbnail">
                        <div class="cont-item ">
                            <a href="#"><img src="https://i.etsystatic.com/14458095/r/il/095d0c/3905526261/il_794xN.3905526261_b4o9.jpg  " alt="">
                            </a>
                        </div>
                        <div class="button">
                            <a href="" class="buy-now"> Mua ngay</a>
                            <a href="" class="wish-list "><i class="fa-solid fa-cart-plus"></i></a>
                        </div>
                        <div class="caption">
                            <h3><a href="">Bộ cốc bầu trời xanh dễ thương</a></h3>
                            <div class="ratting">
                                <i class="fa fa-star yellow"></i>
                                <i class="fa fa-star yellow"></i>
                                <i class="fa fa-star yellow"></i>
                                <i class="fa fa-star yellow"></i>
                                <i class="fa fa-star "></i>
                            </div>
                            <h3 class="price">
                                760.000 VND
                                <!-- <span class="price-real">800.000 VND</span> -->
                            </h3>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <div class="thumbnail">
                        <div class="cont-item ">
                            <a href="#"><img src="https://i.etsystatic.com/36832986/r/il/5a7e1a/4127630124/il_794xN.4127630124_ktlk.jpg" alt="">
                            </a>
                        </div>
                        <div class="button">
                            <a href="" class="buy-now"> Mua ngay</a>
                            <a href="" class="wish-list "><i class="fa-solid fa-cart-plus"></i></a>
                        </div>
                        <div class="caption">
                            <h3><a href="">Bình gốm trang trí nội thất</a></h3>
                            <div class="ratting">
                                <i class="fa fa-star yellow"></i>
                                <i class="fa fa-star yellow"></i>
                                <i class="fa fa-star yellow"></i>
                                <i class="fa fa-star yellow"></i>
                                <i class="fa fa-star "></i>
                            </div>
                            <h3 class="price">
                                596.000 VND
                                <!-- <span class="price-real">490.000 VND</span> -->
                            </h3>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <div class="thumbnail">
                        <div class="cont-item ">
                            <a href="#"><img src="https://i.etsystatic.com/18808630/r/il/53972b/3812956630/il_794xN.3812956630_2gct.jpg" alt="">
                            </a>
                        </div>
                        <div class="button">
                            <a href="" class="buy-now"> Mua ngay</a>
                            <a href="" class="wish-list "><i class="fa-solid fa-cart-plus"></i></a>
                        </div>
                        <div class="caption">
                            <h3><a href="">Đĩa tròn gỗ thủ công</a></h3>
                            <div class="ratting">
                                <i class="fa fa-star yellow"></i>
                                <i class="fa fa-star yellow"></i>
                                <i class="fa fa-star yellow"></i>
                                <i class="fa fa-star yellow"></i>
                                <i class="fa fa-star "></i>
                            </div>
                            <h3 class="price">
                                329.000 VND
                                <span class="price-real">490.000 VND</span>
                            </h3>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <div class="thumbnail">
                        <div class="cont-item ">
                            <a href="#"><img src="https://i.etsystatic.com/9623213/r/il/7cc5cb/995912283/il_794xN.995912283_mnbb.jpg" alt="">
                            </a>
                        </div>
                        <div class="button">
                            <a href="" class="buy-now"> Mua ngay</a>
                            <a href="" class="wish-list "><i class="fa-solid fa-cart-plus"></i></a>
                        </div>
                        <div class="caption">
                            <h3><a href="">Thớt gỗ óc chó</a></h3>
                            <div class="ratting">
                                <i class="fa fa-star yellow"></i>
                                <i class="fa fa-star yellow"></i>
                                <i class="fa fa-star yellow"></i>
                                <i class="fa fa-star yellow"></i>
                                <i class="fa fa-star "></i>
                            </div>
                            <h3 class="price">
                                750.000 VND
                                <!-- <span class="price-real">490.000 VND</span> -->
                            </h3>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <div class="thumbnail">
                        <div class="cont-item ">
                            <a href="#"><img src="https://i.etsystatic.com/11286611/r/il/d113cd/1582087127/il_794xN.1582087127_30q1.jpg" alt="">
                            </a>
                        </div>
                        <div class="button">
                            <a href="" class="buy-now"> Mua ngay</a>
                            <a href="" class="wish-list "><i class="fa-solid fa-cart-plus"></i></a>
                        </div>
                        <div class="caption">
                            <h3><a href=""> Chụp đèn gỗ</a></h3>
                            <div class="ratting">
                                <i class="fa fa-star yellow"></i>
                                <i class="fa fa-star yellow"></i>
                                <i class="fa fa-star yellow"></i>
                                <i class="fa fa-star yellow"></i>
                                <i class="fa fa-star "></i>
                            </div>
                            <h3 class="price">
                                2.334.000 VND
                                <span class="price-real">2.917.000 VND</span>
                            </h3>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <div class="thumbnail">
                        <div class="cont-item ">
                            <a href="#"><img src="https://i.etsystatic.com/28083097/r/il/4d0be8/3478700194/il_794xN.3478700194_lwhz.jpg" alt="">
                            </a>
                        </div>
                        <div class="button">
                            <a href="" class="buy-now"> Mua ngay</a>
                            <a href="" class="wish-list "><i class="fa-solid fa-cart-plus"></i></a>
                        </div>
                        <div class="caption">
                            <h3><a href=""> Bình hoa tối giản</a></h3>
                            <div class="ratting">
                                <i class="fa fa-star yellow"></i>
                                <i class="fa fa-star yellow"></i>
                                <i class="fa fa-star yellow"></i>
                                <i class="fa fa-star yellow"></i>
                                <i class="fa fa-star "></i>
                            </div>
                            <h3 class="price">
                                466.000 VND
                                <!-- <span class="price-real">490.000 VND</span> -->
                            </h3>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <div class="thumbnail">
                        <div class="cont-item ">
                            <a href="#"><img src="https://i.etsystatic.com/19076644/r/il/549709/4240974539/il_794xN.4240974539_nji7.jpg" alt="">
                            </a>
                        </div>
                        <div class="button">
                            <a href="" class="buy-now"> Mua ngay</a>
                            <a href="" class="wish-list "><i class="fa-solid fa-cart-plus"></i></a>
                        </div>
                        <div class="caption">
                            <h3><a href="">Tượng nấm bằng gỗ </a></h3>
                            <div class="ratting">
                                <i class="fa fa-star yellow"></i>
                                <i class="fa fa-star yellow"></i>
                                <i class="fa fa-star yellow"></i>
                                <i class="fa fa-star yellow"></i>
                                <i class="fa fa-star "></i>
                            </div>
                            <h3 class="price">
                                1.020.000 VND
                                <!-- <span class="price-real">490.000 VND</span> -->
                            </h3>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <div class="thumbnail">
                        <div class="cont-item ">
                            <a href="#"><img src="https://i.etsystatic.com/11707818/r/il/f87020/2047935892/il_794xN.2047935892_n5xr.jpg" alt="">
                            </a>
                        </div>
                        <div class="button">
                            <a href="" class="buy-now"> Mua ngay</a>
                            <a href="" class="wish-list "><i class="fa-solid fa-cart-plus"></i></a>
                        </div>
                        <div class="caption">
                            <h3><a href=""> Dụng cụ mở chai treo tường</a></h3>
                            <div class="ratting">
                                <i class="fa fa-star yellow"></i>
                                <i class="fa fa-star yellow"></i>
                                <i class="fa fa-star yellow"></i>
                                <i class="fa fa-star yellow"></i>
                                <i class="fa fa-star "></i>
                            </div>
                            <h3 class="price">
                                875.000 VND
                                <!-- <span class="price-real">490.000 VND</span> -->
                            </h3>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <div class="thumbnail">
                        <div class="cont-item ">
                            <a href="#"><img src="https://i.etsystatic.com/32000242/r/il/9cfdf7/3389038003/il_794xN.3389038003_42cu.jpg" alt="">
                            </a>
                        </div>
                        <div class="button">
                            <a href="" class="buy-now"> Mua ngay</a>
                            <a href="" class="wish-list "><i class="fa-solid fa-cart-plus"></i></a>
                        </div>
                        <div class="caption">
                            <h3><a href=""> Lót ly hình mèo</a></h3>
                            <div class="ratting">
                                <i class="fa fa-star yellow"></i>
                                <i class="fa fa-star yellow"></i>
                                <i class="fa fa-star yellow"></i>
                                <i class="fa fa-star yellow"></i>
                                <i class="fa fa-star "></i>
                            </div>
                            <h3 class="price">
                                338.000 VND
                                <span class="price-real">397.000 VND</span>

                            </h3>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <div class="thumbnail">
                        <div class="cont-item ">
                            <a href="#"><img src="https://i.etsystatic.com/34036755/r/il/87793e/3786324874/il_794xN.3786324874_j0l4.jpg" alt="">
                            </a>
                        </div>
                        <div class="button">
                            <a href="" class="buy-now"> Mua ngay</a>
                            <a href="" class="wish-list "><i class="fa-solid fa-cart-plus"></i></a>
                        </div>
                        <div class="caption">
                            <h3><a href=""> Lá nghệ thuật</a></h3>
                            <div class="ratting">
                                <i class="fa fa-star yellow"></i>
                                <i class="fa fa-star yellow"></i>
                                <i class="fa fa-star yellow"></i>
                                <i class="fa fa-star yellow"></i>
                                <i class="fa fa-star "></i>
                            </div>
                            <h3 class="price">
                                132.000 VND
                                <span class="price-real">264.000 VND</span>
                            </h3>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <div class="thumbnail">
                        <div class="cont-item ">
                            <a href="#"><img src="https://i.etsystatic.com/19076644/r/il/3388bd/4352543767/il_794xN.4352543767_gr5d.jpg" alt="">
                            </a>
                        </div>
                        <div class="button">
                            <a href="" class="buy-now"> Mua ngay</a>
                            <a href="" class="wish-list "><i class="fa-solid fa-cart-plus"></i></a>
                        </div>
                        <div class="caption">
                            <h3><a href=""> Cặp đôi chim ruồi</a></h3>
                            <div class="ratting">
                                <i class="fa fa-star yellow"></i>
                                <i class="fa fa-star yellow"></i>
                                <i class="fa fa-star yellow"></i>
                                <i class="fa fa-star yellow"></i>
                                <i class="fa fa-star "></i>
                            </div>
                            <h3 class="price">
                                1.023.000 VND
                                <!-- <span class="price-real">490.000 VND</span> -->
                            </h3>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <div class="thumbnail">
                        <div class="cont-item ">
                            <a href="#"><img src="https://i.etsystatic.com/8105101/r/il/c0872d/568014834/il_794xN.568014834_mgmv.jpg" alt="">
                            </a>
                        </div>
                        <div class="button">
                            <a href="" class="buy-now"> Mua ngay</a>
                            <a href="" class="wish-list "><i class="fa-solid fa-cart-plus"></i></a>
                        </div>
                        <div class="caption">
                            <h3><a href=""> Giá đỡ ipad</a></h3>
                            <div class="ratting">
                                <i class="fa fa-star yellow"></i>
                                <i class="fa fa-star yellow"></i>
                                <i class="fa fa-star yellow"></i>
                                <i class="fa fa-star yellow"></i>
                                <i class="fa fa-star "></i>
                            </div>
                            <h3 class="price">
                                492.000 VND
                                <!-- <span class="price-real">490.000 VND</span> -->
                            </h3>
                        </div>
                    </div>
                </div>

            </div>
        </div>
        <!-- pagination -->
        <nav aria-label="Page navigation example" class="pagination-page">
            <ul class="pagination">
                <li class="page-item">
                    <a class="page-link" href="#" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                        <span class="sr-only">Previous</span>
                    </a>
                </li>
                <li class="page-item active"><a class="page-link" href="#">1</a></li>
                <li class="page-item"><a class="page-link" href="#">2</a></li>
                <li class="page-item"><a class="page-link" href="#">3</a></li>
                <li class="page-item">
                    <a class="page-link" href="#" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                        <span class="sr-only">Next</span>
                    </a>
                </li>
            </ul>
        </nav>
    </div>

</div>


<%@include file="footer.jsp"%>
<%@include file="scroll-to-top.jsp"%>

<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script type="text/javascript" src="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js" integrity="sha512-aVKKRRi/Q/YV+4mjoKBsE4x3H+BkegoM/em46NNlCqNTmUYADjBbeNefNxYV7giUp0VxICtqdrbqU7iVaeZNXA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script src="js/general.js"></script>
<script src="js/list-product.js"></script>
</body>

</html>
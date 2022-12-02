<%@ page import="bean.Product" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
    <link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"/>

    <link rel="stylesheet" href="css/general.css">
    <link rel="stylesheet" href="css/product.css">
</head>

<body>
<ul class="nav nav-page">
    <li class=" left"><a href="home-page.jsp"><img src="images/logo/logo-rmbg1.png" alt=""></a>
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
            <input type="text" id="search" placeholder="Tìm kiếm..."/>
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

<div class="address-book-background">
    <div class="container address-book-vs-sort">
        <div class="address-book">
            <span><a href="home-page.jsp">Trang chủ</a></span><span>|</span>
            <span><a href="list-product.jsp">Gỗ</a></span><span>|</span>
            <span><a href="list-product.jsp">Trang trí</a></span><span>|</span>
            <span><a href="product.jsp">Tượng chim cú được chạm khắc bằng tay</a></span>
        </div>
    </div>

</div>


<%Product product = (Product) request.getAttribute("product");%>
<div class="container infomation-product bd-bottom">
    <div class="row">
        <div class="col-sm left">
            <div class="slider-show-img">
                <div><img
                        src="https://i.etsystatic.com/34082332/r/il/99c9af/3697371489/il_794xN.3697371489_avu8.jpg"
                        alt=""></div>
                <div><img
                        src="https://i.etsystatic.com/34082332/r/il/1daebc/3697370887/il_794xN.3697370887_1gqq.jpg"
                        alt=""></div>
                <div><img
                        src="https://i.etsystatic.com/34082332/r/il/40eca9/3697370969/il_794xN.3697370969_s1yf.jpg"
                        alt=""></div>
                <div><img
                        src="https://i.etsystatic.com/34082332/r/il/3c138f/3697371081/il_794xN.3697371081_psd3.jpg"
                        alt=""></div>
                <div><img
                        src="https://i.etsystatic.com/34082332/r/il/f92d64/3697371185/il_794xN.3697371185_1znh.jpg"
                        alt=""></div>
            </div>
            <div class="slider-img">
                <div class="image"><img
                        src="https://i.etsystatic.com/34082332/r/il/99c9af/3697371489/il_794xN.3697371489_avu8.jpg"
                        alt=""></div>
                <div class="image"><img
                        src="https://i.etsystatic.com/34082332/r/il/1daebc/3697370887/il_794xN.3697370887_1gqq.jpg"
                        alt=""></div>
                <div class="image"><img
                        src="https://i.etsystatic.com/34082332/r/il/40eca9/3697370969/il_794xN.3697370969_s1yf.jpg"
                        alt=""></div>
                <div class="image"><img
                        src="https://i.etsystatic.com/34082332/r/il/3c138f/3697371081/il_794xN.3697371081_psd3.jpg"
                        alt=""></div>
                <div class="image"><img
                        src="https://i.etsystatic.com/34082332/r/il/f92d64/3697371185/il_794xN.3697371185_1znh.jpg"
                        alt=""></div>
            </div>
        </div>
        <div class="col-sm right">
            <div class="top bd-bottom">
                <h3 class="name-product uppercase"><%=product.getProductName()%>
                </h3>
                <div class="cost">
                    <span class="price uppercase"><%=product.getPrice()%> VND</span>
                    <%if (product.getPriceReal() != 0) {%>
                    <span class="sale uppercase"><%=product.getPriceReal()%> VND</span>
                    <%}%>
                </div>
                <div class="ratting">
                    <% int count = product.getRate();
                        for (int i = 0; i < 5; i++) {
                            if (count > 0) {%>
                    <i class="fa fa-star yellow"></i>
                    <%} else {%>
                    <i class="fa fa-star  "></i>
                    <%}
                        count--;
                    %>
                    <%}%>
                </div>
            </div>
            <div class="bottom">
                <h5 class="text uppercase">số lượng</h5>
                <input type="number" id="quantity" class="input" name="quantity" min="1" max="20" placeholder=" "
                       value="1">
                <button class="btn-add-cart uppercase submit">thêm vào giỏ hàng</button>
                <button class="btn-buy uppercase submit">thanh toán</button>
            </div>

        </div>
    </div>
    <div class="row">
        <div class="col-sm rate">
            <h3 class="uppercase">Đánh giá sản phẩm</h3>
            <div class="ratting bd-bottom">
                <span><%=product.getRate()%>/5</span>
                <% count = product.getRate();
                    for (int i = 0; i < 5; i++) {
                        if (count > 0) {%>
                <i class="fa fa-star yellow"></i>
                <%} else {%>
                <i class="fa fa-star  "></i>
                <%}
                    count--;
                %>
                <%}%>
            </div>
            <ul class="list-comment">
                <li class="item-comment bd-bottom">
                    <div class="user-cmt">
                        <img src="https://scontent.fsgn13-3.fna.fbcdn.net/v/t39.30808-6/313391785_991195072283014_7128890801933160323_n.jpg?stp=cp6_dst-jpg&_nc_cat=108&ccb=1-7&_nc_sid=09cbfe&_nc_ohc=5mvp-Zd1yZ4AX-ggyT9&_nc_ht=scontent.fsgn13-3.fna&oh=00_AfCrmvrV-MYelNxCKM_3iYRrD6j4A4j6PRepmR0VToXMpg&oe=6374D52F"
                             alt="" class="img-user-cmt">
                        <div>
                            <div class="name-user-cmt">Quynh Nhu</div>
                            <div class="ratting rate-user">
                                <i class="fa fa-star yellow"></i>
                                <i class="fa fa-star yellow"></i>
                                <i class="fa fa-star yellow"></i>
                                <i class="fa fa-star yellow"></i>
                                <i class="fa fa-star "></i>
                            </div>
                        </div>
                    </div>
                    <div class="date-cmt">19/10/2022</div>
                    <div class="comment">
                        <p>
                            Lorem ipsum dolor sit amet consectetur adipisicing elit. Exercitationem, inventore iusto
                            labore eligendi.
                        </p>
                    </div>

                </li>
                <li class="item-comment bd-bottom">
                    <div class="user-cmt">
                        <img src="https://scontent.fsgn8-1.fna.fbcdn.net/v/t39.30808-6/314732580_1510805282677333_7550716410289942754_n.jpg?_nc_cat=103&ccb=1-7&_nc_sid=09cbfe&_nc_ohc=k4QhXJ4BtBoAX_QA3w5&_nc_ht=scontent.fsgn8-1.fna&oh=00_AfBOQLwlnfAdfZ0FE-Y3hByrdHKsxFYIvIcYiR9sTH8nww&oe=6373E7EA"
                             alt="" class="img-user-cmt">
                        <div>
                            <div class="name-user-cmt">Thanh Phụng</div>
                            <div class="ratting rate-user">
                                <i class="fa fa-star yellow"></i>
                                <i class="fa fa-star yellow"></i>
                                <i class="fa fa-star yellow"></i>
                                <i class="fa fa-star yellow"></i>
                                <i class="fa fa-star "></i>
                            </div>
                        </div>
                    </div>
                    <div class="date-cmt">19/10/2022</div>
                    <div class="comment">
                        <p>
                            Lorem ipsum dolor sit amet consectetur adipisicing elit. Exercitationem, inventore iusto
                            labore eligendi.
                        </p>
                    </div>

                </li>
                <li class="item-comment bd-bottom">
                    <div class="user-cmt">
                        <img src="https://scontent.fsgn8-2.fna.fbcdn.net/v/t39.30808-6/298558603_1222887821833237_1584251796394668679_n.jpg?_nc_cat=100&ccb=1-7&_nc_sid=09cbfe&_nc_ohc=Qwy5353OvL4AX-bC38o&_nc_oc=AQmeF-5l-QfcHyTmSmJJkvOUhSNQ-HIeWke8Z6iBqS06tTWnke0I5xiTYhs25tiwAQg&_nc_ht=scontent.fsgn8-2.fna&oh=00_AfBUIfV18-9V28qUjk6TENUJUI8yvSSoj46-T22WzUX9kA&oe=63756F5E"
                             alt="" class="img-user-cmt">
                        <div>
                            <div class="name-user-cmt">Bảo Đặng</div>
                            <div class="ratting rate-user">
                                <i class="fa fa-star yellow"></i>
                                <i class="fa fa-star yellow"></i>
                                <i class="fa fa-star yellow"></i>
                                <i class="fa fa-star yellow"></i>
                                <i class="fa fa-star "></i>
                            </div>
                        </div>
                    </div>
                    <div class="date-cmt">19/10/2022</div>
                    <div class="comment">
                        <p>
                            Lorem ipsum dolor sit amet consectetur adipisicing elit. Exercitationem, inventore iusto
                            labore eligendi.
                        </p>
                    </div>

                </li>
            </ul>
            <nav aria-label="Page navigation example">
                <ul class="pagination">
                    <li class="page-item">
                        <a class="page-link" href="#" aria-label="Previous">
                            <span aria-hidden="true"><i class="fa-solid fa-angle-left"></i></span>
                            <span class="sr-only">Previous</span>
                        </a>
                    </li>
                    <li class="page-item active"><a class="page-link" href="#">1</a></li>
                    <li class="page-item"><a class="page-link" href="#">2</a></li>
                    <li class="page-item"><a class="page-link" href="#">3</a></li>
                    <li class="page-item">
                        <a class="page-link" href="#" aria-label="Next">
                            <span aria-hidden="true"><i class="fa-solid fa-angle-right"></i></span>
                            <span class="sr-only">Next</span>
                        </a>
                    </li>
                </ul>
            </nav>
            <div class="write-ratting">
                <h5 class="lb-cmt uppercase">đánh giá của bạn</h5>
                <div class="ratting">
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                </div>
                <textarea class="write-cmt input" name="" id="" cols="30" rows="10"></textarea>
                <button id="submit-cmt" class="uppercase submit">Đăng bình luận</button>
            </div>
        </div>
        <div class="col-sm detail-product">
            <div id="accordion">
                <div class="card bd-bottom">
                    <div class="card-header bd-bottom" id="headingOne">
                        <h5 class="mb-0">
                            <button class="collapsed uppercase" data-toggle="collapse" data-target="#collapseOne"
                                    aria-expanded="true" aria-controls="collapseOne">
                                Thông tin chi tiết
                            </button>
                        </h5>
                    </div>

                    <div id="collapseOne" class="collapse" aria-labelledby="headingOne" data-parent="#accordion">
                        <p class="card-body">
                            Thủ công <br>
                            Vật liệu: gỗ <br>
                            Chiều rộng: 7 cm <br>
                            Chiều cao: 19 cm <br>
                            Chiều sâu: 7 cm <br>
                        </p>
                    </div>
                </div>
                <div class="card bd-bottom">
                    <div class="card-header bd-bottom" id="headingTwo">
                        <h5 class="mb-0">
                            <button class="collapsed uppercase" data-toggle="collapse" data-target="#collapseTwo"
                                    aria-expanded="false" aria-controls="collapseTwo">
                                Mô tả sản phẩm
                            </button>
                        </h5>
                    </div>
                    <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordion">
                        <p class="card-body">
                            SỰ CHỈ RÕ <br>
                            • Kích thước: 19cm x 7cm x 7cm <br>
                            • Màu sắc: Trong suốt <br>
                            • Chất liệu & Quy trình: Bàn trang trí chim cú bằng gỗ là sản phẩm thủ công do gia đình
                            <br>
                            chúng tôi làm, chim cú được làm từ gỗ jempinis với kỹ thuật điêu khắc rất cẩn thận nhằm
                            <br>
                            tạo ra hình chim cú rất đẹp, kết hợp với những gốc gỗ tự nhiên và rất độc đáo như cơ sở
                            <br>
                            hoàn hảo để trang trí ngôi nhà của bạn để làm cho nó trông đẹp hơn và cũng có thể tặng
                            <br>
                            cho một người đặc biệt như một món quà. <br>

                            THỜI GIAN CHẾ BIẾN & VẬN CHUYỂN <br>
                            • chúng tôi cần thời gian để xử lý khoảng 2-5 ngày làm việc <br>
                            • Indonesia Pos Express: 6-12 ngày sau khi tôi đánh dấu đơn hàng là hoàn thành <br>
                        </p>
                    </div>
                </div>
                <div class="card bd-bottom">
                    <div class="card-header bd-bottom" id="headingThree">
                        <h5 class="mb-0">
                            <button class="collapsed uppercase" data-toggle="collapse" data-target="#collapseThree"
                                    aria-expanded="false" aria-controls="collapseThree">
                                Chi tiết đổi trả
                            </button>
                        </h5>
                    </div>
                    <div id="collapseThree" class="collapse" aria-labelledby="headingThree"
                         data-parent="#accordion">
                        <div class="card-body">
                            Thông tin chi tiết đổi trả sản phẩm
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="container similar-product">
    <div class="title-similar-product uppercase">
        <h3>Sản phẩm tương tự</h3>
    </div>
    <div class="slider-similar-product">
        <div class="product">
            <div class="thumbnail">
                <div class="cont-item ">
                    <a href="#"><img
                            src="https://i.etsystatic.com/23214896/r/il/473823/2432267993/il_794xN.2432267993_7jam.jpg"
                            alt="">
                    </a>
                </div>

                <div class="caption">
                    <h3><a href="">Quả táo gỗ</a></h3>
                    <div class="ratting">
                        <i class="fa fa-star yellow"></i>
                        <i class="fa fa-star yellow"></i>
                        <i class="fa fa-star yellow"></i>
                        <i class="fa fa-star yellow"></i>
                        <i class="fa fa-star "></i>
                    </div>
                    <h3 class="price">
                        514.000 VND
                        <!-- <span class="price-real">2.520,000 VND</span> -->
                    </h3>
                </div>
            </div>
        </div>
        <div class="product">
            <div class="thumbnail">
                <div class="cont-item ">
                    <a href="#"><img
                            src="https://i.etsystatic.com/28326759/r/il/145f2f/2997173961/il_794xN.2997173961_b29o.jpg"
                            alt="">
                    </a>
                </div>
                <div class="caption">
                    <h3><a href=""> Tượng con chim ruồi</a></h3>
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
        <div class="product">
            <div class="thumbnail">
                <div class="cont-item ">
                    <a href="#"><img
                            src="https://i.etsystatic.com/18808630/r/il/53972b/3812956630/il_794xN.3812956630_2gct.jpg"
                            alt="">
                    </a>
                </div>

                <div class="caption">
                    <h3><a href="">Đĩa tròn bằng gỗ thủ công</a></h3>
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
        <div class="product">
            <div class="thumbnail">
                <div class="cont-item ">
                    <a href="#"><img
                            src="https://i.etsystatic.com/21232771/r/il/07a850/2794057758/il_794xN.2794057758_fmnl.jpg"
                            alt="">
                    </a>
                </div>
                <div class="caption">
                    <h3><a href="">Thìa gỗ làm thủ công - Muỗng nấu ăn 12 inch</a></h3>
                    <div class="ratting">
                        <i class="fa fa-star yellow"></i>
                        <i class="fa fa-star yellow"></i>
                        <i class="fa fa-star yellow"></i>
                        <i class="fa fa-star yellow"></i>
                        <i class="fa fa-star "></i>
                    </div>
                    <h3 class="price">
                        751.000 VND
                        <!-- <span class="price-real">490.000 VND</span> -->
                    </h3>
                </div>
            </div>
        </div>
        <div class="product">
            <div class="thumbnail">
                <div class="cont-item ">
                    <a href="#"><img
                            src="https://i.etsystatic.com/19076644/r/il/549709/4240974539/il_794xN.4240974539_nji7.jpg"
                            alt="">
                    </a>
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
        <div class="product">
            <div class="thumbnail">
                <div class="cont-item ">
                    <a href="#"><img
                            src="https://i.etsystatic.com/26845987/r/il/ff7985/2857907629/il_794xN.2857907629_ssxj.jpg"
                            alt="">
                    </a>
                </div>

                <div class="caption">
                    <h3><a href="">Keycap gỗ đen cho bàn phím</a></h3>
                    <div class="ratting">
                        <i class="fa fa-star yellow"></i>
                        <i class="fa fa-star yellow"></i>
                        <i class="fa fa-star yellow"></i>
                        <i class="fa fa-star yellow"></i>
                        <i class="fa fa-star "></i>
                    </div>
                    <h3 class="price">
                        725.000 VND
                        <span class="price-real">800.000 VND</span>
                    </h3>
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
<script src="js/general.js"></script>
<script src="js/product.js"></script>
</body>

</html>
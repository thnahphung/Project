<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quên mật khẩu</title>
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css">

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css" />
    <link rel="stylesheet" href="css/forgot-pass.css">
</head>

<body>
    <div class="content">
        <div class="background"></div>

        <div class="main">

            <div id="title"> <img src="images/logo/logo-rmbg1.png" alt="">
                <h2> Quên mật khẩu</h2>
            </div>

            <div class="form-input">

                <div class="input-uname">
                    <input type="text" class="input phone" placeholder="Số điện thoại hoặc email">
                    <button class="uppercase">Gửi link</button>
                </div>
                <!-- <input type="text" class="input pass" placeholder="Nhập mã xác nhận"> -->
                <input type="password" class="input pass" placeholder="Mật khẩu mới">
                <input type="password" class="input passAgain" placeholder="Nhập lại mật khẩu mới">
                <i class="fa-solid fa-check"></i>
                <!-- <i class="fa-solid fa-xmark"></i> -->

                <input type="submit" class="submit" value="Đổi mật khẩu">

            </div>
            <a href="login.jsp">Quay lại</a>
        </div>
    </div>
</body>

</html>
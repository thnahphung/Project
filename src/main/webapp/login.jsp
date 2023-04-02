<%@ page contentType="text/html; charsetUTF-8" language="java" pageEncoding="UTF-8" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>login</title>
    <link rel="stylesheet" href="css/reset.css">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css">

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
          integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"/>
    <link rel="stylesheet" href="css/login.css">

</head>
<body>
<%
    String error = (String) request.getAttribute("error");
    error = error == null ? "" : error;
%>
<div class="form-login">
    <div class="background"></div>
    <form action="/doLogin" method="post">
        <img src="images/logo/logo-rmbg1.png" alt="">
        <h2> Đăng nhập</h2>
        <div class="user">
            <p class="error"><%= error%>
            </p>
            <input type="text" name="user" class="name input" placeholder="Email hoặc số điện thoại">
            <input type="password" name="password" class="pass input" placeholder="Mật khẩu">
            <a href="http://localhost:8080/forgotPass" class="forget"> Bạn quên mật khẩu?</a>

            <input type="submit" name="submit" class="submit" value="Đăng nhập">
            <p style="color:red;text-align: center">Hoặc bạn có thể đăng nhập bằng:</p>
            <!-- <button  type="button" class="btn btn-sm btn-primary">Facebook</button> -->
            <fb:login-button scope="public_profile,email" onlogin="checkLoginState();">
            </fb:login-button>
            <div id="status"></div>
            <p class="sign-up">Tạo tài khoản mới miễn phí <a href="http://localhost:8080/doSignUp">tại đây</a></p>
        </div>
    </form>
</div>


<script src="https://code.jquery.com/jquery-3.1.1.min.js">
    <%--<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"--%>
    <%--        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"--%>
    <%--        crossorigin="anonymous"></script>--%>
    <script type="text/javascript" src="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
        integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js"
        integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+"
        crossorigin="anonymous"></script>
<script src="js/general.js"></script>
<script>
    // $(function () {
    window.fbAsyncInit = function() {
        FB.init({
            appId      : '530919699225104',
            xfbml      : true,
            version    : 'v16.0'
        });
        FB.AppEvents.logPageView();
    };

    (function(d, s, id){
        var js, fjs = d.getElementsByTagName(s)[0];
        if (d.getElementById(id)) {return;}
        js = d.createElement(s); js.id = id;
        js.src = "https://connect.facebook.net/en_US/sdk.js";
        fjs.parentNode.insertBefore(js, fjs);
    }(document, 'script', 'facebook-jssdk'));

    function checkLoginState() {
        FB.getLoginStatus(function (response) {
            statusChangeCallback(response);
        });
    }

    function statusChangeCallback(response) {
        console.log('statusChangeCallback');
        console.log(response);
        if (response.status === 'connected') {
            testAPI();
        } else {
            document.getElementById('status').innerHTML = 'Please log ' +
                'into this app.';
        }
    }

    function testAPI() {
        console.log('Welcome!  Fetching your information.... ');
        FB.api('/me', function (response) {
            $.ajax({
                url: "/loginByFB",
                type: "post", //send it through get method
                data: {
                    name: response.name,
                    id: response.id
                },
                success: function (response) {
                    window.location = "http://localhost:8080/homepage";
                }
            });
            document.getElementById('status').innerHTML =
                'Thanks for logging in, ' + response.name + '!';
        });
    }

    // });
</script>
</body>

</html>
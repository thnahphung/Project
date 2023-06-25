$(document).ready(function () {


    $(window).scroll(function () {
        var scroll = $(window).scrollTop();

        //>=, not <=
        if (scroll >= 5) {
            //clearHeader, not clearheader - caps H
            $(".nav-page").addClass("bg-light");

        } else {
            $(".nav-page").removeClass("bg-light");
        }
    }); //missing );

    $('button.btn-add-cart').click(function () {
        let amountAdd = parseInt($('#quantity').val());
        let idProduct = parseInt($(this).val());
        if (isNaN(amountAdd)) {
            amountAdd = 1;
        }
        $.ajax({
            url: "/cart/addCart",
            type: "get",
            data: {
                idProduct: idProduct,
                amount: amountAdd
            },
            success: function (response) {
                $('.amount-product').text(response.trim());
            },
            error: function (xhr) {

            }
        });
    })

    $("#search").click(function () {
            if (window.location == "/searches?search=" + $('.search-input').val().trim()) {
                alert($('.search-input').val().trim())
                $.ajax({
                    url: "/searches",
                    type: "get",
                    data: {
                        search: $('.search-input').val().trim()
                    },
                    success: function (response) {
                        $(".list-product .row").html(response);
                    },
                    error: function (xhr) {
                        //Do Something to handle error
                    }
                })
            } else {
                window.location = "/searches?search=" + $('.search-input').val().trim();
                // $.ajax({
                //     url: "/Searches",
                //     type: "get",
                //     data: {
                //         search: $('.search-input').val().trim()
                //     },
                //     success: function (response) {
                //         $(".list-product .row").html(response);
                //     },
                //     error: function (xhr) {
                //         //Do Something to handle error
                //     }
                // })
            }
        }
    )
    // document ready
});
$(document).ready(function () {
    var chatbox = document.getElementById('fb-customer-chat');
    chatbox.setAttribute("page_id", "113157405151338");
    chatbox.setAttribute("attribution", "biz_inbox");

    <!-- Your SDK code -->
        window.fbAsyncInit = function() {
        FB.init({
            xfbml            : true,
            version          : 'v17.0'
        });
    };

        (function(d, s, id) {
        var js, fjs = d.getElementsByTagName(s)[0];
        if (d.getElementById(id)) return;
        js = d.createElement(s); js.id = id;
        js.src = 'https://connect.facebook.net/en_US/sdk/xfbml.customerchat.js';
        fjs.parentNode.insertBefore(js, fjs);
    }(document, 'script', 'facebook-jssdk'));

});

// var navItems = document.querySelectorAll(".sort-item a");
// for (var i = 0; i < navItems.length; i++) {
//     navItems[i].addEventListener("click", function() {
//         this.classList.add(" active");
//     });
// }

// ------Search Every Where----------




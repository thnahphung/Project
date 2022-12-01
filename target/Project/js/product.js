$(document).ready(function () {
    $('.slider-show-img').slick({
        slidesToShow: 1,
        slidesToScroll: 1,
        arrows: false,
        fade: true,
    });

    $('.slider-img').slick({
        infinite: true,
        slidesToShow: 3,
        slidesToScroll: 1,
        rows: 1,
        asNavFor: '.slider-show-img',
        centerMode: true,
        focusOnSelect: true,
        prevArrow: "<button type='button' class='slick-prev pull-left'><i class='fa fa-angle-left' aria-hidden='true'></i></button>",
        nextArrow: "<button type='button' class='slick-next pull-right'><i class='fa fa-angle-right' aria-hidden='true'></i></button>"

    });
    $('.slider-similar-product').slick({
        infinite: true,
        slidesToShow: 4,
        slidesToScroll: 1,
        centerMode: true,
        focusOnSelect: true,
        prevArrow: "<button type='button' class='slick-prev pull-left'><i class='fa fa-angle-left' aria-hidden='true'></i></button>",
        nextArrow: "<button type='button' class='slick-next pull-right'><i class='fa fa-angle-right' aria-hidden='true'></i></button>"

    });

    $("button.page-link").click(
    function () {
        $("button.page-link").parent('.page-item').removeClass("active");
        $(this).parent('.page-item').addClass("active");

            $.ajax({
                url: "/detailProduct/loadComment",
                type: "get", //send it through get method
                data: {
                    page: $(this).text()
                },
                success: function (response) {
                    $(".list-comment").html(response);
                },
                error: function (xhr) {
                    //Do Something to handle error
                }
            });
        }
    )


    
    $("#submit-cmt").click(function () {
        $.ajax({
            url: "/detailProduct/upComment",
            type: "get", //send it through get method
            data: {
                text:$(".write-cmt").val(),
                rate:$('.lb-cmt .yellow').length
            },
            success: function (response) {
                $(".list-comment").html(response);
            },
            error: function (xhr) {
                //Do Something to handle error
            }
        });
    })


});


$(document).ready(function () {
    const queryString = window.location.search;
    const urlParams = new URLSearchParams(queryString);
    $.ajax({
        url: "/detailProduct/loadComment",
        type: "get",
        data: {
            page: '1',
            id: urlParams.get('id'),
        },
        success: function (response) {
            $(".list-comment").html(response);
        },
        error: function (xhr) {
        }
    });

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
                type: "get",
                data: {
                    page: $(this).text().trim(),
                    id: urlParams.get('id'),
                },
                success: function (response) {
                    $(".list-comment").html(response);
                },
                error: function (xhr) {
                }
            });
        }
    )


    $("#submit-cmt").click(function () {
        let idProduct = urlParams.get("id");
        let value = $(".write-cmt").val();
        let rate = $('.write-ratting .yellow').length;

        $.ajax({
            url: "/detailProduct/upComment",
            type: "get",
            data: {
                text: value,
                rate: rate,
                idProduct: idProduct
            },
            success: function (response) {
                let containListComment = $('.list-comment');
                containListComment.children().last().remove();
                containListComment.prepend(response);
                $(".write-cmt").val("");
            },
            error: function (xhr) {

            }
        });
    })
});


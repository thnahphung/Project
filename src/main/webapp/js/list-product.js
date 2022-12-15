$(window).scroll(function () {
    if ($(this).scrollTop() > 100) {
        $('.scrolltotop').fadeIn();
    } else {
        $('.scrolltotop').fadeOut();
    }
});

// Click event to scroll to top
$('.scrolltotop').click(function () {
    $('html, body').animate({scrollTop: 0}, 1500);
    return false;
});

// ------------Loc san pham theo nhom--------------------
$('.item-groupProduct').click(function () {

    $('.item-groupProduct .button').addClass("active-navbar-left")
    const queryString = window.location.search;
    const urlParams = new URLSearchParams(queryString);
    $.ajax({
        url: "/listProductGroup",
        type: "get", //send it through get method
        data: {
            groups: $(this).text().trim(),
            kind: urlParams.get('kind')

        },
        success: function (response) {
            $(".list-product .row").html(response);
        },
        error: function (xhr) {
            //Do Something to handle error
        }
    });
})

// ---------- Tim kiem -------------
$("#search").click(function () {
    $.ajax({
        url: "/search",
        type: "get", //send it through get method
        data: {
            search: $(".search-input").val(),
        },
        success: function (response) {
            $(".list-product .row").html(response);
        },
        error: function (xhr) {
            //Do Something to handle error
        }
    });
})

//---------- Phan trang -----------

$('.page-item').click(function () {
    alert($(this).text().trim())
    const queryString = window.location.search;
    const urlParams = new URLSearchParams(queryString);
    $.ajax({
        url: "/listProductInPage",
        type: "get",
        data: {
            pages: $(this).text().trim(),
            kind: urlParams.get('kind'),
            group: $('.active-navbar-left').text()
        },
        success: function (response) {
            $(".list-product .row").html(response);
        },
        error: function (xhr) {
            //Do Something to handle error
        }
    })
})
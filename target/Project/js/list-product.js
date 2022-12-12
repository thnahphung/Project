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


$('.item-groupProduct').click(function () {
    alert($(this).html())
    $.ajax({
        url: "/listProductGroup",
        type: "get", //send it through get method
        data: {
            group: $(this).val(),
        },
        success: function (response) {
            $(".list-product .row").html(response);
        },
        error: function (xhr) {
            //Do Something to handle error
        }
    });
})
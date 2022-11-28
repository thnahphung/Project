$(window).scroll(function () {
    if ($(this).scrollTop() > 100) {
        $('.scrolltotop').fadeIn();
    } else {
        $('.scrolltotop').fadeOut();
    }
});

// Click event to scroll to top
$('.scrolltotop').click(function () {
    $('html, body').animate({ scrollTop: 0 }, 1500);
    return false;
});


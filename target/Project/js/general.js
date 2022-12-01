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

    // document ready  
});


// var navItems = document.querySelectorAll(".sort-item a");
// for (var i = 0; i < navItems.length; i++) {
//     navItems[i].addEventListener("click", function() {
//         this.classList.add(" active");
//     });
// }

// ------Search Every Where----------
// $("#search").click(function () {
//     $.ajax({
//         url: "/Searches",
//         type: "get",
//         data: {
//             search: $('.search-input').val()
//         },
//         success: function (response) {
//             $(".list-product .row").html(response);
//         },
//         error: function (xhr) {
//             //Do Something to handle error
//         }
//     })
// })

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
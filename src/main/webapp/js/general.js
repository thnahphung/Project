$(document).ready(function() {


    $(window).scroll(function() {
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
$(document).ready(function () {
    $('.edit-user').click(function () {
        let idUer = $(this).val().trim();
        let varieties = $('.user-varieties' + $(this).val()).val().trim();
        window.location = "/editUserManager?id=" + idUer + "&varieties=" + varieties;
    })
})
$(document).ready(function () {
    $('.edit-user').click(function () {
        var iduer = $(this).val().trim();
        var varieties = $('.input-varieties').val().trim();
        alert(varieties)
        window.location = "/editUserManager?id=" + iduer + "&varieties=" + varieties;

    })
})
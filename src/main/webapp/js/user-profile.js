$(document).ready(function () {

    // change information user
    $('.save-info').click(function () {
        let fullName = $("#input-edit-name").val();
        let phoneNumber = $('#input-edit-phone').val();
        let email = $("#input-edit-email").val();

        if (checkNull(fullName) || checkNull(phoneNumber) || checkNull(email)) {

            return $(".error").text("không");
        }

        $.ajax({
            url: "/userprofile/editUser",
            type: "get", //send it through get method
            data: {
                fullName: fullName,
                phoneNumber: phoneNumber,
                email: email
            },
            success: function (response) {
                $(".inf-left").html(response);
            },
            error: function (xhr) {
                //Do Something to handle error
            }
        });
        $('#formEditInfor').modal('toggle');
    })

    function checkNull(text) {
        return text.length == 0 || text == null;
    }


    $('#address-tab').click(function (){
        window.location = "http://localhost:8080/showAddress";
    })
});
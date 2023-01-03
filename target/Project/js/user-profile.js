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

    // order list

    function getDataOrderList() {
        let table = document.getElementsByClassName('order-list-table');
        let rowCount = table.length;
        for (var i = 1; i < rowCount - 1; i++) {
            var row = table.item(i).toString();
            alert(row);
        }
    }

});
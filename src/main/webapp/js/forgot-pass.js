$(document).ready(function () {
    $('.submit').click(function () {
        let inputcode = $('#input-code').val().trim();
        let pass = $('#input-pass').val();
        let passAgain = $('#input-passAgain').val();


        $.ajax({
            url: "/forgotpass/checkPhoneEmail",
            type: "get", //send it through get method
            data: {
            },
            success: function (response) {
            },
            error: function (xhr) {
                //Do Something to handle error
            }
        });

        if (checkNull(inputcode)) {
            return $("#error").text("Bạn chưa nhập mã!");
        } else if (checkNull(pass) || checkNull(passAgain)) {
            return $("#error").text("Bạn điền chưa đầy đủ thông tin");
        } else if (pass != passAgain) {
            return $("#error").text("Mật khẩu không trùng khớp!");
        }

    })


    $('.send-code').click(function () {
        let phoneEmail = $('#phonemail').val().trim();

        $.ajax({
            url: "/forgotpass/checkPhoneEmail",
            type: "get", //send it through get method
            data: {
                phoneEmail: phoneEmail,
            },

            success: function (response) {
                if (response.trim() == 'true' ) {
                    $('#error').text("");
                } else {
                    $('#error').text('Số điện thoại hoặc Email không tồn tại');
                }
            },
            error: function (xhr) {
                //Do Something to handle error
            }
        });

    })


    function checkNull(text) {
        return text.length == 0 || text == null;
    }


});
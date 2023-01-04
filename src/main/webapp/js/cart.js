$(document).ready(function () {
    let isAppendVoucher = false;
    $('.btn-remove').click(function () {
        let idDetail = $(this).val();
        $(this).closest('.product').remove();

        $.ajax({
            url: "/cart/removeProduct",
            type: "get",
            data: {
                idDetail: idDetail,
            },
            success: function (response) {
                let listResponse = response.replace(/\r/g, "").split(/\n/);
                $('#input-voucher').val('');
                $('.money-sale-voucher').text(0);
                if (parseInt(listResponse[2].trim()) === 0) {
                    removeEmlement();
                } else {
                    $('.total-real').text(listResponse[0] + ' VND');
                    $('.sale').text(listResponse[1] + ' VND');
                    $('.total span').text(listResponse[2]);
                }
                $('.amount-product').text(listResponse[3]);
            },
            error: function (xhr) {

            }
        });
    })

    $('.delete-all').click(function () {
        removeEmlement();
        $('.amount-product').text(0);
        $.ajax({
            url: "/cart/removeAllProduct",
            type: "get",
            data: {},
            success: function (response) {
            },
            error: function (xhr) {

            }
        });
    })

    function removeEmlement() {
        $('.product').remove();
        $('.bill').remove();
        $('.list-product').removeClass('col-8');
        $('.list-product').addClass('col-12');
        $('.container-list-product').html('<li class="notification bd-bottom pb-4 pt-4 uppercase">\n' +
            '            Giỏ hàng của bạn đang trống, quay lại mua hàng nhé!\n' +
            '        </li>');
        $('.delete-all').remove();
        $('.contain-btn').css('justify-content', 'center');
        $('.input-voucher').val('');
    }

    $('.btn-total').click(function () {
        window.location = "http://localhost:8080/shipping";
    })
    $('#submit-voucher').click(function () {

        $.ajax({
            url: "/cart/checkVoucher",
            type: "get",
            data: {
                voucher: $('#input-voucher').val(),
            },
            success: function (response) {
                let listResponse = response.replace(/\r/g, "").split(/\n/);
                $('#mess-voucher').text(listResponse[0]);
                if (listResponse[0] === "") {
                    $('.money-sale-voucher').text(new Intl.NumberFormat('de-DE').format(listResponse[1]));
                    $('.total span').text(new Intl.NumberFormat('de-DE').format(listResponse[2]));
                }

            },
            error: function (xhr) {

            }
        });

    })

})
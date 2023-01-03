$(document).ready(function () {

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
                if (parseInt(listResponse[2].trim()) === 0) {
                    removeEmlement();
                } else {
                    $('.total-real').text(listResponse[0] + ' VND');
                    $('.sale').text(listResponse[1] + ' VND');
                    $('.total').text(listResponse[2] + ' VND');
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
    }
    $('.btn-total').click(function () {
        window.location = "http://localhost:8080/shipping";
    })
})
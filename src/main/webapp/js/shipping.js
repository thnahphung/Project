$(document).ready(function () {
    const queryString = window.location.search;
    const urlParams = new URLSearchParams(queryString);
    let wayShip = $('.contain-way-ship input:radio:checked').val();
    let feeShip;
    if (wayShip === '1') feeShip = 30000;
    else if (wayShip === '2') feeShip = 50000;

    $('.total-price').text(new Intl.NumberFormat('de-DE').format(parseInt($('.total-price').text().replaceAll('.', '')) + feeShip));

    $('.contain-way-ship p').click(function () {
        wayShip = $('.contain-way-ship input:radio:checked').val();
        let oldFeeShip = feeShip;
        if (wayShip === '1') feeShip = 30000;
        else if (wayShip === '2') feeShip = 50000;

        $('.ship-fee').text(new Intl.NumberFormat('de-DE').format(feeShip));
        $('.total-price').text(new Intl.NumberFormat('de-DE').format(parseInt($('.total-price').text().replaceAll('.', '')) - oldFeeShip + feeShip));
    })

    $('.btn-total').click(function () {
        if ($('.contain-address input:radio:checked').val() === undefined) {
            $('#exampleModalCenter').modal({
                show: true
            });
        } else {
            let idAddress = $('.contain-address input:radio:checked').val();
            wayShip = $('.contain-way-ship input:radio:checked').val();
            let payments = $('.contain-pay input:radio:checked').val();
            let voucher = urlParams.get('voucher');
            window.location = 'http://localhost:8080/addOrder?idAddress=' + idAddress + '&wayShip=' + wayShip + '&payments=' + payments + '&voucher=' + voucher;
        }


    })

    $('.btn-add-address').click(function () {
        window.location = 'http://localhost:8080/showAddress';
    })


})

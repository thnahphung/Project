$(document).ready(function () {
    $('#infor-tab').click(function () {
        window.location = "http://localhost:8080/userProfile";
    })

    // change information user
    if (address_2 = localStorage.getItem('address_2_saved')) {
        $('select[name="calc_shipping_district"] option').each(function () {
            if ($(this).text() == address_2) {
                $(this).attr('selected', '')
            }
        })
        $('input.billing_address_2').attr('value', address_2)
    }
    if (district = localStorage.getItem('district')) {
        $('select[name="calc_shipping_district"]').html(district)
        $('select[name="calc_shipping_district"]').on('change', function () {
            var target = $(this).children('option:selected')
            target.attr('selected', '')
            $('select[name="calc_shipping_district"] option').not(target).removeAttr('selected')
            address_2 = target.text()
            $('input.billing_address_2').attr('value', address_2)
            district = $('select[name="calc_shipping_district"]').html()
            localStorage.setItem('district', district)
            localStorage.setItem('address_2_saved', address_2)
        })
    }
    $('select[name="calc_shipping_provinces"]').each(function () {
        var $this = $(this),
            stc = ''
        c.forEach(function (i, e) {
            e += +1
            stc += '<option value=' + e + '>' + i + '</option>'
            $this.html('<option value="">Tỉnh / Thành phố</option>' + stc)
            if (address_1 = localStorage.getItem('address_1_saved')) {
                $('select[name="calc_shipping_provinces"] option').each(function () {
                    if ($(this).text() == address_1) {
                        $(this).attr('selected', '')
                    }
                })
                $('input.billing_address_1').attr('value', address_1)
            }
            $this.on('change', function (i) {
                i = $this.children('option:selected').index() - 1
                var str = '',
                    r = $this.val()
                if (r != '') {
                    arr[i].forEach(function (el) {
                        str += '<option value="' + el + '">' + el + '</option>'
                        $('select[name="calc_shipping_district"]').html('<option value="">Quận / Huyện</option>' + str)
                    })
                    var address_1 = $this.children('option:selected').text()
                    var district = $('select[name="calc_shipping_district"]').html()
                    localStorage.setItem('address_1_saved', address_1)
                    localStorage.setItem('district', district)
                    $('select[name="calc_shipping_district"]').on('change', function () {
                        var target = $(this).children('option:selected')
                        target.attr('selected', '')
                        $('select[name="calc_shipping_district"] option').not(target).removeAttr('selected')
                        var address_2 = target.text()
                        $('input.billing_address_2').attr('value', address_2)
                        district = $('select[name="calc_shipping_district"]').html()
                        localStorage.setItem('district', district)
                        localStorage.setItem('address_2_saved', address_2)
                    })
                } else {
                    $('select[name="calc_shipping_district"]').html('<option value="">Quận / Huyện</option>')
                    district = $('select[name="calc_shipping_district"]').html()
                    localStorage.setItem('district', district)
                    localStorage.removeItem('address_1_saved', address_1)
                }
            })
        })
    })


    // XÓA ĐỊA CHỈ
    $(document).on("click", ".delete-one", function (e) {
        let id = $(this).val();
        $.ajax({
            url: "/userprofile/deleteInformation",
            type: "get", //send it through get method
            data: {
                id: id,
            },
            success: function (response) {
                $(".list-address" + id).html(response);
            },
            error: function (xhr) {
                //Do Something to handle error
            }
        });
    })
    // THÊM ĐỊA CHỈ
    $('.btn-save').click(function () {
        let name = $('#input-name').val();
        let phone = $('#input-number-phone').val();
        let city = $('#input-city').val();
        let district = $('#input-district').val();
        let detail = $("#input-detail").val();
        if (checkNull(name) || checkNull(phone) || checkNull(city) || checkNull(district) || checkNull(detail)) {

            return $(".errorAddAddress").text("Chưa điền đủ thông tin");
        }

        $.ajax({
            url: "/userprofile/addInformation",
            type: "get", //send it through get method
            data: {
                name: name,
                phone: phone,
                city: city,
                district: district,
                detail: detail
            },
            success: function (response) {
                $('.contain-list-address').append(response);
            },
            error: function (xhr) {
                //Do Something to handle error
            }
        }).done(function () {
            $('#exampleAddAddress').modal('toggle');
            window.location = "http://localhost:8080/showAddress";
        })
        ;

    })

    function checkNull(text) {
        return text.length == 0 || text == null;
    }

    $('.btn-delete-all').click(function () {

        $.ajax({
            url: "/userprofile/deleteAllInformation",
            type: "get", //send it through get method
            data: {},
            success: function (response) {
                $(".all-address").html(response);
            },
            error: function (xhr) {
                //Do Something to handle error
            }
        });
        $('#exampleDeleteAllAddress').modal('toggle');

    })
    $('#logout-tab').click(function (){
        window.location = "http://localhost:8080/logOut";
    })
})
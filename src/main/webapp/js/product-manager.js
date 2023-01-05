$(document).ready(function () {
    // $('#category').change(function () {
    //
    // })
    $('#addProduct').click(function () {
        var name = $('#input-name').val();
        var price = $('#input-price').val().trim();
        var priceReal = $('#input-priceReal').val().trim();
        var inventory = $('#input-inventory').val();
        // img: $()
        let category = $('.category').find(":selected").val().trim();
        var detail = $('#input-detail').val();
        var decription = $('#input-decription').val();


        if (name == "" || price == "" || priceReal == "" || inventory == "" || detail == "" || decription == "") {
            alert("Vui lòng kiểm tra lại")
            return;
        }
        window.location = "/admins/addProduct?=name" + name + "&price=" + price + "&priceReal=" + priceReal + "&inventory=" + inventory + "&detail=" + detail + "&decription=" + decription + "&category=" + category;
    })
    // $('.edit-product').click(function () {
    //     alert($(this).val())
    //     $.ajax({
    //         url: "/admins/editProduct",
    //         type: "get",
    //         data: {
    //             id: $(this).val().trim()
    //         },
    //         success: function (response) {
    //             $(".form-edit").html(response);
    //
    //         },
    //         error: function (xhr) {
    //         }
    //     })
    //
    // })
    $('.edit-product').click(function () {

        var idpr = $(this).val().trim()
        alert(idpr)
        $.ajax({
            url: "/admins/editProduct",
            type: "get",
            data: {
                id: idpr
            },
            success: function (response) {
                $(".form-edit").html(response);
            },
            error: function (xhr) {
            }
        }).done(function () {
            $('#edit-pa_category').change(function () {
                $.ajax({
                    url: "/setCategory",
                    type: "get",
                    data: {
                        idcategory: $(this).val().trim()
                    },
                    success: function (data) {
                        $("#edit-category").html(data);

                    },
                    error: function (xhr) {

                    }
                })
            })
            $('#editProduct').click(function () {
                var idpr1 = idpr;
                var name = $('#edit-name').val();
                var price = $('#edit-price').val().trim();
                var priceReal = $('#edit-priceReal').val().trim();
                var inventory = $('#edit-inventory').val().trim();
                // img: $()
                let category = $('.category').find(":selected").val().trim();
                var detail = $('#edit-detail').val();
                var decription = $('#edit-decription').val();

                console.log()
                if (name == "" || price == "" || priceReal == "" || inventory == "" || detail == "" || decription == "") {
                    alert("Vui lòng kiểm tra lại")
                    return;
                }
                window.location = "/admins/editProductinForm?=name" + name + "&price=" + price + "&priceReal=" + priceReal + "&inventory=" + inventory + "&detail=" + detail + "&decription=" + decription + "&category=" + category + "&id=" + idpr1 + "&stt=0";
            })
        }
        )

    })

    $('#input-pa_category').change(function () {
        alert($(this).val())
        $.ajax({
            url: "/setParCategoryProduct",
            type: "get",
            data: {
                idPacategory: $(this).val().trim()
            },
            success: function (data) {
                $("#category").html(data);

            },
            error: function (xhr) {

            }
        })
    })

})




$(document).ready(function () {
    $('#addBanner').click(function () {
        var name = $('#input-name').val();
        var srcIamge = "ádgdkfh";
        if (name == null) {
            alert("kiểm tra lại");
            return;
        }
        window.location = "/addBanner?name=" + name + "&srcImg=" + srcIamge;

    })
    $('.edit-banner').click(function (){
       var idbanner = $(this).val().trim();
       alert(idbanner)
        $.ajax({
            url:"/admins/editBannerForm",
            type:"get",
            data: {
                id:idbanner
            },
            success: function (data) {
                    $('.form-edit').html(data)
            },
            error: function (xhr) {
                
            }
        }).done(function () {
            $('#save-editBanner').click(function (){
                var name = $('#edit-name').val();
                alert(name)
                var srcIamge = "ádgdkfh";
                if (name == null) {
                    alert("kiểm tra lại");
                    return;
                }
                window.location = "/editBannerinForm?name=" + name + "&imgSrc=" + srcIamge+"&id="+idbanner;

            })
        })
    })
    $('.delete-banner').click(function () {
        alert($(this).val())
        var idbanner = $(this).val().trim()
        $.ajax({
            url: "/admins/deleteBanner",
            type: "get",
            data: {
                id: idbanner
            },
            success: function (data) {
                $('.name'+idbanner).remove()
            }
        })
    })

})
<%@ page import="java.util.List" %>
<%@ page import="bean.Format" %>
<%@ page import="bean.Vendor" %>
<%@ page import="bean.Import" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin</title>
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/jquery.dataTables.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css">
    <link rel="stylesheet" href="https://mdbootstrap.com/docs/b4/jquery/getting-started/cdn/">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
          integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"/>
    <link rel="stylesheet" href="css/import-manager.css">
    <link rel="stylesheet" href="css/admin.css">
</head>

<body>
<%@include file="header-admin.jsp" %>
<div class="card-body px-0 pb-2 content">
    <div class="table">
        <div class="table-cart">
            <h2>Danh sách đơn hàng</h2>
            <div class="right">
                <button type="button" class="btn-add-address button submit add">Thêm
                </button>
            </div>

            <table id="dtHorizontalVerticalExample" class="table table-striped table-bordered table-sm "
                   cellspacing="0" width="100%">
                <thead>
                <tr>
                    <th>Ngày nhập hàng</th>
                    <th>Nhà cung cấp</th>
                    <th>Số điện thoại</th>
                    <th>Số lượng sản phẩm</th>
                    <th>Nhân viên nhập kho</th>
                    <th>Trạng thái đơn hàng</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <% List<Import> list = (List<Import>) request.getAttribute("importList");
                    for (Import anImpor : list) {%>
                <tr class="product-<%=anImpor.getId()%>">
                    <td><%=anImpor.getCreateDate()%>
                    </td>
                    <td><%=anImpor.getVendor().getInformation().getName()%>
                    </td>
                    <td><%=anImpor.getVendor().getInformation().getPhone()%>
                    </td>
                    <td><%=anImpor.getStatus()%>
                    </td>
                    <td><%=anImpor.getUserImport().getName()%>
                    </td>
                    <td><%=anImpor.getStatustoString()%>
                    </td>
                    <td>
                        <button class="edit-product button submit" value="<%=anImpor.getId()%>">
                            sữa
                        </button>
                    </td>

                </tr>
                <%}%>
                </tbody>
            </table>


        </div>
    </div>
</div>

<script type="text/javascript">
    <%--    tìm kiếm --%>

    function searchByAll(param) {
        var txtSearch = param.value;
        console.log(txtSearch)
        $.ajax({
                url: "/searchVendor",
                type: "get",
                data: {
                    txtSearch: txtSearch
                },
                success: function (data) {
                    var row = document.getElementById('vendor-item');
                    row.innerHTML = data;
                }
            }
        )
    }

    function show() {
        document.getElementById('addVendorForm').style.display = "block";
    }

    function hide() {
        document.getElementById('addVendorForm').style.display = "none";
    }

</script>

<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script type="text/javascript" src="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
        integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js"
        integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"
        integrity="sha512-aVKKRRi/Q/YV+4mjoKBsE4x3H+BkegoM/em46NNlCqNTmUYADjBbeNefNxYV7giUp0VxICtqdrbqU7iVaeZNXA=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<!-- <script src="js/general.js"></script> -->
<script src="js/jquery.dataTables.min.js"></script>
<script src="js/admin.js"></script>
</body>

</html>
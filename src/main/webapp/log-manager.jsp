<%--
  Created by IntelliJ IDEA.
  User: phuon
  Date: 6/26/2023
  Time: 12:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="bean.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Quản lý log</title>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css">
    <%--    <link rel="stylesheet" href="https://mdbootstrap.com/docs/b4/jquery/getting-started/cdn/">--%>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
          integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <link rel="stylesheet" href="css/jquery.dataTables.min.css">
    <link rel="stylesheet" href="css/admin.css">
    <link rel="stylesheet" href="css/product-manager.css">

</head>
<body>
<%@include file="header-admin.jsp" %>
<% List<Log> logs = (List<Log>) request.getAttribute("logs");%>
<div class="content">
    <div class="table">
        <div class="table-cart">
            <h2>Log các sự kiện trong toàn bộ hệ thống</h2>
            <div class="right">
                <button class="delete button submit">Xóa</button>
            </div>
            <table id="dtHorizontalVerticalExample" class="table table-striped table-bordered table-sm "
                   cellspacing="0" width="100%">
                <thead>
                <tr>
                    <th><input type="checkbox" name="select-all" id="select-all"></th>
                    <th>Địa chỉ IP</th>
                    <th>Id người dùng</th>
                    <th>Độ nghiêm trọng</th>
                    <th>Sự kiện</th>
                    <th>Mô tả</th>
                    <th>Ngày</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <% for (Log log : logs) {%>
                <tr class="log-<%=log.getId()%>">
                    <td><input type="checkbox" value="<%=log.getId()%>" class="checkbox-log"></td>
                    <td><%=log.getIp()%>
                    </td>
                    <td><%= log.getUserId()%>
                    </td>
                    <% if (log.getSeverityLevel() == 1) { %>
                    <td>DEBUG</td>
                    <% }%>
                    <% if (log.getSeverityLevel() == 2) { %>
                    <td>INFO</td>
                    <% }%>
                    <% if (log.getSeverityLevel() == 3) { %>
                    <td>WARN</td>
                    <% }%>
                    <% if (log.getSeverityLevel() == 4) { %>
                    <td>ERROR</td>
                    <% }%>
                    <% if (log.getSeverityLevel() == 5) { %>
                    <td>FATAL</td>
                    <% }%>
                    </td>
                    <td><%=log.getEvent()%>
                    </td>
                    <td><%=log.getDescription()%>
                    </td>
                    <td><%=log.getCreateDate()%>
                    </td>
                    <td>
                        <button class="log-detail button submit" value="<%=log.getId()%>"
                                data-toggle="modal"
                                data-target="#exampleModalCenterEdit">
                            Chi tiết
                        </button>
                    </td>
                </tr>
                <%}%>
                </tbody>
            </table>


        </div>
    </div>

</div>
<script src="https://cdn.jsdelivr.net/npm/chart.js@4.2.1/dist/chart.umd.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
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
<script src="js/jquery.dataTables.min.js"></script>
<script src="js/admin.js"></script>
<script>
    $('.delete').click(function () {
        console.log("click")
        $('.checkbox-log:checked').each(function () {
            console.log(15468)
            $.ajax({
                url: "/deleteLog",
                type: "get",
                data: {
                    id: $(this).val().trim()
                }, success: function (data) {
                }
            })
            console.log('.log-' + $(this).val().trim());
            $('.log-' + $(this).val().trim()).css('display', 'none');
        });

    })
</script>
</body>
</html>

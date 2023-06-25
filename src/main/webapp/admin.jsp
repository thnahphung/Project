<%@ page import="java.util.List" %>
    <%@ page import="bean.Order" %>
        <%@ page import="bean.Format" %>
            <%@ page import="services.OrderService" %>
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
                        <link rel="stylesheet"
                            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css">
                        <link rel="stylesheet" href="https://mdbootstrap.com/docs/b4/jquery/getting-started/cdn/">
                        <link rel="stylesheet"
                            href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
                            integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
                            crossorigin="anonymous">
                        <link rel="stylesheet" type="text/css"
                            href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css" />

                        <link rel="stylesheet" href="css/admin.css">
                    </head>

                    <body>
                        <%@include file="header-admin.jsp" %>
                            <div class="content">
                                <% List<Order> list = (List<Order>) request.getAttribute("orderList");
                                        %>
                                        <div class="row">
                                            <div class="col-sm">
                                                <div class="top">
                                                    <div class="icon i-gray"><img src="" alt=""><i
                                                            class="fa-solid fa-cash-register"></i></div>
                                                    <div class="title-number">
                                                        <p class="title">Tổng doanh thu</p>
                                                        <p class="number"> 720 VND</p>
                                                    </div>
                                                </div>
                                                <div class="bottom">

                                                    <p class="percent green">+55%</p>
                                                    <p>so với hôm qua</p>

                                                </div>

                                            </div>
                                            <div class="col-sm">
                                                <div class="top">
                                                    <div class="icon i-red"><img src="" alt=""><i
                                                            class="fa-solid fa-user "></i></div>
                                                    <div class="title-number">
                                                        <p class="title">Số lượng khách hàng</p>
                                                        <p class="number">
                                                            <%=request.getAttribute("member")%> Người
                                                        </p>
                                                    </div>
                                                </div>
                                                <div class="bottom">

                                                    <p class="percent red">-10%</p>
                                                    <p>so với hôm qua</p>

                                                </div>

                                            </div>
                                            <div class="col-sm">
                                                <div class="top">
                                                    <div class="icon i-green"><img src="" alt=""><i
                                                            class="fa-solid fa-cart-shopping"></i></div>
                                                    <div class="title-number">
                                                        <p class="title">Tổng số đơn hàng</p>
                                                        <p class="number">
                                                            <%=list.size()%> Đơn
                                                        </p>
                                                    </div>
                                                </div>
                                                <div class="bottom">

                                                    <p class="percent green">+25%</p>
                                                    <p>so với hôm qua</p>

                                                </div>

                                            </div>
                                            <div class="col-sm">
                                                <div class="top">
                                                    <div class="icon i-blue"><img src="" alt=""><i
                                                            class="fa-solid fa-eye"></i></div>
                                                    <div class="title-number">
                                                        <p class="title">Số lượt xem trang web</p>
                                                        <p class="number">720 lượt</p>
                                                    </div>
                                                </div>
                                                <div class="bottom">

                                                    <p class="percent red">-5%</p>
                                                    <p>so với hôm qua</p>

                                                </div>

                                            </div>


                                        </div>
                                        <div class="table">
                                            <div class="table-cart">
                                                <h2>Lịch sử đơn hàng</h2>
                                                <button class="submit" onclick="dowloadOrders()">Tải dạng Excel</button>
                                                <table id="dtHorizontalVerticalExample"
                                                    class="table table-striped table-bordered table-sm " cellspacing="0"
                                                    width="100%">
                                                    <thead>
                                                        <tr>
                                                            <th>Mã hóa đơn</th>
                                                            <th>Tên khách hàng</th>
                                                            <th>Số điện thoại</th>
                                                            <th>Ngày tạo HĐ</th>
                                                            <th>Thành tiền</th>
                                                            <th>Thanh toán</th>
                                                            <th>Tình trạng</th>
                                                            <th></th>
                                                            <th></th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <% for (Order order : list) { %>
                                                            <tr data-toggle="modal"
                                                                data-target="#exampleModalCenterEdit">
                                                                <td class="order-id">
                                                                    <%=order.getId()%>
                                                                </td>
                                                                <td class="name">
                                                                    <%=order.getUser().getName()%>
                                                                </td>
                                                                <%-- <td>
                                                                    <%=order.getInformation().getAddress().getDetail()%>
                                                                        --%>
                                                                        <%-- ,
                                                                            <%=order.getInformation().getAddress().getDistrict()%>--%>
                                                                            <%-- ,
                                                                                <%=order.getInformation().getAddress().getCity()%>--%>
                                                                                <%-- </td>--%>
                                                                                    <td>
                                                                                        <%=order.getInformation().getPhone()%>
                                                                                    </td>
                                                                                    <td>
                                                                                        <%=order.getCreateDate()%>
                                                                                    </td>
                                                                                    <td>
                                                                                        <%=Format.format(OrderService.getInstance().total(order))%>
                                                                                    </td>
                                                                                    <td>
                                                                                        <%=order.isPayment()
                                                                                            ? "đã thanh toán"
                                                                                            : "chưa thanh toán" %>
                                                                                    </td>
                                                                                    <% if (order.getStatusDelivery()==0)
                                                                                        {%>
                                                                                        <td> Chờ xác nhận
                                                                                        </td>
                                                                                        <%}%>

                                                                                            <td>
                                                                                                <button
                                                                                                    class="detail-order submit"
                                                                                                    value="<%=order.getId()%>">Chi
                                                                                                    tiết</button>
                                                                                            </td>
                                                                                            <td>
                                                                                                <button
                                                                                                    class="register-transport submit"
                                                                                                    value="<%=order.getId()%>">Xác
                                                                                                    nhận</button>
                                                                                            </td>
                                                                                            <div id="<%="
                                                                                                to-district-id-"+order.getId()%>
                                                                                                " style="display: none">
                                                                                                <%=order.getInformation().getAddress().getDistrictId()%>
                                                                                            </div>
                                                                                            <div id="<%="
                                                                                                to-ward-id-"+order.getId()%>
                                                                                                "
                                                                                                style="display: none">
                                                                                                <%=order.getInformation().getAddress().getWardId()%>
                                                                                            </div>
                                                            </tr>
                                                            <%}%>

                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                        <div class="contain-all-year">
                                            <div>
                                                <span class="uppercase">Thống kê tất cả các năm </span>
                                            </div>
                                            <canvas id="statistical-all-year"></canvas>
                                        </div>

                                        <div class="modal fade" id="exampleModalCenterEdit" tabindex="-1" role="dialog"
                                            aria-labelledby="exampleModalCenterTitle" aria-hidden="true"
                                            style="width: 100%;">
                                            <div class="modal-dialog modal-dialog-centered" role="document">
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <h5 class="modal-title uppercase" id="Title">Chi tiết đơn hàng
                                                        </h5>
                                                        <button type="button" class="close" data-dismiss="modal"
                                                            aria-label="Close">
                                                            <span aria-hidden="true">&times;</span>
                                                        </button>
                                                    </div>
                                                    <div class="modal-body form-detail">
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                            </div>

                            <script src="https://cdn.jsdelivr.net/npm/chart.js@4.2.1/dist/chart.umd.min.js"></script>
                            <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
                                integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
                                crossorigin="anonymous"></script>
                            <script type="text/javascript"
                                src="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
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
                            <!-- use xlsx.full.min.js from version 0.20.0 -->
                            <script lang="javascript"
                                src="https://cdn.sheetjs.com/xlsx-0.20.0/package/dist/xlsx.full.min.js"></script>
                            <script src="js/api-logistic.js"></script>
                            <script src="js/admin.js"></script>

                            <script>
                                const canvas = $('#statistical-year');
                                const canvasAll = $('#statistical-all-year');
                                login();
                                // Xác nhận vận chuyển
                                $('.register-transport').on('click', function () {
                                    const orderId = $(this).val();
                                    $.ajax({
                                        url: "http://140.238.54.136/api/registerTransport",
                                        type: "post",
                                        data: {
                                            from_district_id: 1451,
                                            from_ward_id: 20911,
                                            to_district_id: $('#to-district-id-' + orderId).text().trim(),
                                            to_ward_id: $('#to-ward-id-' + orderId).text().trim(),
                                            height: 100,
                                            length: 100,
                                            width: 100,
                                            weight: 100
                                        },
                                        beforeSend: function (xhr) {
                                            xhr.setRequestHeader('Authorization', 'Bearer ' + accessToken);
                                        },
                                        headers: {
                                            "X-Requested-With": "XMLHttpRequest"
                                        },
                                        success: function (response) {
                                            console.log(response);
                                        },
                                        error: function (xhr) {
                                        }
                                    });
                                })

                                const labels = ['Tháng 1', 'Tháng 2', 'Tháng 3', 'Tháng 4', 'Tháng 5', 'Tháng 6', 'Tháng 7', 'Tháng 8', 'Tháng 9', 'Tháng 10', 'Tháng 11', 'Tháng 12'];
                                const listColor = ['rgb(75, 192, 192)', 'rgb(248, 111, 3)', 'rgb(34, 166, 153)']

                                // const data = {
                                //     labels: labels,
                                //     datasets: [{
                                //         label: 'Số lượng đơn hàng',
                                //         data: [],
                                //         fill: true,
                                //         borderColor: 'rgb(75, 192, 192)',
                                //         tension: 0.1
                                //     }]
                                // };
                                // const config = {
                                //     type: 'line',
                                //     data: data,
                                // };
                                // const chart = new Chart(canvas, config);
                                //
                                // loadChartYear(2023, chart);
                                //
                                // function loadChartYear(year, chart) {
                                //     let dataset;
                                //     $.ajax({
                                //         url: "/getStatisticalOrderInYear",
                                //         type: "post",
                                //         data: {
                                //             year: year,
                                //         },
                                //         success: function (response) {
                                //             dataset = JSON.parse(response);
                                //             chart.data.datasets[0].data = dataset;
                                //             chart.update();
                                //         },
                                //         error: function (xhr) {
                                //         }
                                //     })
                                // }

                                // $(document).on('change', '#select-year', function () {
                                //     const selectYear = $('#select-year');
                                //     const year = selectYear.val();
                                //     loadChartYear(year, chart);
                                //
                                // });
                                //------------------------------------------All YEAR

                                const dataAll = {
                                    labels: labels,
                                    datasets: []
                                };
                                const configAll = {
                                    type: 'line',
                                    data: dataAll,
                                };
                                const chartAll = new Chart(canvasAll, configAll);

                                loadAllYear(chartAll);

                                function loadAllYear(chart) {
                                    let dataset;
                                    let year = 2022;
                                    $.ajax({
                                        url: "/getStatisticalOrderAllYear",
                                        type: "get",
                                        data: {},
                                        success: function (response) {
                                            let res = response.replace(/\r/g, "").split(/\n/);
                                            for (let i = 0; i < res.length - 1; i++) {
                                                dataset = JSON.parse(res[i]);
                                                chart.data.datasets.push({
                                                    label: 'Số lượng đơn hàng ' + (year + i),
                                                    data: dataset,
                                                    fill: false,
                                                    borderColor: listColor[i],
                                                    tension: 0.1
                                                });
                                            }
                                            chart.update();
                                        },
                                        error: function (xhr) {
                                        }
                                    })
                                }

                                //============================================================EXCEL
                                /* flatten objects */
                                function dowloadOrders() {
                                    $.ajax({
                                        url: "/getListOrderJSON",
                                        type: "get",
                                        data: {},
                                        success: function (response) {
                                            const rows = JSON.parse(response);
                                            let rows2 = [];
                                            for (let i = 0; i < rows.length; i++) {
                                                rows2.push({
                                                    name: rows[i].id,
                                                    birthday: rows[i].userName,
                                                    year: rows[i].total,
                                                    day: rows[i].address,
                                                    month: rows[i].items,
                                                    yeah: rows[i].createDate,
                                                })
                                            }

                                            /* generate worksheet and workbook */
                                            const worksheet = XLSX.utils.json_to_sheet(rows2);
                                            const workbook = XLSX.utils.book_new();
                                            XLSX.utils.book_append_sheet(workbook, worksheet, "Dates");

                                            /* fix headers */
                                            XLSX.utils.sheet_add_aoa(worksheet, [["id", "nguoi mua", "tong", "dia chi", "san pham", "ngay tao don"]], { origin: "A1" });

                                            /* calculate column width */

                                            const max_width = rows2.reduce((w, r) => Math.max(w, r.name.length), 10);
                                            worksheet["!cols"] = [{ wch: max_width }];
                                            /* create an XLSX file and try to save to Presidents.xlsx */
                                            XLSX.writeFile(workbook, "list-order.xlsx", { compression: true });
                                        },
                                        error: function (xhr) {
                                        }
                                    })

                                }
                            </script>
                    </body>

                    </html>
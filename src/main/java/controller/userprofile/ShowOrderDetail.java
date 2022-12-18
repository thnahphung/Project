package controller.userprofile;

import bean.Order;
import services.OrderService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ShowOrderDetail", value = "/showOrderDetail")
public class ShowOrderDetail extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int orderId = Integer.parseInt(request.getParameter("orderId"));
        Order order = OrderService.getInstance().getOrderByOrderId(orderId);
        request.setAttribute("order", order);
        request.getRequestDispatcher("order-detail.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

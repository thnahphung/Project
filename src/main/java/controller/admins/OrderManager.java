package controller.admins;

import bean.Order;
import bean.User;
import services.OrderService;
import services.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "OrderManager", value = "/orderManager")
public class OrderManager extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("authAdmin");
        if (user.getVarieties() != 1 && user.getVarieties() != 3) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        String name = "Quản lý đơn hàng";
        List<Order> list = OrderService.getInstance().getOrderList();
        int member = UserService.getInstance().getListUser().size();
        int total = 0;
        for (Order o: list) {
            total += o.getTotal();
        }
        request.setAttribute("total",total);
        request.setAttribute("orderList", list);
        request.setAttribute("name",name);
        request.setAttribute("member",member);
        request.getRequestDispatcher("admin.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

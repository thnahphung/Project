package controller.userprofile;

import bean.Order;
import bean.User;
import db.DBProperties;
import services.OrderService;
import services.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.List;

@WebServlet(name = "UserProfile", value = "/userProfile")
public class UserProfile extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       User userNull = new User(3, "Quynh Nhuw", "0819", "nhuw@gmail.com", "pass","","");
        User user = (User) request.getSession().getAttribute("auth");
        request.getSession().setAttribute("auth", userNull);

        List<Order> orders = OrderService.getInstance().getOrderListByUserId(userNull.getUserId());
        request.setAttribute("orders", orders);
        request.getRequestDispatcher("user-profile.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

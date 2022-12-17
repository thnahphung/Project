package controller.cart;

import bean.Order;
import bean.User;
import services.OrderDetailService;
import services.OrderService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RemoveAllProduct", value = "/cart/removeAllProduct")
public class RemoveAllProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("auth");

        Order cart = OrderService.getInstance().getCartByUserId(user.getUserId());
        OrderService.getInstance().removeAllDetailByOrderId(cart.getOrderId());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

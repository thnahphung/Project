package controller.cart;

import bean.Order;
import bean.User;
import services.OrderService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Cart", value = "/cart")
public class Cart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        User user = (User) request.getSession().getAttribute("auth");
        if (user == null) {
            return;
        }

        Order cart = OrderService.getInstance().getCartByUserId(user.getUserId());
        request.setAttribute("cart", cart);
        request.getRequestDispatcher("cart.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

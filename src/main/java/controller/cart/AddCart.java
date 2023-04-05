package controller.cart;

import bean.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddCart", value = "/cart/addCart")
public class AddCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        User user = (User) request.getSession().getAttribute("auth");
        if (user == null) {
            return;
        }
        int idProduct = Integer.parseInt(request.getParameter("idProduct"));

        int amount = Integer.parseInt(request.getParameter("amount"));

        Order cart = (Order) request.getSession().getAttribute("cart");

        cart.addProduct(idProduct, amount);
        response.getWriter().println(cart.amount());

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

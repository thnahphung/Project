package controller.cart;

import bean.Format;
import bean.Order;
import bean.User;
import services.OrderDetailService;
import services.OrderService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RemoveProduct", value = "/cart/removeProduct")
public class RemoveProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idDetail = Integer.parseInt(request.getParameter("idDetail"));

        Order cart = (Order) request.getSession().getAttribute("cart");
        cart.removeDetail(idDetail);

        response.getWriter().println(Format.format(cart.total()));
        response.getWriter().println(Format.format(cart.totalReal() - cart.total()));
        response.getWriter().println(Format.format(cart.totalReal()));
        response.getWriter().println(cart.amount());

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

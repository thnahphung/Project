package controller.cart;

import bean.Cart;
import bean.Product;
import bean.User;
import services.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RemoveProduct", value = "/cart/removeProduct")
public class RemoveProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idProduct = Integer.parseInt(request.getParameter("idProduct"));
        User user = (User) request.getSession().getAttribute("auth");
        Product product = ProductService.getInstance().getProductById(idProduct);

        user.setListCartItem(Cart.removeItemCart(user.getListCartItem(), product));

        response.getWriter().println(Format.format(cart.total()));
        response.getWriter().println(Format.format(cart.totalReal() - cart.total()));
        response.getWriter().println(Format.format(cart.totalReal()));
        response.getWriter().println(cart.amount());

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

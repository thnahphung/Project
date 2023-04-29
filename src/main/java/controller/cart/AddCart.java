package controller.cart;

import bean.Cart;
import bean.LineItem;
import bean.Product;
import bean.User;
import services.CartService;
import services.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.sound.sampled.Line;
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

        Product product = ProductService.getInstance().getProductById(idProduct);

        LineItem lineItem = new LineItem(product, amount);

        user.addToCart(lineItem);

        response.getWriter().println(Cart.sumQuantity(user.getListCartItem()));



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

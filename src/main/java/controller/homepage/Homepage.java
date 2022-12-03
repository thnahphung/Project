package controller.homepage;

import bean.Product;
import services.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Homepage", value = "/homepage")
public class Homepage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> favouriteProducts = ProductService.getInstance().getListFavouriteProduct();
        request.setAttribute("favouriteProducts", favouriteProducts);

        List<Product> newProducts = ProductService.getInstance().getNewProducts();
        request.setAttribute("newProducts", newProducts);

        request.getRequestDispatcher("home-page.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

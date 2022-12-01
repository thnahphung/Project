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
        System.out.println("favouriteProducts"+favouriteProducts);
        List<Product> newProducts = ProductService.getInstance().getNewProducts();
        request.setAttribute("newProducts", newProducts);
        System.out.println("newProducts"+newProducts);

        List<Product> topWoodProducts = ProductService.getInstance().getTopProducts(ProductService.WOOD);
        request.setAttribute("topWoodProducts", topWoodProducts);
        System.out.println("topWoodProducts"+topWoodProducts);

        List<Product> topCeramicProducts = ProductService.getInstance().getTopProducts(ProductService.CERAMIC);
        request.setAttribute("topCeramicProducts", topCeramicProducts);
        System.out.println("topCeramicProducts"+topCeramicProducts);

        List<Product> topPaintingProducts = ProductService.getInstance().getTopProducts(ProductService.WOOD);
        request.setAttribute("topPaintingProducts", topPaintingProducts);
        System.out.println("topPaintingProducts"+topPaintingProducts);

        System.out.println(12);
        request.getRequestDispatcher("home-page.jsp").forward(request, response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

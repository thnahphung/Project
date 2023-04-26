package controller;

import bean.Product;
import bean.Review;
import services.ProductService;
import services.ReviewService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShowDetailProduct", value = "/detail-product")
public class ShowDetailProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idProduct = Integer.parseInt(request.getParameter("id"));

        Product product = ProductService.getInstance().getProductById(idProduct);
        request.setAttribute("product", product);

        List<Review> listReview = ReviewService.getInstance().getListReviewByPage(idProduct, 1);
        request.setAttribute("listReview", listReview);

        int countPage = ReviewService.getInstance().getCountPageById(idProduct);
        request.setAttribute("countPage", countPage);

        List<Product> listSameProduct = ProductService.getInstance().getListSameProduct(product.getCategory().getPaCategory().getId());
        request.setAttribute("listSameProduct", listSameProduct);
        System.out.println(listSameProduct.size());

        request.getRequestDispatcher("product.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

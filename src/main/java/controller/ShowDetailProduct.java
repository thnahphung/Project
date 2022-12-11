package controller;

import bean.Comment;
import bean.Product;
import services.CommentService;
import services.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ShowDetailProduct", value = "/detail-product")
public class ShowDetailProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        Product product = ProductService.getInstance().getProductById(id);
        request.setAttribute("product", product);

        List<String> listImg = ProductService.getInstance().getImageOfProductById(id);
        request.setAttribute("listImg", listImg);

        List<Comment> listCmt = CommentService.getInstance().getCommentByPage(id, 1);
        request.setAttribute("listCmt", listCmt);

        int countPage = CommentService.getInstance().getCountPageById(id);
        request.setAttribute("countPage", countPage);

        List<Product> listSameProduct = ProductService.getInstance().getListProductByKind(product.getCategory().getCategoryId());


        request.getRequestDispatcher("product.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

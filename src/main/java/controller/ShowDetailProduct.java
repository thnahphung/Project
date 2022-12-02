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
        int page = Integer.parseInt(request.getParameter("page"));

        int size = CommentService.getInstance().getCountCommentById(id) / 5;
        int amountPage = CommentService.getInstance().getCountCommentById(id) % 5 > 0 ? size + 1 : size;

        Product product = ProductService.getInstance().getProductById(id);

        List<String> listImg = ProductService.getInstance().getImageOfProductById(id);

        List<Comment> comments = CommentService.getInstance().getCommentOfProductByPage(id, page);

//        List<Product> listSameProduct = ProductService.getInstance().getListProductByKind(product.getPaCategory());


        request.setAttribute("product", product);
        request.setAttribute("listImg", listImg);
        request.setAttribute("listCmt", comments);
        request.setAttribute("page", page);
        request.setAttribute("amountPage", amountPage);

        request.getRequestDispatcher("product.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

package controller;

import bean.Product;
import services.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListProduct", value = "/listProduct")
public class ListProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int  kind = Integer.parseInt(request.getParameter("kind"));
        int page = Integer.parseInt(request.getParameter("page"));
        List<Product> list = ProductService.getInstance().getListTopProduct(kind,page);
        int count = ProductService.getInstance().getcountProduct(kind);
        request.setAttribute("list",list);
        request.setAttribute("kind",kind);
        request.setAttribute("page",page);
        request.getRequestDispatcher("list-product.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}

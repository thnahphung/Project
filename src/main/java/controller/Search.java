package controller;

import bean.Product;
import services.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Search", value = "/search")
public class Search extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String search = request.getParameter("txName");
//        String sort = request.getParameter("sort");
//        int page = Integer.parseInt(request.getParameter("page"));
//        int group = Integer.parseInt(request.getParameter("group"));
//        int kind = Integer.parseInt(request.getParameter("kind"));
//
//        List<Product> list = ProductService.getInstance().getListProductInSearch(kind, group, page, sort, search);
//        request.setAttribute("search", search);
//        request.setAttribute("sort",sort);
//        request.getRequestDispatcher("/listProduct?kind=0&group=0&page=1&sort=0").forward(request, response);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        String action = request.getParameter("action");
//        request.setAttribute("action", action);
//        if (action.equals("search")) {
//            String search = request.getParameter("txName");
//            request.setAttribute("search", search);
//            request.getRequestDispatcher("/listProduct?kind=0&group=0&page=1&sort=0").forward(request, response);
//        }
//    }
}

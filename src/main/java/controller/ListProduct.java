package controller;

import bean.Category;
import bean.Product;
import services.CaterogyService;
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
        int kind = Integer.parseInt(request.getParameter("kind"));
        int page = Integer.parseInt(request.getParameter("page"));
        String sort = request.getParameter("sort");
        int group = Integer.parseInt(request.getParameter("group"));
//        String search = request.getParameter("txName");
        int size = ProductService.getInstance().getCountProduct(kind, group) / 15;
        int count = ProductService.getInstance().getCountProduct(kind, group) % 15 > 0 ? size + 1 : size;
        List<Product> list = ProductService.getInstance().getListProductInPage(kind, group, page, sort);// danh sach san pham theo trang
//        List<Product> listSearch = ProductService.getInstance().getListProductInSearch(search);

        request.setAttribute("list", list);
        request.setAttribute("kind", kind);
        request.setAttribute("page", page);
        request.setAttribute("sort", sort);
        request.setAttribute("count", count);
        request.setAttribute("group", group);
//        request.setAttribute("txName", search);
        List<Category> categories = CaterogyService.getInstance().getListCategory(kind);
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("list-product.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}

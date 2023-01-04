package controller;

import bean.Category;
import bean.PaCategory;
import bean.Product;
import services.CaterogyService;
import services.PaCategoryService;
import services.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductManager", value = "/ProductManager")
public class ProductManager extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> list = ProductService.getInstance().getListProduct();
        List<PaCategory> listPaCategories = PaCategoryService.getInstance().getListCategory();
        List<Category> categoryList  = CaterogyService.getInstance().getListCategory(1);
        int quantity = list.size();
        request.setAttribute("quantity",quantity);
        request.setAttribute("list", list);
        request.setAttribute("listPacategories", listPaCategories);
        request.setAttribute("listCategory",categoryList);
        request.getRequestDispatcher("product-manager.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

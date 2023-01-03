package controller.admins;

import bean.Product;
import bean.ProductDetail;
import services.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet(name = "AddProduct", value = "/admins/addProduct")
public class AddProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        int size = ProductService.getInstance().getListProduct().size();
        int price = Integer.parseInt(request.getParameter("price"));
        int priceReal = Integer.parseInt(request.getParameter("priceReal"));
        int group = Integer.parseInt(request.getParameter("category"));
        int inventory = Integer.parseInt(request.getParameter("inventory"));
        String imgSrc = "";
        String detail = request.getParameter("detail");
        String decription = request.getParameter("decription");
        Part file = request.getPart("img");
        String img = file.getSubmittedFileName();

        ProductDetail productDetail = new ProductDetail(size + 1, decription, detail, null, inventory, LocalDateTime.now(), null, 0, 3);
        ProductService.getInstance().addProductDetail(productDetail);
        Product product = new Product(size + 1, group, name, price, priceReal, 0, imgSrc, productDetail);
        ProductService.getInstance().addProduct(product);
        response.sendRedirect("/ProductManager");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}

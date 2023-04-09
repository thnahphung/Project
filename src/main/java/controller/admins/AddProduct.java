package controller.admins;

import bean.Category;
import bean.HistoryPrice;
import bean.Product;
import bean.User;
import services.HistoryPriceService;
import services.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@WebServlet(name = "AddProduct", value = "/admins/addProduct")
public class AddProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        int sizeProduct = ProductService.getInstance().getListProduct().size();
        int sizeHPrice =
        int price = Integer.parseInt(request.getParameter("price"));
        int priceSale = Integer.parseInt(request.getParameter("priceReal"));
        int group = Integer.parseInt(request.getParameter("category"));
        int inventory = Integer.parseInt(request.getParameter("inventory"));
        User user = (User) request.getSession().getAttribute("authAdmin");
        String imgSrc = "";
        HistoryPrice historyPrice = new HistoryPrice();
//        List<HistoryPrice>  historyPriceList = HistoryPriceService.getInstance().addHistoryPriceByIdProduct(sizeProduct + 1,historyPrice);
        String detail = request.getParameter("detail");
        String decription = request.getParameter("decription");
        Category category = new Category();
        Product product = new Product(sizeProduct + 1, name, decription, detail, 0, ,category, user.getId(),0);
        ProductService.getInstance().addProduct(product);
        System.out.println("đã thêm");
//        response.sendRedirect("/admins/uploadImageProduct");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}

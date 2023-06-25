package controller.admins;

import bean.Order;
import bean.Product;
import services.OrderService;
import services.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GetListProductJSON", value = "/getListProductJSON")
public class GetListProductJSON extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = ProductService.getInstance().getListProduct();
        String json = "[";
        for (Product product : products) {
            json += "{";
            json += "\"id\":\"" + product.getId() + "\",";
            json += "\"name\": \"" + product.getName() + "\",";
            json += "\"category\":\"" + product.getCategory().getName() + "\",";
            json += "\"price\": \"" + product.getPrice() + "\",";
            json += "\"rate\": \"" + product.getRate() + "\",";
            json += "\"createDate\":\"" + product.getCreateDate() + "\"";

            json += "},";
        }
        String result = json.substring(0, json.length() - 1);
        result += "]";
        response.getWriter().print(result);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

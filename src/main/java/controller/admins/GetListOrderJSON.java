package controller.admins;

import bean.Order;
import services.OrderService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GetListOrderJSON", value = "/getListOrderJSON")
public class GetListOrderJSON extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Order> orders = OrderService.getInstance().getOrderList();
        String json = "[";
        for (Order order : orders) {
            json += "{";
            json += "\"id\":\"" + order.getId() + "\",";
            json += "\"userName\": \"" + order.getUser().getName() + "\",";
            json += "\"address\":\"" + order.getInformation().getAddress().formatAddress() + "\",";
            json += "\"items\": \"" + order.getListOrderItem() + "\",";
            json += "\"createDate\": \"" + order.getCreateDate() + "\",";
            json += "\"total\":\"" + order.getTotal()+"\"";

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

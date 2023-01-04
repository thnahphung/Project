package controller.shipping;

import bean.Address;
import bean.Discount;
import services.AddressService;
import services.DiscountService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Shipping", value = "/shipping")
public class Shipping extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Discount discount = DiscountService.getInstance().getDiscountByCode(request.getParameter("voucher"));
        request.setAttribute("voucher", discount);
        request.getRequestDispatcher("shipping.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

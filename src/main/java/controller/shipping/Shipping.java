package controller.shipping;

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
        User user = (User) request.getSession().getAttribute("auth");
        Discount discount = DiscountService.getInstance().getDiscountByCode(request.getParameter("voucher"));
        List<Address> addressList = AddressService.getInstance().getListAddressByUserId(user.getUserId());

        request.setAttribute("voucher", discount);
        request.setAttribute("addressList", addressList);
        request.getRequestDispatcher("shipping.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


}

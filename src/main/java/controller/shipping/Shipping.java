package controller.shipping;

import bean.Address;
import bean.Discount;
import bean.Information;
import bean.User;
import services.AddressService;
import services.DiscountService;
import services.InformationService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "Shipping", value = "/shipping")
public class Shipping extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("auth");
        String[] discountCode = request.getParameter("voucher").split(" ");
        List<Discount> discounts = DiscountService.getInstance().getListDiscountByListCode(Arrays.asList(discountCode));
        int sumDiscountFee = 0;
        for (Discount discount : discounts) {
            sumDiscountFee += discount.getValue();
        }
        List<Information> informations = InformationService.getInstance().getListInformationByUserId(user.getId());

        request.setAttribute("sumDiscountFee", sumDiscountFee);
        request.setAttribute("informations", informations);
        request.getRequestDispatcher("shipping.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


}

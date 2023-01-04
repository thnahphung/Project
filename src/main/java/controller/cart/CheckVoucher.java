package controller.cart;

import bean.Discount;
import bean.Format;
import bean.Order;
import services.DiscountService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CheckVoucher", value = "/cart/checkVoucher")
public class CheckVoucher extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String voucher = request.getParameter("voucher");
        Discount discount = DiscountService.getInstance().getDiscountByCode(voucher);
        String message;
        Order cart = (Order) request.getSession().getAttribute("cart");
        if (discount == null)
            message = "Voucher không đúng";
        else if (discount.checkTime())
            message = "Voucher đã hết hạn sử dụng";
        else if (!discount.checkQuantity())
            message = "Voucher đã hết lượt sử dụng";
        else message = "";
        response.getWriter().println(message);
        if (message.equals("")) {
            response.getWriter().println(discount.getDiscountFee());
            response.getWriter().println(cart.total() - discount.getDiscountFee());
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

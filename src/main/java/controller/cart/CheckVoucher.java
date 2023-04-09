package controller.cart;

import bean.Discount;
import bean.User;
import services.DiscountService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

@WebServlet(name = "CheckVoucher", value = "/cart/checkVoucher")
public class CheckVoucher extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String discountCode = request.getParameter("voucher");
        User user = (User) request.getSession().getAttribute("auth");
        Discount discount = DiscountService.getInstance().getDiscountByCode(discountCode);
        String message;

        if (discount == null)
            message = "Voucher không đúng";
        else if (discount.checkTime())
            message = "Voucher đã hết hạn sử dụng";
        else if (!discount.checkQuantity())
            message = "Voucher đã hết lượt sử dụng";
        else if (!discount.checkListProductAccept(user.getListCartItem()))
            message = "Không có sản phẩm nào của bạn được áp dụng Voucher";
        else message = "";
        response.getWriter().println(message);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

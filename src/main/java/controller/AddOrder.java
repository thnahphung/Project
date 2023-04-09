package controller;

import bean.*;
import services.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AddOrder", value = "/addOrder")
public class AddOrder extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("auth");
        int idAddress = Integer.parseInt(request.getParameter("idAddress"));
        int wayShip = Integer.parseInt(request.getParameter("wayShip"));
        String payments = request.getParameter("payments");
        String voucher = request.getParameter("voucher");

        Order order = (Order) request.getSession().getAttribute("cart");

        order.setInformation(new Information());
        order.setTransport(new Transport());
        order.setPaymentMethod(1);
        order.setCreateDate(LocalDateTime.now());
        order.setListOrderItem(user.getListCartItem());
        Discount discount = DiscountService.getInstance().getDiscountByCode(voucher);
        List<Discount> discountList = new ArrayList<>();
        discountList.add(discount);
        if (discount != null) {
            order.setListDiscount(discountList);
            order.setTotal(order.total() - DiscountService.getInstance().totalDiscount(discountList));
        } else {
            order.setListDiscount(null);
            order.setTotal(order.total());
        }
        order.setStatusDelivery(1);
        MailService.sendMail("Thong tin don hang", "Tong don hang cua ban la: " + order.total() + " VND", user.getEmail());

        user.setListCartItem(new ArrayList<>());
        CartService.getInstance().removeAllProductByUserId(user.getId());

        request.getRequestDispatcher("finish-buy.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

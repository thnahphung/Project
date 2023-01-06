package controller;

import bean.Discount;
import bean.Order;
import bean.User;
import controller.cart.Cart;
import services.AddressService;
import services.DiscountService;
import services.OrderService;
import services.TransportService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDateTime;

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

        order.setAddressId(idAddress);
        order.setTransportId(wayShip);
        order.setPayments(payments);
        order.setOrderDate(LocalDateTime.now());
        Discount discount = DiscountService.getInstance().getDiscountByCode(voucher);
        if (discount != null) {
            order.setDiscountId(DiscountService.getInstance().getDiscountByCode(voucher).getDiscountId());
            order.setTotal(order.total() - DiscountService.getInstance().getDiscountByCode(voucher).getDiscountFee());
        } else {
            order.setDiscountId(0);
            order.setTotal(order.total());
        }
        order.setSttDelivery(1);

        OrderService.getInstance().cartToOrder(order);
        request.getSession().setAttribute("cart", OrderService.getInstance().getCartByUserId(user.getUserId()));

        request.getRequestDispatcher("finish-buy.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

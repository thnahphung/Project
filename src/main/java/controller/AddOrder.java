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
        String note = request.getParameter("note");
        int idInformation = Integer.parseInt(request.getParameter("idInformation"));
        boolean isPayment = Boolean.parseBoolean(request.getParameter("isPayment"));
        String discountCode = request.getParameter("discountCode");

        Order order = (Order) request.getSession().getAttribute("cart");

        order.setNote(note);
        order.setPayment(isPayment);
        order.setInformation(InformationService.getInstance().getInformationByInformationId(idInformation));
        order.setTransport(TransportService.getInstance().getTransportById(1));
        order.setPaymentMethod(0);
        order.setStatusDelivery(0);
        order.setCreateDate(LocalDateTime.now());
        order.setListOrderItem(user.getListCartItem());
        order.setStatus(0);
        order.setTotal(OrderService.getInstance().total(order));

        if (!"".equals(discountCode)) {
            Discount discount = DiscountService.getInstance().getDiscountByCode(discountCode);
            order.setDiscount(discount);
        }

        order.setStatusDelivery(1);
        MailService.sendMail("Thong tin don hang", "Tong don hang cua ban la: " + order.getTotal() + " VND", user.getEmail());

        user.setListCartItem(new ArrayList<>());
        CartService.getInstance().removeAllProductByUserId(user.getId());

        request.getRequestDispatcher("finish-buy.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

package controller.userprofile;

import bean.Address;
import bean.AddressDetail;
import bean.User;
import services.AddressService;
import services.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddAddress", value = "/userprofile/addAddress")
public class AddAddress extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("auth");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String city = request.getParameter("city");
        String district = request.getParameter("district");
        String detail = request.getParameter("detail");

        AddressDetail addressDetail = new AddressDetail(AddressService.getInstance().nextId(), detail, district, city);
        Address address = new Address(addressDetail.getAddressDetailId(), user.getUserId(), name, phone, addressDetail.getAddressDetailId(), addressDetail, 0);
        AddressService.getInstance().addNewAddress(address);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

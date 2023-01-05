package controller.userprofile;

import bean.Address;
import bean.AddressDetail;
import bean.User;
import com.mysql.cj.Session;
import services.AddressDetailService;
import services.AddressService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShowAddress", value = "/showAddress")
public class ShowAddress extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("auth");

        List<Address> addressList = AddressService.getInstance().getListAddressByUserId(user.getUserId());
        request.setAttribute("addressList", addressList);

        request.getRequestDispatcher("show-address.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

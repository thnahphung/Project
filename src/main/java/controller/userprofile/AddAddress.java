package controller.userprofile;

import bean.Address;
import bean.User;
import services.AddressService;

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

        Address address = new Address(AddressService.getInstance().nextId(), detail, district, city);

        response.getWriter().println("<div class=\"list-address"+address.getId()+" all-address\">\n" +
                "                                <div class=\"contain-address bd-bottom\">\n" +
                "                                    <div class=\"contain-address"+detail+" left\">\n" +
                "                                        <p>\n" +
                "                                            <label><span class=\"name\">"+detail+"</span> <span\n" +
                "                                                    class=\"phone-number\">"+detail+"</span></label>\n" +
                "                                        </p>\n" +
                "                                        <div class=\"address\">\n" +
                "                                            "+address.formatAddress()+"\n" +
                "                                        </div>\n" +
                "                                    </div>\n" +
                "                                    <div class=\"contain-address right\">\n" +
                "                                        <button class=\"btn-address edit-one button submit\" id=\"edit-address\"\n" +
                "                                                data-toggle=\"modal\"\n" +
                "                                                data-target=\"#exampleEditAddress"+address.getId()+"\">Sửa\n" +
                "                                        </button>\n" +
                "                                        <button class=\"btn-address delete-one button submit\" id=\"delete-address\"\n" +
                "                                                value=\""+address.getId()+"\">Xóa\n" +
                "                                        </button>\n" +
                "                                    </div>\n" +
                "                                </div>\n" +
                "                            </div>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

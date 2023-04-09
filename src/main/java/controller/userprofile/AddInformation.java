package controller.userprofile;

import bean.Address;
import bean.Information;
import bean.User;
import services.InformationService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddInformation", value = "/userprofile/addInformation")
public class AddInformation extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("auth");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String city = request.getParameter("city");
        String district = request.getParameter("district");
        String detail = request.getParameter("detail");

        Address address = new Address(detail, district, city);
        Information information = new Information(InformationService.getInstance().nextId(), name, phone, address, 0);
        InformationService.getInstance().addNewInformation(information);

        response.getWriter().println("<div class=\"list-address"+information.getId()+" all-address\">\n" +
                "                                <div class=\"contain-address bd-bottom\">\n" +
                "                                    <div class=\"contain-address"+information.getId()+" left\">\n" +
                "                                        <p>\n" +
                "                                            <label><span class=\"name\">"+name+"</span> <span\n" +
                "                                                    class=\"phone-number\">"+phone+"</span></label>\n" +
                "                                        </p>\n" +
                "                                        <div class=\"address\">\n" +
                "                                            "+address.formatAddress()+"\n" +
                "                                        </div>\n" +
                "                                    </div>\n" +
                "                                    <div class=\"contain-address right\">\n" +
                "                                        <button class=\"btn-address edit-one button submit\" id=\"edit-address\"\n" +
                "                                                data-toggle=\"modal\"\n" +
                "                                                data-target=\"#exampleEditAddress"+information.getId()+"\">Sửa\n" +
                "                                        </button>\n" +
                "                                        <button class=\"btn-address delete-one button submit\" id=\"delete-address\"\n" +
                "                                                value=\""+information.getId()+"\">Xóa\n" +
                "                                        </button>\n" +
                "                                    </div>\n" +
                "                                </div>\n" +
                "                            </div>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

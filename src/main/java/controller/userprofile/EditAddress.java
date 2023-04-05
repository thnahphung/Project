package controller.userprofile;

import services.AddressService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EditAddress", value = "/userprofile/editAddress")
public class EditAddress extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("auth");

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String city = request.getParameter("city");
        String district = request.getParameter("district");
        String detail = request.getParameter("detail");


        AddressService.getInstance().editAddress(id,name, phone,city,district,detail);

        response.getWriter().println("<div class=\"contain-address"+id+" left\">\n" +
                "                                        <p>\n" +
                "                                            <label><span class=\"name\">"+name+"</span> <span\n" +
                "                                                    class=\"phone-number\">"+phone+"</span></label>\n" +
                "                                        </p>\n" +
                "                                        <div class=\"address\">\n" +
                "                                            "+detail+", "+district+", "+city+".\n" +
                "                                        </div>\n" +
                "                                    </div>");



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

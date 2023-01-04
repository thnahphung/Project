package controller.userprofile;

import bean.User;
import services.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EditAddress", value = "/userprofile/editAddress")
public class EditAddress extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("auth");

        String fullName = request.getParameter("fullName");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");


        UserService.getInstance().editInfor(user.getUserId(), fullName, phoneNumber, email);

        response.getWriter().println("<li>" + fullName + "</li>\n" +
                "                     <li>" + phoneNumber + "</li>\n" +
                "                    <li>" + email + "</li>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

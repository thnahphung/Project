package controller.admins;

import services.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserManaget", value = "/userManager")
public class UserManager extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("authAdmin");
        if (user.getVarieties() != 1 && user.getVarieties() != 3) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        String name = "Quản lý tài khoản";
        List<User> list = UserService.getInstance().getListUser();
        request.setAttribute("listUser",list);
        request.setAttribute("name",name);
        request.getRequestDispatcher("user-manager.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

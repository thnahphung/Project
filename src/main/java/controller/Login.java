package controller;

import bean.User;
import services.OrderDetailService;
import services.OrderService;
import services.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Login", value = "/doLogin")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("user");
        String password = request.getParameter("password");
        User user = UserService.getInstance().checkLogin(username, UserService.getInstance().hashPassword(password));
        if (user == null) {
            request.setAttribute("error", "Sai tài khoản hoặc mật khẩu.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else if (user.getVarieties() > 0) {
            if(user.getStatus()==0){
                HttpSession session = request.getSession(true);
                session.setAttribute("authAdmin", user);
                response.sendRedirect("orderManager");
            }else if(user.getStatus()==1){
                request.setAttribute("error", "Tài khoản đang tạm bị khóa.");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } else if (user.getStatus()==2) {
                request.setAttribute("error", "Tài khoản đã bị khóa vĩnh viễn, hãy tạo tài khoản mới.");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } else {
            if(user.getStatus()==0){
                HttpSession session = request.getSession(true);
                session.setAttribute("auth", user);
                session.setAttribute("cart", OrderService.getInstance().getCartByUserId(user.getId()));
                response.sendRedirect("homepage");
            }else if(user.getStatus()==1){
                request.setAttribute("error", "Tài khoản đang tạm bị khóa.");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } else if (user.getStatus()==2) {
                request.setAttribute("error", "Tài khoản đã bị khóa vĩnh viễn, hãy tạo tài khoản mới.");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }

        }


    }
}

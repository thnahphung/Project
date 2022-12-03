package controller;

import bean.User;
import services.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SignUp", value = "/doSignUp")
public class SignUp extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("sign-up.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fullName = request.getParameter("fullName");
        String phone = request.getParameter("phone");
        String pass = request.getParameter("pass");
        String passAgain = request.getParameter("passAgain");
        String email = request.getParameter("email");

        User user = UserService.getInstance().checkLogin(fullName, pass);

        if (fullName == null || phone == null || email == null || pass == null || passAgain == null) {
            request.setAttribute("error", "Bạn chưa điền đầy đủ thông tin!");
            request.getRequestDispatcher("sign-up.jsp").forward(request,response);
        } else if (UserService.getInstance().checkExistEmail(email)) {
            request.setAttribute("error", "Email này đã được sử dụng!");
            request.getRequestDispatcher("sign-up.jsp").forward(request,response);
        }else if (UserService.getInstance().checkExistPhone(phone)) {
            request.setAttribute("error", "Số điện thoại này đã được sử dụng!");
            request.getRequestDispatcher("sign-up.jsp").forward(request,response);
        } else if(!UserService.getInstance().checkSamePass(pass, passAgain)){
            request.setAttribute("error", "Mật khẩu không trùng khớp!");
            request.getRequestDispatcher("sign-up.jsp").forward(request,response);
        } else {
            response.sendRedirect("login.jsp");
        }
    }
}

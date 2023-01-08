package controller;

import bean.User;
import services.MailService;
import services.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SignUp", value = "/doSignUp")
public class SignUp extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fullName = request.getParameter("fullName");
        String phone = request.getParameter("phone");
        String pass = request.getParameter("pass");
        String passAgain = request.getParameter("passAgain");
        String email = request.getParameter("email");

        if (fullName.equals("") || phone.equals("") || email.equals("") || pass.equals("") || passAgain.equals("")) {
            request.setAttribute("error", "Bạn chưa điền đầy đủ thông tin!");
            request.setAttribute("fullName", fullName);
            request.setAttribute("phone", phone);
            request.setAttribute("email", email);
            request.getRequestDispatcher("sign-up.jsp").forward(request, response);
        } else if (UserService.getInstance().checkExistPhone(phone)) {
            request.setAttribute("error", "Số điện thoại này đã được sử dụng!");
            request.setAttribute("fullName", fullName);
            request.setAttribute("phone", phone);
            request.setAttribute("email", email);
            request.getRequestDispatcher("sign-up.jsp").forward(request, response);
        } else if (UserService.getInstance().checkExistEmail(email)) {
            request.setAttribute("error", "Email này đã được sử dụng!");
            request.setAttribute("fullName", fullName);
            request.setAttribute("phone", phone);
            request.setAttribute("email", email);
            request.getRequestDispatcher("sign-up.jsp").forward(request, response);

        } else if (!UserService.getInstance().checkSamePass(pass, passAgain)) {
            request.setAttribute("error", "Mật khẩu không trùng khớp!");
            request.setAttribute("fullName", fullName);
            request.setAttribute("phone", phone);
            request.setAttribute("email", email);
            request.getRequestDispatcher("sign-up.jsp").forward(request, response);
        } else {
            request.setAttribute("error", "Đăng ký thành công, mời bạn đăng nhập!");
            User user = new User();
            user.setUserId(UserService.getInstance().nextId());
            user.setFullName(fullName);
            user.setPhoneNumber(phone);
            user.setEmail(email);
            user.setPass(UserService.getInstance().hashPassword(pass));
            user.setVarieties(0);
            UserService.getInstance().addUser(user);
           MailService.sendMail("Đăng ký tài khoản","T lam xong roi do m thay chua ",email);
            request.getRequestDispatcher("sign-up.jsp").forward(request, response);

        }

    }
}

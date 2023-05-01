package controller.login;

import bean.IncorrectTime;
import bean.User;
import services.CartService;
import services.IncorrectTimeService;
import services.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDateTime;

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
        User user = UserService.getInstance().checkLogin(username, password);

        // kiem tra userName co ton tai
        if (UserService.getInstance().checkExistUserName(username)) {
            int id = UserService.getInstance().getIdByUserName(username);
            // kiểm tra xem user có đang trong thời gian bị khóa tài khoản
            if (IncorrectTimeService.getInstance().checkLocked(LocalDateTime.now(), username)) {
                LocalDateTime time = IncorrectTimeService.getInstance().getTimeUnLock(id);
                request.setAttribute("error", "Tài khoản của bạn đang tạm khóa, sẽ được mở lại sau " + time.getHour() + "h" + time.getMinute() + " " + time.getDayOfMonth() + "/" + time.getMonthValue() + "/" + time.getYear());
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
            // TH user không bị khóa tài khoản
            else {
                // User đăng nhập đúng
                if (user != null) {
                    IncorrectTimeService.getInstance().deleteIncorrectTime(id);
                    // Vào trang Admin
                    if (user.getVariety() > 0) {
                        HttpSession session = request.getSession(true);
                        session.setAttribute("authAdmin", user);
                        response.sendRedirect("orderManager");
                    }
                    // User bình thường
                    else {
                        user.setListCartItem(CartService.getInstance().getCartOfUser(id));
                        HttpSession session = request.getSession(true);
                        session.setAttribute("auth", user);
                        response.sendRedirect("homepage");
                    }
                }
                // User nhập sai password
                else {
                    System.out.println(id);
                    IncorrectTimeService.getInstance().insertIncorrectAttemptsPassword(id);
                    // TH User nhập sai 5 lần
                    if (UserService.getInstance().isEligibilityToLock(id)) {
                        LocalDateTime tomorrow = LocalDateTime.now().plusDays(1);
                        IncorrectTimeService.getInstance().setLockTimePassword(id, tomorrow);
                        request.setAttribute("error", "Bạn đã nhập sai 5 lần, tài khoản của bạn bị khóa cho đến " +  tomorrow.getHour() + "h" + tomorrow.getMinute() + " " + tomorrow.getDayOfMonth() + "/" + tomorrow.getMonthValue() + "/" + tomorrow.getYear());
                        request.getRequestDispatcher("login.jsp").forward(request, response);

                    }
                    // TH User nhập sai <5 lần
                    else {
                        request.setAttribute("error", "Bạn đã nhập sai " + IncorrectTimeService.getInstance().getInccorrectAttempts(id) + " lần, tài khoản sẽ khóa sau 5 lần sai");
                        request.getRequestDispatcher("login.jsp").forward(request, response);
                    }
                }
            }
        } else {
            request.setAttribute("error", "Username không tồn tại!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }

//        if (user == null) {
//            request.setAttribute("error", "Sai tài khoản hoặc mật khẩu.");
//            request.getRequestDispatcher("login.jsp").forward(request, response);
//        } else if (user.getVariety() > 0) {
//            if (user.getStatus() == 0) {
//                IncorrectTimeService.getInstance().resetIncorrectAttempts(user.getId());
//                HttpSession session = request.getSession(true);
//                session.setAttribute("authAdmin", user);
//                response.sendRedirect("orderManager");
//            } else if (user.getStatus() == 1) {
//                request.setAttribute("error", "Tài khoản đang tạm bị khóa.");
//                request.getRequestDispatcher("login.jsp").forward(request, response);
//            } else if (user.getStatus() == 2) {
//                request.setAttribute("error", "Tài khoản đã bị khóa vĩnh viễn, hãy tạo tài khoản mới.");
//                request.getRequestDispatcher("login.jsp").forward(request, response);
//            }
//        } else {
//            if (user.getStatus() == 0) {
//                user.setListCartItem(CartService.getInstance().getCartOfUser(user.getId()));
//                IncorrectTimeService.getInstance().resetIncorrectAttempts(user.getId());
//                HttpSession session = request.getSession(true);
//                session.setAttribute("auth", user);
//                response.sendRedirect("homepage");
//            } else if (user.getStatus() == 1) {
//                request.setAttribute("error", "Tài khoản đang tạm bị khóa.");
//                request.getRequestDispatcher("login.jsp").forward(request, response);
//            } else if (user.getStatus() == 2) {
//                request.setAttribute("error", "Tài khoản đã bị khóa vĩnh viễn, hãy tạo tài khoản mới.");
//                request.getRequestDispatcher("login.jsp").forward(request, response);
//            }
//
//        }


    }
}

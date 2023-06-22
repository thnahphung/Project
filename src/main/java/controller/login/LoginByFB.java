package controller.login;

import bean.ThirdParty;
import bean.User;
import services.CartService;
import services.OrderService;
import services.ThirdPartyService;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginByFB", value = "/loginByFB")
public class LoginByFB extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String id3rd = request.getParameter("id");
        System.out.println("1");
        User user = new User();
        if (!UserService.getInstance().checkExistId3rd(id3rd)) {
            user.setName(name);
            user.setIdThirdParty(new ThirdParty(ThirdPartyService.getInstance().maxId()+1, "Facebook", id3rd ));
            UserService.getInstance().addUserLoginBy3rdParty(user);
        } else {
            user = UserService.getInstance().getUserById3rd(id3rd);
            UserService.getInstance().changeName(name, id3rd);
        }

        HttpSession session = request.getSession(true);
        session.setAttribute("auth", user);
        session.setAttribute("cart", CartService.getInstance().getCartOfUser(user.getId()));
        response.getWriter().print(true);
    }
}

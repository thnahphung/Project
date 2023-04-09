package controller.login;

import bean.ThirdParty;
import bean.User;
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
        ThirdParty thirdParty = new ThirdParty(ThirdPartyService.getInstance().maxId()+1, "Facebook", id3rd );
        User user = new User();
        System.out.println(UserService.getInstance().checkExistId3rd(id3rd));
        if (!UserService.getInstance().checkExistId3rd(id3rd)) {
            user.setName(name);
            user.setIdThirdParty(thirdParty);
            UserService.getInstance().addUserLoginBy3rdParty(user);
        } else {
            user = UserService.getInstance().getUserById3rd(id3rd);
            UserService.getInstance().changeName(name, id3rd);
        }

        HttpSession session = request.getSession(true);
        session.setAttribute("auth", user);
        session.setAttribute("cart", OrderService.getInstance().getCartByUserId(user.getId()));
        response.getWriter().print(true);
    }
}

package controller.login;

import bean.Image;
import bean.ThirdParty;
import bean.User;
import services.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "LoginByFB", value = "/loginByFB")
public class LoginByFB extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String id3rd = request.getParameter("id");
        User user = new User();
        if (!UserService.getInstance().checkExistId3rd(id3rd)) {
            user.setAvatar(ImageService.getInstance().getImageByUserId(1));
            user.setName(name);
            user.setListCartItem(new ArrayList<>());
            user.setIdThirdParty(new ThirdParty(ThirdPartyService.getInstance().maxId()+1, "Facebook", id3rd ));
            UserService.getInstance().addUserLoginBy3rdParty(user);
        } else {
            user = UserService.getInstance().getUserById3rd(id3rd);
            user.setListCartItem(CartService.getInstance().getCartOfUser(user.getId()));
            UserService.getInstance().changeName(name, id3rd);
        }
        HttpSession session = request.getSession(true);
        session.setAttribute("auth", user);
        response.getWriter().print(true);
    }
}

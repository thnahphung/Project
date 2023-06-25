package controller.login;

import bean.ThirdParty;
import bean.User;
import services.CartService;
import services.ImageService;
import services.ThirdPartyService;
import services.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginByGG", value = "/loginByGG")
public class LoginByGG extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id3rd = request.getParameter("id");
        System.out.println("1");
        User user = new User();
        if (!UserService.getInstance().checkExistId3rd(id3rd)) {
            user.setAvatar(ImageService.getInstance().getImageByUserId(1));
            user.setName("Phan Thị Quỳnh Như");
            user.setIdThirdParty(new ThirdParty(ThirdPartyService.getInstance().maxId()+1, "Google", id3rd ));
            System.out.println(user.getIdThirdParty());
            UserService.getInstance().addUserLoginBy3rdParty(user);
        } else {
            user = UserService.getInstance().getUserById3rd(id3rd);
        }
        HttpSession session = request.getSession(true);
        session.setAttribute("auth", user);
        session.setAttribute("cart", CartService.getInstance().getCartOfUser(user.getId()));
        response.getWriter().print(true);
    }
}

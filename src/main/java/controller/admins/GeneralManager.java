package controller.admins;

import bean.Banner;
import services.BannerService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GeneralManager", value = "/generalManager")
public class GeneralManager extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = "Quản lý chung";
        List<Banner> bannerList = BannerService.getInstance().getListBanner();
        request.setAttribute("listBanner",bannerList);
        request.setAttribute("name", name);
        request.getRequestDispatcher("general-manager.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

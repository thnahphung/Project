package controller.admins;

import bean.Banner;
import services.BannerService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AddBanner", value = "/addBanner")
public class AddBanner extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String namepage = "Quản lý chung";
        String name = request.getParameter("name");
        String srcImg = request.getParameter("srcImg");
        String src = "images/image-banner/" + srcImg.substring(srcImg.lastIndexOf("\\")+1);
        System.out.println(src);
        BannerService.getInstance().addBanner(name, src);
        List<Banner> bannerList = BannerService.getInstance().getListBanner();
        request.setAttribute("listBanner", bannerList);
        request.setAttribute("name", namepage);
        request.getRequestDispatcher("general-manager.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

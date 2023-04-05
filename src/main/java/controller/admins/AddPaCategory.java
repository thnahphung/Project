package controller.admins;

import bean.Banner;
import services.BannerService;
import services.CaterogyService;
import services.PaCategoryService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AddPaCategory", value = "/addPaCategory")
public class AddPaCategory extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = "Quản lý chung";
        int id = Integer.parseInt(request.getParameter("id"));
        String nameSet = request.getParameter("nameSet");
        int idSet = Integer.parseInt(request.getParameter("idSet"));
        List<Banner> bannerList = BannerService.getInstance().getListBanner();
        List<PaCategory> paCategoryList = PaCategoryService.getInstance().getListCategory();
        List<Category> categoryList = CaterogyService.getInstance().getListCategoryAll();
        if(idSet==1) {
            PaCategoryService.getInstance().addPaCategory(nameSet);
            System.out.println("đã thêm");
        }
        else if(idSet==2){
            PaCategoryService.getInstance().editPaCategory(id,nameSet);
            System.out.println("đã sữa");
        }
        else if(idSet==3){

            PaCategoryService.getInstance().deletePaCategory(id);
            System.out.println("đã xóa");
        }
        request.setAttribute("name", name);
        request.setAttribute("listBanner",bannerList);
        request.setAttribute("listPaCategory",paCategoryList);
        request.setAttribute("listCategory",categoryList);
        request.getRequestDispatcher("general-manager.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

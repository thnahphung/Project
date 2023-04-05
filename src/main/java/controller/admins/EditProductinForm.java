package controller.admins;

import bean.User;
import services.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EditProductinForm", value = "/admins/editProductinForm")
public class EditProductinForm extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User uer = (User) request.getSession().getAttribute("authAdmin");
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        int priceReal = Integer.parseInt(request.getParameter("priceReal"));
        int group = Integer.parseInt(request.getParameter("category"));
        int inventory = Integer.parseInt(request.getParameter("inventory"));
        int stt = Integer.parseInt(request.getParameter("stt"));
        String imgSrc = "";
        String detail = request.getParameter("detail");
        String decription = request.getParameter("decription");
        ProductService.getInstance().editProductDetail(id, decription, detail, inventory, stt, uer.getId());
        ProductService.getInstance().editProduct(id, name,price,priceReal,group,imgSrc);
        response.sendRedirect("/ProductManager");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

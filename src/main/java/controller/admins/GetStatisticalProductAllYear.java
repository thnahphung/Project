package controller.admins;

import services.OrderService;
import services.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "GetStatisticalProductAllYear", value = "/getStatisticalProductAllYear")
public class GetStatisticalProductAllYear extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        for (int i = 2022; i < 2024; i++) {
            response.getWriter().println(ProductService.getInstance().listStatisticalInYear(i));
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

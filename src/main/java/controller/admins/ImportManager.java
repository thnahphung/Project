package controller.admins;

import bean.Import;
import services.ImprotService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ImportManager", value = "/importManager")
public class ImportManager extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = "Quản lý nhập kho";
        List<Import> importList = ImprotService.getInstance().getListImport();

        request.setAttribute("name", name);
        request.setAttribute("importList", importList);
        request.getRequestDispatcher("import-manager.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

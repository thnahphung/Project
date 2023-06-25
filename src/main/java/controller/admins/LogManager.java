package controller.admins;

import bean.Log;
import bean.Vendor;
import services.LogService;
import services.VendorService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@WebServlet(name = "LogManager", value = "/logManager")
public class LogManager extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = "Quản lý log";
        request.setAttribute("name", name);
        List<Log> logs = LogService.getInstance().getAllLog();
        request.setAttribute("logs", logs);
        request.getRequestDispatcher("log-manager.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

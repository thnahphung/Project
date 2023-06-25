package filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "FilterPageNotFound")
public class FilterPageNotFound implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;

        // Lấy URL được yêu cầu
        String url = httpRequest.getRequestURL().toString();

        // Kiểm tra trang "Page Not Found"
        if (!isPageExists(url)) {
            // Xử lý tại đây, ví dụ: chuyển hướng đến trang 404.jsp
            httpRequest.getRequestDispatcher("/404.jsp").forward(request, response);
            return;
        }

        // Tiếp tục xử lý chuỗi Filter
        chain.doFilter(request, response);
    }

    private boolean isPageExists(String url) {
        return url.endsWith("/home") || url.endsWith("/about") || url.endsWith("/contact");
    }
}

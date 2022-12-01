package controller.admins;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Collection;

@WebServlet(name = "UploadImageProduct", value = "/admins/uploadImageProduct")
@MultipartConfig(
//        location = "D:\\Git\\Project\\src\\main\\webapp\\images\\image-product",
        location = "C:\\Users\\DELL\\Documents\\GitHub\\Project\\src\\main\\webapp\\images\\image-product",
        fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 101
)
public class UploadImageProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Collection<Part> parts = request.getParts();
            for (Part part : parts) {
                String fileName = getFileName(part);
                if (fileName != null)
                    part.write(fileName);
            }
//            Part  part= request.getPart("image-banner");
//            part.write(getFileName(part));

        } catch (Exception e) {

        }
        response.sendRedirect("/ProductManager");
    }

    private String getFileName(Part part) {
        String contentDisposition = part.getHeader("content-disposition");

        if (!contentDisposition.contains("filename=")) {
            return null;
        }
        int begin = contentDisposition.indexOf("filename=") + 10;
        int end = contentDisposition.length() - 1;
        return contentDisposition.substring(begin, end);

    }


}

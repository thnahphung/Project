package controller.detailProduct;

import services.CommentService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoadComment", value = "/detailProduct/loadComment")
public class LoadComment extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int page = Integer.parseInt(request.getParameter("page"));
        List<Comment> commentList = CommentService.getInstance().getCommentByPage(id, page);

        for (Comment comment : commentList) {
            User user = comment.getUser();

            StringBuilder rate = new StringBuilder();
            int count = comment.getRate();
            for (int i = 0; i < 5; i++) {
                if (count > 0) {
                    rate.append("<i class=\"fa fa-star yellow\"></i>\n");
                    count--;
                } else {
                    rate.append(" <i class=\"fa fa-star  \"></i>\n");
                }

            }
            response.getWriter().println("<li class=\"item-comment bd-bottom\">\n" +
                    "                        <div class=\"user-cmt\">\n" +
                    "                            <img src=\"" + user.getAvatar() + "\"\n" +
                    "                                alt=\"\" class=\"img-user-cmt\">\n" +
                    "                            <div>\n" +
                    "                                <div class=\"name-user-cmt\">" + user.getFullName() + "</div>\n" +
                    "                                <div class=\"ratting rate-user\">\n" +
                    rate +
                    "                                </div>\n" +
                    "                            </div>\n" +
                    "                        </div>\n" +
                    "                        <div class=\"date-cmt\">" + comment.getDateComment().getDayOfMonth() + "/" + comment.getDateComment().getMonthValue() + "/" + comment.getDateComment().getYear() + "</div>\n" +
                    "                        <div class=\"comment\">\n" +
                    "                            <p>\n" +
                    comment.getDocument() +
                    "                            </p>\n" +
                    "                        </div>\n" +
                    "\n" +
                    "                    </li>");
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

package services;

import bean.Comment;
import bean.Product;
import db.JDBIConnector;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CommentService {
    private static CommentService instance;

    private CommentService() {

    }

    public static CommentService getInstance() {
        if (instance == null) {
            instance = new CommentService();
        }
        return instance;
    }


    public List<Comment> getCommentOfProductById(int id) {

        List<Comment> listResult = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT cmt.comment_id, cmt.rate,cmt.document,cmt.date_comment,u.user_id from `comment` cmt join `user` u on cmt.user_id= u.user_id WHERE cmt.product_id = " + id).mapToBean(Comment.class).stream().collect(Collectors.toList());
        });

        for (Comment comment : listResult) {
            comment.setUser(UserService.getInstance().getUserById(comment.getUserId()));
        }
        return listResult;
    }

    public List<Comment> getCommentOfProductByPage(int id, int page) {
        List<Comment> list = getCommentOfProductById(id);
        List<Comment> listResult = new ArrayList<Comment>();
        int start = (page - 1) * 5 < 0 ? 0 : (page - 1) * 5;
        int end = page <= list.size() / 5 ? page * 5 : list.size() - ((page - 1) * 5) + start;
        for (int i = start; i < end; i++) {
            listResult.add(list.get(i));
        }

        return listResult;
    }

    public int getCountCommentById(int id) {
        return getCommentOfProductById(id).size();
    }

    public static void main(String[] args) {
        System.out.println(CommentService.getInstance().getCommentOfProductById(1));
    }


}

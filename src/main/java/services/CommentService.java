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
            return handle.createQuery("SELECT cmt.comment_id, cmt.rate,cmt.document,cmt.date_comment,u.user_id from `comment` cmt join `user` u on cmt.user_id= u.user_id WHERE cmt.product_id = ? ORDER BY comment_id").bind(0, id).mapToBean(Comment.class).stream().collect(Collectors.toList());
        });

        for (Comment comment : listResult) {
            comment.setUser(UserService.getInstance().getUserById(comment.getUserId()));
        }
        return listResult;
    }

    public List<Comment> getCommentOfProductByPage(int id, int page) {
        List<Comment> list = getCommentOfProductById(id);
        List<Comment> listResult = new ArrayList<>();
        int start = (page - 1) * 5 < 0 ? 0 : (page - 1) * 5;
        int end = page <= list.size() / 5 ? page * 5 : list.size() - ((page - 1) * 5) + start;
        for (int i = start; i < end; i++) {
            listResult.add(list.get(i));
        }

        return listResult;
    }

    public List<Comment> getCommentByPage(int id, int page) {
        return JDBIConnector.get().withHandle(handle -> {
            List<Comment> listResult = handle.createQuery("SELECT cmt.comment_id, cmt.rate,cmt.document,cmt.date_comment,u.user_id from `comment` cmt join `user` u on cmt.user_id= u.user_id WHERE cmt.product_id = ? ORDER BY  comment_id LIMIT ?,5").bind(0, id).bind(1, page * 5 - 5).mapToBean(Comment.class).stream().collect(Collectors.toList());
            for (Comment comment : listResult) {
                comment.setUser(UserService.getInstance().getUserById(comment.getUserId()));
            }
            return listResult;
        });
    }

    public int getCountCommentById(int id) {
        return getCommentOfProductById(id).size();
    }

    public int getCountPageById(int id) {
        int countCmt = getCountCommentById(id);
        return countCmt % 5 == 0 ? countCmt / 5 : countCmt / 5 + 1;
    }

    public void addComment(Comment comment) {

    }

    public static void main(String[] args) {
//        System.out.println(CommentService.getInstance().getCommentByPage(1, 4));
    }


}

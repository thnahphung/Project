package bean;

import org.jdbi.v3.core.mapper.Nested;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Comment implements Serializable {
    private int commentID;
    private User user;

    private int userId;


    private String document;
    private int rate;

    private LocalDateTime dateComment;

    public Comment(int commentID, int userId, String document, int rate, LocalDateTime dateComment) {
        this.commentID = commentID;
        this.userId = userId;
        this.document = document;
        this.rate = rate;
        this.dateComment = dateComment;
    }

    public Comment() {

    }

    public LocalDateTime getDateComment() {
        return dateComment;
    }

    public void setDateComment(LocalDateTime dateComment) {
        this.dateComment = dateComment;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getCommentID() {
        return commentID;
    }

    public void setCommentID(int commentID) {
        this.commentID = commentID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentID=" + commentID +
                ", user=" + user +
                ", userId=" + userId +
                ", document='" + document + '\'' +
                ", rate=" + rate +
                ", dateComment=" + dateComment +
                '}';
    }
}

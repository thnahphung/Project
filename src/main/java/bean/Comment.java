package bean;

import org.jdbi.v3.core.mapper.Nested;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Comment implements Serializable {
    private int commentID;
    private User user;
    private String document;
    private int rate;

    private LocalDateTime dateComment;

    public Comment(int commentID, @Nested User user, String document, int rate, LocalDateTime dateComment) {
        this.commentID = commentID;
        this.user = user;
        this.document = document;
        this.rate = rate;
        this.dateComment = dateComment;
    }

    public Comment(){

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

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + commentID +
                ", user=" + user +
                ", document='" + document + '\'' +
                '}';
    }


}

package ru.vetalshev.model;

import java.util.Date;
import java.util.List;

public class Article extends Entity {

    private String text;
    private String title;
    private Date date;
    private User author; // TODO: объект, а не просто ID
    private List<Comment> comments; // TODO: статья содержит комментарии

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Article{" +
                "text='" + text + '\'' +
                ", title='" + title + '\'' +
                ", date=" + date +
                ", author=" + author +
                ", comments=" + comments +
                '}';
    }
}

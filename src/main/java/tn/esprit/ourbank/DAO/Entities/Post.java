package tn.esprit.ourbank.DAO.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;


import java.io.Serializable;
@Entity
public class Post implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String text;
    private String review;
    int setntimentValue ;

    @ManyToOne
    @JsonIgnoreProperties({"claims","posts"})
    private User user;

    @ManyToOne
    @JsonIgnoreProperties("posts")
    private Theme theme;

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post() {
    }

    public Post(int id, String text, String review) {
        this.id = id;
        this.text = text;
        this.review = review;
        this.setntimentValue = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public int getSetntimentValue() {
        return setntimentValue;
    }

    public void setSetntimentValue(int setntimentValue) {
        this.setntimentValue = setntimentValue;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", review='" + review + '\'' +
                ", user=" + user +
                ", theme=" + theme +
                '}';
    }
}

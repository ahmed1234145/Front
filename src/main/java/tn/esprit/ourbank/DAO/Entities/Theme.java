package tn.esprit.ourbank.DAO.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Theme implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String wording;
    private int themeNegativity;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "theme")
/*
    @JsonIgnoreProperties("posts")
*/
    private Set<Post> posts;

    public int getThemeNegativity() {
        return themeNegativity;
    }

    public void setThemeNegativity(int themeNegativity) {
        this.themeNegativity = themeNegativity;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    public Theme() {
    }

    public Theme(int id, String wording) {
        this.id = id;
        this.wording = wording;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWording() {
        return wording;
    }

    public void setWording(String wording) {
        this.wording = wording;
    }
}

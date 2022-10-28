package tn.esprit.ourbank.DAO.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Sujet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String subject;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sujet")
    private Set<Claim> claims;

    public Sujet() {
    }

    public Sujet(int id, String subject, Set<Claim> claims) {
        this.id = id;
        this.subject = subject;
        this.claims = claims;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Set<Claim> getClaims() {
        return claims;
    }

    public void setClaims(Set<Claim> claims) {
        this.claims = claims;
    }
}

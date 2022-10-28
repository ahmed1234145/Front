package tn.esprit.ourbank.DAO.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.io.Serializable;
@Entity
public class Demand implements Serializable {
    @Id
    private int id;
    private int sum;
    private int material;

    @ManyToOne

    private User user;

    @OneToOne(mappedBy = "demand")
    private Account account;

    @OneToOne(mappedBy = "demand")
    private Offer offer;

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Demand() {
    }

    public Demand(int id, int sum, int material) {
        this.id = id;
        this.sum = sum;
        this.material = material;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getMaterial() {
        return material;
    }

    public void setMaterial(int material) {
        this.material = material;
    }
}

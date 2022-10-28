package tn.esprit.ourbank.DAO.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.ManyToOne;
import java.io.Serializable;
@Entity
public class Materials implements Serializable {
    @Id
    private int id;
    private int quantity;
    private String type;
    private double price;
    private String address;
    private String image;

    @ManyToOne

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Materials() {
    }

    public Materials(int id, int quantity, String type, double price, String address, String image) {
        this.id = id;
        this.quantity = quantity;
        this.type = type;
        this.price = price;
        this.address = address;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

package tn.esprit.ourbank.DAO.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Bill implements Serializable {
    @Id
    private int number;
    private String type;
    @Temporal(TemporalType.DATE)
    private Date date;
    private int sum;

    @OneToOne
    private Payment payment;

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Bill() {
    }

    public Bill(int number, String type, Date date, int sum) {
        this.number = number;
        this.type = type;
        this.date = date;
        this.sum = sum;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}

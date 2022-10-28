package tn.esprit.ourbank.DAO.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Payment implements Serializable {
    @Id
    private int id;
    private String type;
    @Temporal(TemporalType.DATE)
    private Date datePay;
    private double sum;

    @ManyToOne
    private Account account;

    @OneToOne(mappedBy = "payment")
    private Bill bill;

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Payment() {
    }

    public Payment(int id, String type, Date datePay, double sum) {
        this.id = id;
        this.type = type;
        this.datePay = datePay;
        this.sum = sum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDatePay() {
        return datePay;
    }

    public void setDatePay(Date datePay) {
        this.datePay = datePay;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }
}

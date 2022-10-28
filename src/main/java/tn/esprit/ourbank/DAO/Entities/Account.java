package tn.esprit.ourbank.DAO.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
public class Account implements Serializable {
    @Id
    private int id;
    private int nb;
    @Temporal(TemporalType.DATE)
    private Date creationDate;
    private double amount;
    private Type AccType;

    @OneToOne
    private Demand demand;

    @OneToOne(mappedBy = "account")
    private BankCard bankCard;

    @OneToMany(mappedBy = "account")
    private Set<Payment> payments;

    public Set<Payment> getPayments() {
        return payments;
    }

    public void setPayments(Set<Payment> payments) {
        this.payments = payments;
    }

    public BankCard getBankCard() {
        return bankCard;
    }

    public void setBankCard(BankCard bankCard) {
        this.bankCard = bankCard;
    }

    public Demand getDemand() {
        return demand;
    }

    public void setDemand(Demand demand) {
        this.demand = demand;
    }

    public Account() {
    }

    public Account(int id, int nb, Date creationDate, double amount, Type accType) {
        this.id = id;
        this.nb = nb;
        this.creationDate = creationDate;
        this.amount = amount;
        AccType = accType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNb() {
        return nb;
    }

    public void setNb(int nb) {
        this.nb = nb;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Type getAccType() {
        return AccType;
    }

    public void setAccType(Type accType) {
        AccType = accType;
    }
}

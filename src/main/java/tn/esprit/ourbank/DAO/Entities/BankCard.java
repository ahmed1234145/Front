package tn.esprit.ourbank.DAO.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class BankCard implements Serializable {
    @Id
    private int cardNum;
    private int cardCode;
    private String password;
    @Temporal(TemporalType.DATE)
    private Date exipirationDate;

    @OneToOne
    private Account account;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public BankCard() {
    }

    public BankCard(int cardNum, int cardCode, String password, Date exipirationDate) {
        this.cardNum = cardNum;
        this.cardCode = cardCode;
        this.password = password;
        this.exipirationDate = exipirationDate;
    }

    public int getCardNum() {
        return cardNum;
    }

    public void setCardNum(int cardNum) {
        this.cardNum = cardNum;
    }

    public int getCardCode() {
        return cardCode;
    }

    public void setCardCode(int cardCode) {
        this.cardCode = cardCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getExipirationDate() {
        return exipirationDate;
    }

    public void setExipirationDate(Date exipirationDate) {
        this.exipirationDate = exipirationDate;
    }
}

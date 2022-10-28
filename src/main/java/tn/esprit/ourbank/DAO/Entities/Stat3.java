package tn.esprit.ourbank.DAO.Entities;

public class Stat3 {
    Long value;
    int name;

    public Stat3() {
    }

    public Stat3(Long value, int name) {
        this.value = value;
        this.name = name;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }
}

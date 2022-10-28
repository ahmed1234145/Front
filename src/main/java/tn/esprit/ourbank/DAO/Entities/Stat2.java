package tn.esprit.ourbank.DAO.Entities;

public class Stat2 {
    Long value;
    Double name;

    public Stat2() {
    }

    public Stat2(Long value, Double name) {
        this.value = value;
        this.name = name;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public Double getName() {
        return name;
    }

    public void setName(Double name) {
        this.name = name;
    }
}

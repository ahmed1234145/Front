package tn.esprit.ourbank.DAO.Entities;

public class Stat {
    Long value;
    String name;

    public Stat() {
    }

    public Stat(Long value, String name) {
        this.value = value;
        this.name = name;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package tn.esprit.ourbank.DAO.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "Staff")
public class Staff implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String pwd;
    private RoleStaff typeStaff;
    private String located;

    @OneToMany(mappedBy = "staff")
    private Set<Offer> offers;

    @ManyToOne
    private Agency agency;

    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    public Set<Offer> getOffers() {
        return offers;
    }

    public void setOffers(Set<Offer> offers) {
        this.offers = offers;
    }

    public Staff() {
    }

   

    public Staff(int id, String pwd, RoleStaff typeStaff, String located) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.typeStaff = typeStaff;
		this.located = located;
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public RoleStaff getTypeStaff() {
        return typeStaff;
    }

    public void setTypeStaff(RoleStaff typeStaff) {
        this.typeStaff = typeStaff;
    }

	public String getLocated() {
		return located;
	}

	public void setLocated(String located) {
		this.located = located;
	}
    
    
    
}

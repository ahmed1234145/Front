package tn.esprit.ourbank.DAO.Entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "Agency")
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Getter
@Setter
public class Agency implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String location;
    private int staffNum;
    private double budget;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "agency_id",referencedColumnName = "id")
    private Set<Staff> staffs;

}

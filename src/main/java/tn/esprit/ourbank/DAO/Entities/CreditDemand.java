package tn.esprit.ourbank.DAO.Entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="CreditDemand")
public class CreditDemand {
	@Id
	@GeneratedValue (strategy= GenerationType.IDENTITY)
	@Column (name="id")
	private Long id;

	@Column(name="creditAmount")
	private Integer creditAmount;
	@Column(name="interestRates")
	private Integer interestRates;
	@Column(name="periodicity")
	private PeriodicityType periodicity;
	@Column(name="months")
	private Integer months;
	@Column(name="years")
	private Integer years;
	@Override
	public String toString() {
		return "CreditDemand [id=" + id + ", creditAmount=" + creditAmount + ", interestRates=" + interestRates
				+ ", periodicity=" + periodicity + ", months=" + months + ", years=" + years + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getCreditAmount() {
		return creditAmount;
	}
	public void setCreditAmount(Integer creditAmount) {
		this.creditAmount = creditAmount;
	}
	public Integer getInterestRates() {
		return interestRates;
	}
	public void setInterestRates(Integer interestRates) {
		this.interestRates = interestRates;
	}
	public PeriodicityType getPeriodicity() {
		return periodicity;
	}
	public void setPeriodicity(PeriodicityType periodicity) {
		this.periodicity = periodicity;
	}
	public Integer getMonths() {
		return months;
	}
	public void setMonths(Integer months) {
		this.months = months;
	}
	public Integer getYears() {
		return years;
	}
	public void setYears(Integer years) {
		this.years = years;
	}
	public CreditDemand(Long id, Integer creditAmount, Integer interestRates, PeriodicityType periodicity,
			Integer months, Integer years) {
		super();
		this.id = id;
		this.creditAmount = creditAmount;
		this.interestRates = interestRates;
		this.periodicity = periodicity;
		this.months = months;
		this.years = years;
	}
	public CreditDemand() {
		super();
	}
	
}

package tn.esprit.ourbank.DAO.Entities;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Transaction")
public class Transaction {
	@Id
	@GeneratedValue (strategy= GenerationType.IDENTITY)
	@Column (name="TransactionId")
	private Long TransactionId;
	@Override
	public String toString() {
		return "Transaction [TransactionId=" + TransactionId + ", payedSum=" + payedSum + ", paymentDate=" + paymentDate
				+ "]";
	}
	public Long getTransactionId() {
		return TransactionId;
	}
	public void setTransactionId(Long transactionId) {
		TransactionId = transactionId;
	}
	public Long getPayedSum() {
		return payedSum;
	}
	public void setPayedSum(Long payedSum) {
		this.payedSum = payedSum;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	//id mta3 li bech yeb3ath weli bech ye5ou
	@Column(name="payedSum")
	private Long payedSum;
	@Column(name="paymentDate")
	@Temporal (TemporalType.DATE)
	private Date paymentDate;
	public Transaction(Long transactionId, Long payedSum, Date paymentDate) {
		super();
		TransactionId = transactionId;
		this.payedSum = payedSum;
		this.paymentDate = paymentDate;
	}
	public Transaction() {
		super();
	}
	
	// l id mta3 l pack ( reste a payer ...)
	
}

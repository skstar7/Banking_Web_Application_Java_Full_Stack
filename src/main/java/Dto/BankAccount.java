package Dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class BankAccount {
	@Id
	@SequenceGenerator(initialValue = 44556321, allocationSize = 1, sequenceName = "accno", name = "accno")
	@GeneratedValue(generator = "accno")
	long acc_no;

	String acc_type;

	double acc_limit;

	boolean status;

	double amount;

	@ManyToOne
	Customer customer;

	@OneToMany(cascade = CascadeType.ALL)
	List<BankTransactionHistory> transaction_list;

	public long getAcc_no() {
		return acc_no;
	}

	public void setAcc_no(long acc_no) {
		this.acc_no = acc_no;
	}

	public String getAcc_type() {
		return acc_type;
	}

	public void setAcc_type(String acc_type) {
		this.acc_type = acc_type;
	}

	public double getAcc_limit() {
		return acc_limit;
	}

	public void setAcc_limit(double acc_limit) {
		this.acc_limit = acc_limit;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<BankTransactionHistory> getTransaction_list() {
		return transaction_list;
	}

	public void setTransaction_list(List<BankTransactionHistory> transaction_list) {
		this.transaction_list = transaction_list;
	}

}

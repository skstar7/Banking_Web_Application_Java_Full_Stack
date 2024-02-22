package Dto;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Customer {
	@Id
	@SequenceGenerator(initialValue = 11223345, allocationSize = 1, sequenceName = "custid", name = "custid")
	@GeneratedValue(generator = "custid") // this annotation to use to generate the id randomly
	int cid;

	String cname;

	String pwd;

	long mob;

	String email;

	String Gender;

	Date dob;

	@OneToMany
	List<BankAccount> bankaccounts;

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public long getMob() {
		return mob;
	}

	public void setMob(long mob) {
		this.mob = mob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public List<BankAccount> getBankaccounts() {
		return bankaccounts;
	}

	public void setBankaccounts(List<BankAccount> bankaccounts) {
		this.bankaccounts = bankaccounts;
	}
}

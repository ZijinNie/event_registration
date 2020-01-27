package ca.mcgill.ecse321.eventregistration.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class CreditCard {
	private String accountNumber;
	
	@Id
	public String getAccountNumber() {
		return this.accountNumber;
	}
	
	public void setAccountNumber(String id) {
		this.accountNumber=id;
	}
	
	private int amount;
	
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
	
}

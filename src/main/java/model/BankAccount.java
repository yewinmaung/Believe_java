package model;

public class BankAccount {
	int id;
	String name;
	String email;
	int amount;
	String accno;
    
public BankAccount() {
	
}
	public BankAccount(int id, String name, String email,String accno,int amount) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.accno=accno;
		this.amount = amount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getAccno() {
		return accno;
	}
	public void setAccno(String accno) {
		this.accno = accno;
	}

}

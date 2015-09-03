package bankdata;

public class BankAccount {
	private String number;
	private String fName;
	private String lName;
	private double balance;
	protected String type;
	
	
	//Constructor
	public BankAccount(String customerF,String customerL,String phoneNumber,double initialBalance){
		number = phoneNumber;
		balance = initialBalance;
		fName = customerF;
		lName = customerL;
	}
	
	public BankAccount(double initialBalance) {
		// TODO Auto-generated constructor stub
		balance = initialBalance;
	}

	//Deposits a specified amount into the account
	public void deposit(double amount){
		balance += amount;
	}
	
	//Withdraws a specified amount from the account
	public void withdraw(double amount){
		double temp = (balance -= amount);
		if(temp > 0){
		balance = temp;
		}
		else if(temp < 0){
			balance += amount;
			System.out.println("Insufficient funds!");
			return;
		}
	}
	
	public String getPhone(){
		return number;
	}
	
	public String getLName(){
		return lName;
	}
	
	public String getFName(){
		return fName;
	}
	
	//Returns the account number
	public String getAcct(){
		return fName + " " + lName + " " + number.substring(0,3) + "-" + number.substring(3,6)
				+ "-" +number.substring(5,number.length()-1);
	}
	
	public void getAccts(){
		String first = fName;
		String middle = lName;
		String ring = number.substring(0,3) + "-" + number.substring(3,6) + "-" + number.substring(5,number.length()-1);
		System.out.printf("%-20s", first);
		System.out.printf("%-18s",middle);
		System.out.printf("%s", balance);
		System.out.printf("%20s %n",ring);
		System.out.println();
//		return fName + "      " + lName + "      " + number.substring(0,3) +
//		"-" + number.substring(3,6) + "-" + number.substring(5,number.length()-1) + 
//		"      " + balance;
	}
	
	//Returns the account balance
	public double getBalance(){
		return balance;
	}
	
	public void setBalance(double balance){
		this.balance = balance;
	}
	
	public void setPhone(String phone){
		this.number = phone;
	}
	
	public void setFName(String name){
		this.fName = name;
	}
	
	public void setLName(String name){
		this.lName = name;
	}

	public String getType() {
		return type;
	}
	
	
}

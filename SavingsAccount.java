package bankdata;

public class SavingsAccount extends BankAccount {
	protected double interestRate;

	public SavingsAccount(double initialBalance, double initialRate) {
		super(initialBalance); // Invoke Account constructor
		interestRate = initialRate;
		type = "s";
	}

	public void addInterestRate() {
		double interest = super.getBalance() * this.interestRate / 100;
		super.deposit(interest);
	}

	public double getInterestRate(double initialRate) {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public void applyInterest() {
		double balance = getBalance();
//		System.out.println("Balance: " + balance);
		balance += (balance * interestRate/100);
//		System.out.println("Balance: " + balance);
		super.setBalance(balance);
	}

}
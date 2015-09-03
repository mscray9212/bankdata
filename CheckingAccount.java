package bankdata;

public class CheckingAccount extends BankAccount {
	protected int numOfChecks;

	public CheckingAccount(double initialBalance, int nOC) {
		super(initialBalance); // Invoke Account constructor
		numOfChecks = nOC;
		type = "c";
	}

	public int getNumOfChecks() {
		return numOfChecks;
	}

	public void incNumOfChecks() {
		numOfChecks++;
	}

	public void printNumOfChecks() {
		System.out.println("Number of checks written: " + getNumOfChecks());
	}

}

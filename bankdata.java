package bankdata;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.LinkedList;

public class bankdata {

		@SuppressWarnings("resource")
		public static void main(String[] args) {
			// Create an array to store the bank accounts.
			BankAccount[] accounts = new BankAccount[1];
			// numAccounts is the number of accounts currently in
			// existence. current is the array index of the currently
			// selected account (or -1) if no account is currently
			// selected).
			int numAccounts = 0;
			int current = -1;
			ArrayList<BankAccount> account = new ArrayList<BankAccount>();

			// Read and execute commands
			while (true) {
				
				System.out.println("Please make a number selection: (1-10)");
				System.out.println("1  Show all records");
				System.out.println("2  Delete the current record");
				System.out.println("3  Change the first name in the current record");
				System.out.println("4  Change the last name in the current record");
				System.out.println("5  Add a new record");
				System.out.println("6  Change the phone number in the current record");
				System.out.println("7  Add a deposit to the current balance in the current record");
				System.out.println("8  Make a withdrawal from the current record if there is sufficient funds available");
				System.out.println("9  Select a record from the record list to become the current record");
				System.out.println("10 Quit");

				// Display list of commands
				System.out.print("Current record is: ");
				if (current != -1) {
					System.out.print(accounts[current].getAcct() + " Balance: $");

					// Round the balance to the nearest cent
					long balanceInCents = Math.round(accounts[current].getBalance() * 100);

					// Display the balance as dollars and cents, adding
					// a leading zero if the cents is a one-digit number
					System.out.print(balanceInCents / 100 + ".");
					long cents = balanceInCents % 100;
					if (cents < 10)
						System.out.print("0");
					System.out.println(cents);
				}

				else
					System.out.println("None selected");
				System.out.println("The total number of accounts in the bank are: " + numAccounts);
				System.out.println();

				// Prompt the user to enter a command
				Scanner input = new Scanner(System.in);

				System.out.print("Enter command from the list above (q to quit): ");
				String command = input.next().trim();

				// Use a cascaded if statement to determine which
				// command was entered.
				if (command.equalsIgnoreCase("1")) {
					System.out.println("First Name         Last Name         Balance         Phone Number");
					System.out.println("----------         ---------         -------         ------------");
					for(int i = 0; i < accounts.length; i++){
						accounts[i].getAccts();
					}
					
				}
				else if (command.equalsIgnoreCase("2")) {
					// *** Close command **
					if (current != -1) {
						if (current == numAccounts - 1) // If current is the last
														// object in the array,
														// delete current one;
							accounts[--numAccounts - 1] = null;
						else
							accounts[current] = accounts[--numAccounts]; // else
																			// move
																			// the
																			// last
																			// object
																			// to
																			// current
																			// location,
																			// delete
																			// current
																			// one.
						current = -1;

						System.out.println("The current account is closed.");
					} else
						System.out.println("Please select an account");
				    }   
					else if (command.equalsIgnoreCase("3")) {
						String first = accounts[current].getFName();
						System.out.print("Please enter customer's new first name: ");
						first = input.next();
						accounts[current].setFName(first);
					}
					else if (command.equalsIgnoreCase("4")) {
						String last = accounts[current].getLName();
						System.out.print("Please enter customer's new last name: ");
						last = input.next();
						accounts[current].setLName(last);
					}
					else if (command.equalsIgnoreCase("5")) {

						// *** Open command ***
						// If the accounts array is full, double its size
						if (numAccounts == accounts.length) {
							BankAccount[] tempArray = new BankAccount[accounts.length * 2];
							for (int i = 0; i < accounts.length; i++)
								tempArray[i] = accounts[i];
							accounts = tempArray;
						}

						// Prompt the user for the account number and balance.
						System.out.print("Enter first name: ");
						String customerF = input.next().trim();
						System.out.print("Enter last name: ");
						String customerL = input.next().trim();
						System.out.print("Enter phone number: ");
						String phoneNumber = input.next().replaceAll("[-+.^:,]","").trim();
						while(phoneNumber.length()>10 || phoneNumber.length()<10){
							System.out.print("Please reenter phone number (including area code): ");
							phoneNumber = input.next().replaceAll("[-+.^:,]","").trim();
						}
						System.out.print("Enter balance: ");
						double balance = input.nextDouble();
						accounts[numAccounts] = new BankAccount(customerF,customerL,phoneNumber,balance);
						current = numAccounts;
						numAccounts++;
					}
				 else if (command.equals("6")) {
					// *** Change phone number command ***
					String phoneNum = accounts[current].getPhone();
					System.out.print("Please enter customer's new phone number: ");
					phoneNum = input.next().replaceAll("[-+.^:,]","").trim();
					while(phoneNum.length()>10 || phoneNum.length()<10){
						System.out.print("Please reenter phone number (including area code): ");
						phoneNum = input.next().replaceAll("[-+.^:,]","").trim();
					}
					accounts[current].setPhone(phoneNum);

				}
				else if (command.equalsIgnoreCase("7")) {
					// *** Deposit command ***
					if (current != -1) {
						System.out.print("Enter amount to deposit: ");
						double amount = input.nextDouble();
						accounts[current].deposit(amount);
					} else
						System.out.println("Please select an account");
				}
				else if (command.equalsIgnoreCase("8")) {
					// *** Withdraw command ***
					if (current != -1) {
						System.out.print("Enter amount to withdraw: ");
						double amount = input.nextDouble();
						accounts[current].withdraw(amount);
					} else
						System.out.println("Please select an account");
				}
				else if (command.equals("9")) {
					// *** Select command ***
					System.out.print("Enter account phone number: ");
					String accountNumber = input.next().trim();
					int i;
					for (i = 0; i < numAccounts; i++)
						if (accountNumber.equals(accounts[i].getPhone())) {
							current = i;
							break;
						}
					System.out.println();
				}

				else if (command.equals("10")||command.equalsIgnoreCase("q")) {
					// *** Quit command ***
					System.out.println("Have a good day!");
					return;
				}

				else {
					// *** Illegal command ***
					System.out.println("Command was not recognized; "
							+ "please try again.");
				}
			}
		}
	}
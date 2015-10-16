import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import org.junit.*;
import static org.junit.Assert.* ;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Transaction {
	static ArrayList<Account> acc = new ArrayList<Account>();
	Account a = new Account();
	
     @Test
	public void enterDetails() {
		Scanner in = new Scanner(System.in);
		System.out.println("Welcome to Evil Corp");
		System.out.println("Please create the user account(s)");
		int value = 0;
		String name = "";
		double balance = 0;
		while (value != -1) {

			value=Validator.getInt(in, "Enter an account # or -1 to stop entering accounts :");
			
	
			if (value == -1) {
				assertTrue(value == -1);
				Transaction.enterTransactionDetails(in);
				break;
			}
			a.setAccNumber(value);

			name = Validator.getString(in, "Enter the name for acct # " + a.getAccNumber()+ " : ");
			a.setName(name);
		
			balance = Validator.getDouble(in, "Enter the balance for acct # "+ a.getAccNumber() + " : ");
			a.setName(name);
			
			a.setBalance(balance);
			acc.add(a);
			a = new Account();
			
		}
		
	}

	public static void enterTransactionDetails(Scanner in) {
		String type = "0";
		int userAccInput;
		double checkAmount;
		String checkDate;
		HashMap<Integer, HashMap<String, Double>> hashAccount = new HashMap<Integer, HashMap<String, Double>>();
		HashMap<String, Double> hashDate = new HashMap<String, Double>();
		while (!type.equalsIgnoreCase("-1")) {
		
			type = Validator.getString(in, "Enter a transaction type (Check, Debit card, Deposit or Withdrawal) or -1 to finish :");
			switch (type) {
			case "C":
				userAccInput = Validator.getInt(in, "Enter the account # : ");
				for (Account accc : acc) {
					if (accc.accNumber == userAccInput) {
						System.out.println("Valid account number");
						checkAmount = Validator.getDouble(in, "Enter the amount of the check: ");					
						checkDate = Validator.getString(in, "Enter the date of the check: ");
						assertTrue(!checkDate.equals(""));

						boolean dateValue = isThisDateValid(checkDate);
						if(!dateValue)
						{
							
							System.out.println("Invalid date, re-inout");
							break;
						}
						hashDate.put(checkDate, checkAmount);
						hashAccount.put(userAccInput, hashDate);
						ArrayList<String> hashDateArray = new ArrayList<String>();

						for (String key : hashDate.keySet()) {
							hashDateArray.add(key);
							Collections.sort(hashDateArray,
									new Comparator<String>() {
										DateFormat f = new SimpleDateFormat(
												"dd/MM/yyyy");

										@Override
										public int compare(String o1, String o2) {
											try {
												return f.parse(o1).compareTo(
														f.parse(o2));
											} catch (ParseException e) {
												throw new IllegalArgumentException(
														e);
											}
										}
									});
							
						}
						LinkedHashMap<String, Double> hashDateSorted = new LinkedHashMap<String, Double>();
						for (int i = 0; i < hashDateArray.size(); i++) {
							System.out.println("Key " + hashDateArray.get(i));
							System.out.println("Value: "
									+ hashDate.get(hashDateArray.get(i)));
							hashDateSorted.put(hashDateArray.get(i),
									hashDate.get(hashDateArray.get(i)));
						}
						hashAccount.put(userAccInput, hashDateSorted);
						calculate(hashAccount,hashDateSorted);
					} else {
						System.out
								.println("Wrong account number. Start from begining");
					}
				}
				break;
			case "D":
				userAccInput = Validator.getInt(in, "Enter the account # : ");
				for (Account accc : acc) {
					if (accc.accNumber == userAccInput) {
						System.out.println("Valid account number");
						checkAmount = Validator.getDouble(in, "Enter the amount of the debit charge: ");
						checkDate = Validator.getString(in, "Enter the date of the charge: ");
						assertTrue(!checkDate.equals(""));

						hashDate.put(checkDate, checkAmount);
						hashAccount.put(userAccInput, hashDate);
						ArrayList<String> hashDateArray = new ArrayList<String>();

						for (String key : hashDate.keySet()) {
							hashDateArray.add(key);
							Collections.sort(hashDateArray,
									new Comparator<String>() {
										DateFormat f = new SimpleDateFormat(
												"dd/MM/yyyy");

										@Override
										public int compare(String o1, String o2) {
											try {
												return f.parse(o1).compareTo(
														f.parse(o2));
											} catch (ParseException e) {
												throw new IllegalArgumentException(
														e);
											}
										}
									});
							
						}
						LinkedHashMap<String, Double> hashDateSorted = new LinkedHashMap<String, Double>();
						for (int i = 0; i < hashDateArray.size(); i++) {
							System.out.println("Key " + hashDateArray.get(i));
							System.out.println("Value: "
									+ hashDate.get(hashDateArray.get(i)));
							hashDateSorted.put(hashDateArray.get(i),
									hashDate.get(hashDateArray.get(i)));
						}
						hashAccount.put(userAccInput, hashDateSorted);
						calculate(hashAccount,hashDateSorted);
					} else {
						System.out
								.println("Wrong account number. Start from begining");
					}
				}
				break;
			case "WD":
				userAccInput = Validator.getInt(in, "Enter the account # : ");
				for (Account accc : acc) {
					if (accc.accNumber == userAccInput) {
						System.out.println("Valid account number");
						checkAmount = Validator.getDouble(in, "Enter the amount of the transaction: ");
						checkDate = Validator.getString(in, "Enter the date of the transaction: ");
						assertTrue(!checkDate.equals(""));

						hashDate.put(checkDate, checkAmount);
						hashAccount.put(userAccInput, hashDate);
						ArrayList<String> hashDateArray = new ArrayList<String>();

						for (String key : hashDate.keySet()) {
							hashDateArray.add(key);
							Collections.sort(hashDateArray,
									new Comparator<String>() {
										DateFormat f = new SimpleDateFormat(
												"dd/MM/yyyy");

										@Override
										public int compare(String o1, String o2) {
											try {
												return f.parse(o1).compareTo(
														f.parse(o2));
											} catch (ParseException e) {
												throw new IllegalArgumentException(
														e);
											}
										}
									});
							
						}
						LinkedHashMap<String, Double> hashDateSorted = new LinkedHashMap<String, Double>();
						for (int i = 0; i < hashDateArray.size(); i++) {
							System.out.println("Key " + hashDateArray.get(i));
							System.out.println("Value: "
									+ hashDate.get(hashDateArray.get(i)));
							hashDateSorted.put(hashDateArray.get(i),
									hashDate.get(hashDateArray.get(i)));
						}
						hashAccount.put(userAccInput, hashDateSorted);
						calculate(hashAccount,hashDateSorted);
					} else {
						System.out
								.println("Wrong account number. Start from begining");
					}
				}
				break;
			}
		}
	}

	private static void calculate(HashMap<Integer, HashMap<String, Double>> hashAccount, HashMap<String, Double>hashDateSorted) {
		
		for(Account a: acc )
		{
			for ( int key : hashAccount.keySet() ) {
			    System.out.println( key );
			    if(a.accNumber==key)
			    {
			    	for ( String key1 : hashDateSorted.keySet() ) {
			    	
			    	System.out.println("hashDateSorted.get(i)  "+hashDateSorted.get(key1));
			    	a.balance=a.balance-hashDateSorted.get(key1);
			    	if(a.balance<0)
			    	{
			    		a.balance = a.balance-35;
			    	}
			    	if(a.balance==0)
			    	{
			    		Scanner scan = new Scanner(System.in);
			    		System.out.println("Do u want to delete :Y/N?");
			    		String Response = scan.nextLine();
			    		if(Response.equalsIgnoreCase("Y"))
			    		{
			    			hashDateSorted.remove(key);
			    			hashAccount.remove(key);
			    			System.out.println("Account Deleted");	
			    		}
			    		else
			    		{
			    			
			    		}
			    	}
			    	}
			    	
			    }
			    
			}
			System.out.println("The balance for account "+a.accNumber+" "+a.balance);
		}
		
	}
	
public static boolean isThisDateValid(String dateToValidate){
		
		if(dateToValidate == null){
			return false;
		}
		else
		return true;
}
	
}
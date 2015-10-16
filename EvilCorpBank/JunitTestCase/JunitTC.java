import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;


public class JunitTC {

	
	Transaction T = new Transaction();
	Account account = new Account();
	
	@Test
	public void CheckaccountNumber()
	{
		account.setAccNumber(1234);
		assertEquals(1234, account.getAccNumber(),0.0);
		
			
	}
	
	@Test
	public void CheckName()
	{
		account.setName("XYZ");
		assertEquals("XYZ", account.getName());
		
			
	}
	@Test
	public void CheckBalance()
	{
		account.setBalance(1000);
		assertEquals(1000, account.getBalance(),0.0);
		
			
	}
	
	@Test
	public void checkenterDetails()
	{
		HashMap<Integer, HashMap<String, Double>> hashAccount = new HashMap<Integer, HashMap<String, Double>>();
		HashMap<String, Double> hashDate = new HashMap<String, Double>();
		String Date = "10/15/2015";
		
		account.setAccNumber(1234);
		account.setName("XYZ");
		account.setBalance(1000);
		
		
		hashDate.put(Date, account.getBalance());
		hashAccount.put(account.getAccNumber(), hashDate);
		
		Transaction.calculate(hashAccount,hashDate);
		
		assertTrue(Transaction.isThisDateValid(Date));
		
		
		
	}
	
	
	
}

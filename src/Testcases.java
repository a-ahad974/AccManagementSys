import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.Assert;

public class Testcases {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@Test
	public void Balancechecking() throws NumberFormatException, IOException {
		
		
		Customer c=new Customer();
		
		c.makecustomer(450);
		
		double EXPECTED=c.acc.Balance;
		
		double match=c.acc.checkBalance();
		
		Assert.assertEquals(EXPECTED, match);
		
		
				
		
	}

	@Test
	public void CashWidrawal() throws NumberFormatException, IOException {
		
		
		Customer c=new Customer();
		
		c.makecustomer(450);
		
		double match=c.acc.makeWithdrawal(50);
		double EXPECTED=c.acc.Balance;
		Assert.assertEquals(EXPECTED, match);
		
		
	}
	
	@Test
	public void NegCashWidrawal() throws NumberFormatException, IOException {
		
		
		Customer c=new Customer();
		
		c.makecustomer(450);
		
		double EXP=c.acc.Balance;
		double match=c.acc.makeWithdrawal(50);			
		Assert.assertFalse(EXP==match);
		
				
		
	}

	@Test
	public void DepositAmount() throws NumberFormatException, IOException {
		
		
		Customer c=new Customer();
		
		c.makecustomer(450);
		
		double match=c.acc.makeDeposit(50);
		double EXPECTED=c.acc.Balance;
		Assert.assertEquals(EXPECTED, match);
		
				
		
	}
	@Test
	public void NegDepositAmount() throws NumberFormatException, IOException {
		
		
		Customer c=new Customer();
		
		c.makecustomer(450);
		double EXPECTED=c.acc.Balance;
		double match=c.acc.makeDeposit(50);
		Assert.assertFalse(EXPECTED==match);
				
	}
	@Test
	public void Zakat() throws NumberFormatException, IOException {
		
		
		Customer c=new Customer();
		
		c.makecustomer(450);
		
		
		double match=c.acc.calculateZakat();System.out.println(match+"    ");
		double EXPECTED= c.acc.Balance*2.5/100;System.out.println(EXPECTED+"   ");
		Assert.assertEquals(EXPECTED, match);
		
				
		
	}
	
	@Test
	public void NegZakat() throws NumberFormatException, IOException {
		
		
		Customer c=new Customer();
		
		c.makecustomer(463);
		
		
		double match=c.acc.calculateZakat();
		double EXPECTED=0;
		Assert.assertEquals(EXPECTED, match);
		
				
		
	}
	
	@Test
	public void moneyTransfer() throws NumberFormatException, IOException {
		
		
		Customer c=new Customer();
		
		c.makecustomer(450);
		
		
		boolean match=c.acc.transferAmount(30,463);
		boolean EXPECTED=true;
		Assert.assertEquals(EXPECTED, match);
		
			
	}
	
	@Test
	public void logincheck() throws NumberFormatException, IOException {
		
		
		Customer c=new Customer();
		
		c.makecustomer(450);
		
		System.out.println("enter account id 450 for test case\n");	
		c.newCustomer();
		c.login();
		c.acc.printStatement();
		
		Assert.assertEquals(true, true);
				
		
	}
	
	
	
	
	@Test
	public void Accdeletion() throws NumberFormatException, IOException {
		
		
		Customer c=new Customer();
		
		c.makecustomer(885);
		
		
		boolean match=c.acc.deletebankAcc(885);
		boolean EXPECTED=true;
		Assert.assertEquals(EXPECTED, match);
		
			
	}
}

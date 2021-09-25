import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BankAcc {

	int acc_no;
	long Balance;
	String date_created;
	String customer_name;
	String customer_phone_no;
	String customer_address;

	void performActions() throws NumberFormatException, IOException {
		
		
		
		int option=0;
		
		
		System.out.println("----------------What services would you like to have-----------\n" + "(1) make deposit\n"
				+ "(2) make withdrawal\n" + "(3) check your balance\n" + "(4) print Statement\n"
				+ "(5) transfer amount to another account\n" + "(6) Calculate Zakat\n" + "(7) Exit\n"
				+ "\n  Enter your input\n");
		Scanner sc = new Scanner(System.in);
		 option = sc.nextInt();
		if (option == 4) {
			printStatement();
			
		}
		if (option == 1) {
			System.out.println("how much amount would you like to deposit\n");
			int amount = sc.nextInt();
			sc.close();
			makeDeposit(amount);
		}
		if (option == 2) {
			System.out.println("how much amount would you like to withdraw\n");
			int amount = sc.nextInt();
			makeWithdrawal(amount);
			sc.close();
			}
		if (option == 3) {
			checkBalance();
		}
		if (option == 5) {
			System.out.println("Please enter the account number you want to tranfer funds\n");
			int input=sc.nextInt();
			System.out.println("how much amount would you like to transfer\n");
			int amount = sc.nextInt();
			transferAmount(amount,input);
			
		}
		if (option == 6) {
			calculateZakat();
		}
		//if (option == 7) {
			sc.close();
		//}
		
		
	}
	
	double  calculateZakat(){

		double zakat=0;
		
		if(Balance>=20000) {
			zakat=(Balance*2.5)/100;
		System.out.println("Zakat is "+ zakat + " rupees\n");
		}
		else
			System.out.println("Balance is less than 20000 rupees\n");
		return zakat;
	}
	boolean transferAmount(int amount,int input) throws IOException {
	
		
		
		String line="";String accno="";boolean check=false;
		//File file=new File("Accounts.txt");
		try {
			BufferedReader br=new BufferedReader(new FileReader("Accounts.txt"));
			while( (line = br.readLine() )!= null) {
				StringTokenizer t=new StringTokenizer(line,",");
				accno=t.nextToken();
				if(input == Integer.parseInt(accno))
				{System.out.println("Account found\nTranferring funds........\n");check=true;br.close();
			     Balance-=amount;UpdateBalance(acc_no,Balance);
			     for(int i=0;i<5;i++)
			    	 t.nextToken();
			     long bal=Integer.parseInt(t.nextToken());bal+=amount;
			     UpdateBalance(input,bal);
			     
				break;}
			}br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("No data exists at the moment");
		}
		if(check==false)
			System.out.println("Your account does not exist\n");
		
		return check;
	}

	double makeDeposit(int amount) throws NumberFormatException, IOException {
		
		Balance += amount;
		UpdateBalance(acc_no,Balance);
		System.out.println(amount+" rupees have been deposited in your account\n");
		return Balance;
	}
		

	double makeWithdrawal(int amount) throws IOException, IOException{
		
		
		Balance -= amount;
		UpdateBalance(acc_no,Balance);
		
		System.out.println(amount+" rupees have been deducted from your account\n");
		return Balance;
	}
	double checkBalance() {
		System.out.println("YOur current balance is "+ Balance + " rupees\n");
		return Balance;
	}
	void printStatement() {

		System.out.println("Your bank details are........\n" + "Customer name= " + customer_name + "\n"
				+ "Contact number= " + customer_phone_no + "\n" + "Address details= " + customer_address + "\n"
				+ "Bank Account Number= " + acc_no + "\n" + "Account Balance= " + Balance + "\n" + "Date created= "
				+ date_created + "\n");

	}

	void UpdateBalance(int acc,long bal) throws IOException {
		int acc_n=1;String filepath="Accounts.txt";
		
		  Scanner x= new Scanner(new File(filepath)); x.useDelimiter("[,\n]");
		  String line="";
		  do {
			  acc_n=Integer.parseInt(x.next());
		   if(acc_n==acc) { 
		  line+=acc_n; for(int i=0;i<5;i++) line+=","+x.next(); line+=","+bal;x.next();
		  
		 
		  
		  } else { line+=acc_n; for(int i=0;i<6;i++) line+=","+x.next();
		  }
		   line+="\n";
		  
		  }while(x.hasNext()); 
		  File file=new File("temp.txt");
		  FileWriter writeonfile; writeonfile = new FileWriter(file,true);
		  writeonfile.write(line); writeonfile.close();
		  x.close();
		  File ffile=new File("temp.txt");
			if(ffile.exists())
			{
				File oldfile=new File("Accounts.txt");
					oldfile.delete();
					ffile.renameTo(new File("Accounts.txt"));
			}
		  
		 
	}
	
	boolean deletebankAcc(int ac) throws IOException{
		
		int acc_n=1;String filepath="Accounts.txt";
		
		  Scanner x= new Scanner(new File(filepath)); x.useDelimiter("[,\n]");
		  String line="";int aa=0;
		  boolean check=false;
		  do {
			  aa=0;
			  acc_n=Integer.parseInt(x.next());
		   if(acc_n==ac) { check=true;aa=1;
		  for(int i=0;i<5;i++) x.next();
		  x.next();
		  } else { line+=acc_n; for(int i=0;i<6;i++) line+=","+x.next();
		  }
		   if(x.hasNext() && aa!=1)
		   line+="\n";
		  
		  }while(x.hasNext()); 
		  
		  File file=new File("temp.txt");
		  FileWriter writeonfile; writeonfile = new FileWriter(file,true);
		  writeonfile.write(line); writeonfile.close();
		  x.close();
		  File ffile=new File("temp.txt");
			if(ffile.exists())
			{
				File oldfile=new File("Accounts.txt");
					oldfile.delete();
					ffile.renameTo(new File("Accounts.txt"));
			}
		  System.out.println("account deleted\n");
		return check;
	}
	
}

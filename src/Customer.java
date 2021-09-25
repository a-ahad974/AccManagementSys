import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Customer {

	String name;
	String address;
	String phone_no; 
	int acc_no;
	BankAcc acc=new BankAcc();
	String acc_type;
	void newCustomer() throws IOException {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter your name\n");
		name=sc.nextLine();
		System.out.println("Please enter your address\n");
		address=sc.nextLine();
		System.out.println("Please enter your phone number\n");
		phone_no=sc.nextLine();
		System.out.println("Please enter your account type\n");
		acc_type=sc.nextLine();
		System.out.println("Your account has been created\n");
		Random rand=new Random();
		acc_no=rand.nextInt(1000);
		System.out.println("Your account number is "+ acc_no+"\n");	
			
	
			LocalDate ld=LocalDate.now();
			acc.date_created=ld.format(DateTimeFormatter.ofPattern("uuuu/MM/dd"));
			acc.acc_no=acc_no;
			acc.Balance=0;
			File file=new File("Accounts.txt");
			FileWriter writeonfile=new FileWriter(file,true);
			writeonfile.write(Integer.toString(acc_no)+","+name+","+address+","
			+phone_no+","+acc_type+","+acc.date_created+","+acc.Balance+"\n");
			writeonfile.close();
		acc.customer_name=name;acc.customer_address=address;acc.customer_phone_no=phone_no;
	}
	
	void login() throws IOException {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter your unique account number\n");
		int input=sc.nextInt();
		String line="";String accno="";boolean check=false;
		//File file=new File("Accounts.txt");
		try {
			BufferedReader br=new BufferedReader(new FileReader("Accounts.txt"));
			while( (line = br.readLine() )!= null) {
				StringTokenizer t=new StringTokenizer(line,",");
				accno=t.nextToken();
				if(input == Integer.parseInt(accno))
				{System.out.println("Account found\nLoggin in.........\n");check=true;
				acc_no=input;acc.acc_no=acc_no;name=t.nextToken();address=t.nextToken();
				phone_no=t.nextToken();acc_type=t.nextToken();acc.date_created=t.nextToken();
				acc.customer_name=name;acc.customer_address=address;acc.customer_phone_no=phone_no;
				acc.Balance=Integer.parseInt(t.nextToken());
				break;}
			}br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("No data exists at the moment");
		}
		if(check==false)
			System.out.println("Your account does not exist\n");
		else
		acc.performActions();
		
	}
	boolean deleteAccount() throws IOException {
		
		System.out.println("Enter your account number and we will delete your account\n");
		Scanner sc = new Scanner(System.in);
		int ac=sc.nextInt();
		boolean deletion=acc.deletebankAcc(ac);
		sc.close();
		return deletion;
	}
	void makecustomer(int input) throws NumberFormatException, IOException {
		
	
		String line="";String accno="";boolean check=false;
		//File file=new File("Accounts.txt");
			BufferedReader br=new BufferedReader(new FileReader("Accounts.txt"));
			while( (line = br.readLine() )!= null) {
				StringTokenizer t=new StringTokenizer(line,",");
				accno=t.nextToken();
				if(input == Integer.parseInt(accno))
				{check=true;
				acc_no=input;acc.acc_no=acc_no;name=t.nextToken();address=t.nextToken();
				phone_no=t.nextToken();acc_type=t.nextToken();acc.date_created=t.nextToken();
				acc.customer_name=name;acc.customer_address=address;acc.customer_phone_no=phone_no;
				acc.Balance=Integer.parseInt(t.nextToken());
				break;}
			}
			br.close();
			
		
	}
	
}

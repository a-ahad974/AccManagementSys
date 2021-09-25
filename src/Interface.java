import java.io.File;
import java.io.IOException;
import java.util.*;
public class Interface {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

			Menu();
		
	}

	static void Menu() throws IOException {
		File file=new File("temp.txt");
		if(file.exists())
		{
			File oldfile=new File("Accounts.txt");
				oldfile.delete();
				file.renameTo(new File("Accounts.txt"));
		}
		Customer c=new Customer();
		System.out.println("(1) Open a New Account\n"
				+ "(2) Close an account\n"
				+ "(3) Login to a specific account by providing the unique account number\n"
				+ "(4) Perform account operations\n"
				+ "\n  Enter your input\n");
		
		Scanner sc = new Scanner(System.in);
		int option=sc.nextInt();		
		if (option==1) {
			c.newCustomer();
			sc.close();
		}
		if (option==3) {
			c.login();
			
			sc.close();
		}
		if (option==4) {
			System.out.println("login in first\n");
			c.login();
			
		}
		if (option==2) {
			c.deleteAccount();
		}
		sc.close();
	}


}

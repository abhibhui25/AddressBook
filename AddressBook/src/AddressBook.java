import java.util.*;

class Contacts {
	String fname, lname, address, city, state, zip, pno, email;
	Scanner sc = new Scanner(System.in);

	public void addContact() {

		System.out.println("Enter the first name");
		fname = sc.next();
		System.out.println("Enter the last name");
		lname = sc.next();
		System.out.println("Enter the address");
		address = sc.next();
		System.out.println("Enter the city");
		city = sc.next();
		System.out.println("Enter the state");
		state = sc.next();
		System.out.println("Enter the zip code");
		zip = sc.next();
		System.out.println("Enter the phone number");
		pno = sc.next();
		System.out.println("Enter the email");
		email = sc.next();
	}

	public void showContact() {
		System.out.println("Name: " + fname + " " + lname);
		System.out.println("Address: " + address);
		System.out.println("City: " + city);
		System.out.println("State: " + state);
		System.out.println("Zip: " + zip);
		System.out.println("Phone number: " + pno);
		System.out.println("Email: " + email);
	}
}

public class AddressBook {
	public static void main(String[] args) {
		System.out.println("Welcome to Address Book program ");
		Contacts c = new Contacts();
		c.addContact();
		c.showContact();
	}
}

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

	public void editContact() {
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
}

public class AddressBook {
	public static void main(String[] args) {
		System.out.println("Welcome to Address Book program ");
		Scanner sc = new Scanner(System.in);
		Contacts c = new Contacts();
		int x = 0;
		while (x != 5) {
			System.out.println("1.Add a contact");
			System.out.println("2.Edit a contact by name");
			System.out.println("3.View contact details by name");
			System.out.println("4.Delete a contact by name");
			System.out.println("5.Exit");
			int k = sc.nextInt();

			if (k == 1) {

				c.addContact();
			} else if (k == 2) {

				System.out.println("Enter First Name");
				String f = sc.next();
				System.out.println("Enter Last Name");
				String l = sc.next();
				String first = c.fname;
				String last = c.lname;
				if (first.equals(f) && last.equals(l)) {
					c.editContact();
				} else
					System.out.println("contact not found");
			} else if (k == 3)
				c.showContact();
			else if (k == 4) {
				System.out.println("Enter First Name");
				String f = sc.next();
				System.out.println("Enter Last Name");
				String l = sc.next();
				String first = c.fname;
				String last = c.lname;
				if (first.equals(f) && last.equals(l)) {

					c = null;
				} else
					System.out.println("contact not found");
			}

			else if (k == 5)
				System.exit(0);
		}
	}
}

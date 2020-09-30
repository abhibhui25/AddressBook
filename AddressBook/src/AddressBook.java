import java.util.*;

class Contacts {
	String fname, lname, address, city, state, zip, pno, email;
	Scanner sc = new Scanner(System.in);

	public void addContact() {

		System.out.println("Enter the first name");
		this.fname = sc.next();
		System.out.println("Enter the last name");
		this.lname = sc.next();
		System.out.println("Enter the address");
		this.address = sc.next();
		System.out.println("Enter the city");
		this.city = sc.next();
		System.out.println("Enter the state");
		this.state = sc.next();
		System.out.println("Enter the zip code");
		this.zip = sc.next();
		System.out.println("Enter the phone number");
		this.pno = sc.next();
		System.out.println("Enter the email");
		this.email = sc.next();
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
		this.address = sc.next();
		System.out.println("Enter the city");
		this.city = sc.next();
		System.out.println("Enter the state");
		this.state = sc.next();
		System.out.println("Enter the zip code");
		this.zip = sc.next();
		System.out.println("Enter the phone number");
		this.pno = sc.next();
		System.out.println("Enter the email");
		this.email = sc.next();
	}
}

public class AddressBook {
	public static void main(String[] args) {
		System.out.println("Welcome to Address Book program ");
		ArrayList<Contacts> cont = new ArrayList<Contacts>();
		Scanner sc = new Scanner(System.in);
		int k = 0;
		while (k != 5) {
			System.out.println("1.Add a contact");
			System.out.println("2.Edit a contact by name");
			System.out.println("3.View contact details by name");
			System.out.println("4.Delete a contact by name");
			System.out.println("5.Exit");
			k = sc.nextInt();

			if (k == 1) {
				Contacts c = new Contacts();
				c.addContact();
				cont.add(c);
				System.out.println("The contact was added successfully!");
			} else if (k == 2) {

				System.out.println("Enter the first name");
				String first = sc.next();
				System.out.println("Enter the last name");
				String last = sc.next();
				int p = 0, i = 0;
				for (i = 0; i < cont.size(); i++) {
					if (cont.get(i).fname.equalsIgnoreCase(first) && cont.get(i).lname.equalsIgnoreCase(last)) {
						p = 1;
						break;
					}
				}
				if (p == 0) {
					System.out.println("Contact not found");
				} else {
					cont.get(i).editContact();
					System.out.println("The contact was modified successfully!");
				}

			} else if (k == 3) {
				System.out.println("Enter the first name");
				String first = sc.next();
				System.out.println("Enter the last name");
				String last = sc.next();
				int p = 0, i = 0;
				for (i = 0; i < cont.size(); i++) {
					if (cont.get(i).fname.equalsIgnoreCase(first) && cont.get(i).lname.equalsIgnoreCase(last)) {
						p = 1;
						break;
					}
				}
				if (p == 0) {
					System.out.println("Contact not found");
				} else {
					cont.get(i).showContact();
				}
			} else if (k == 4) {
				System.out.println("Enter the first name");
				String first = sc.next();
				System.out.println("Enter the last name");
				String last = sc.next();
				int p = 0, i = 0;
				for (i = 0; i < cont.size(); i++) {
					if (cont.get(i).fname.equalsIgnoreCase(first) && cont.get(i).lname.equalsIgnoreCase(last)) {
						p = 1;
						break;
					}
				}
				if (p == 0)
					System.out.println("Contact not found");
				else
					cont.remove(i);
				System.out.println("The contact was deleted successfully!");
			}

			else if (k == 5) {
				System.exit(0);
				System.out.println("Thanks for using the Address Book!");
			}
		}
	}
}

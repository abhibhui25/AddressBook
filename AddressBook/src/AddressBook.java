import java.util.*;

class AddressBook {
	public static void main(String args[]) {
		System.out.println("Welcome to Address Book program");
		Scanner sc = new Scanner(System.in);
		ArrayList<AddressB> adbook = new ArrayList<AddressB>();
		int r = 0;
		while (r != 3) {
			System.out.println("1.CREATE ADDRESSBOOK");
			System.out.println("2.ACCESS ADDRESSBOOK");
			System.out.println("3.EXIT APPLICATION");
			r = sc.nextInt();
			AddressB bk;
			switch (r) {
			case 1: {
				System.out.println("Enter the address book name to be created");
				String n = sc.next();
				bk = new AddressB();
				bk.bName = n;
				adbook.add(bk);
				break;
			}
			case 2: {
				int key = 0;
				System.out.println("Enter the address book name to be accessed");
				String b = sc.next();
				for (int j = 0; j < adbook.size(); j++) {
					if (adbook.get(j).bName.equalsIgnoreCase(b)) {
						key = 1;
						int x = 0;
						while (x != 5) {
							System.out.println("1.Add contact");
							System.out.println("2.Edit contact by name");
							System.out.println("3.View details by name");
							System.out.println("4.Delete contact");
							System.out.println("5.Exit");
							x = sc.nextInt();
							if (x == 1) {
								Contact a = new Contact();
								a.addContact();
								adbook.get(j).ar.add(a);
							} else if (x == 2) {
								System.out.println("Enter First Name");
								String f = sc.next();
								System.out.println("Enter Last Name");
								String l = sc.next();
								int k = 0, i = 0;
								for (i = 0; i < adbook.get(j).ar.size(); i++) {
									if (adbook.get(j).ar.get(i).fname.equalsIgnoreCase(f)
											&& adbook.get(j).ar.get(i).lname.equalsIgnoreCase(l)) {
										k = 1;
										break;
									}
								}
								if (k == 0) {
									System.out.println("******No Contact found******");
								} else {
									adbook.get(j).ar.get(i).editContact();
								}
							} else if (x == 3) {
								System.out.println("Enter First Name");
								String f = sc.next();
								System.out.println("Enter Last Name");
								String l = sc.next();
								int k = 0, i = 0;
								for (i = 0; i < adbook.get(i).ar.size(); i++) {
									if (adbook.get(j).ar.get(i).fname.equalsIgnoreCase(f)
											&& adbook.get(j).ar.get(i).lname.equalsIgnoreCase(l)) {
										k = 1;
										break;
									}
								}
								if (k == 0) {
									System.out.println("******No Contact found******");
								} else {
									adbook.get(j).ar.get(i).viewContact();
								}
							} else if (x == 4) {
								System.out.println("Enter First Name");
								String f = sc.next();
								System.out.println("Enter Last Name");
								String l = sc.next();
								int k = 0;
								for (int i = 0; i < adbook.get(j).ar.size(); i++) {
									if (adbook.get(j).ar.get(i).fname.equalsIgnoreCase(f)
											&& adbook.get(j).ar.get(i).lname.equalsIgnoreCase(l)) {
										k = 1;
										adbook.get(j).ar.remove(i);
										System.out.println("Contact Deleted!");
										break;
									}
								}
								if (k == 0) {
									System.out.println("No Contact found!");

								}
							} else if (x == 5) {
								break;
							}
						}
						break;
					}
				}
				if (key == 0) {
					System.out.println("Address Book does not exist!");
				}
			}
			default:
				break;
			}
		}
	}
}

class AddressB {
	String bName;
	ArrayList<Contact> ar = new ArrayList<Contact>();

}

class Contact {
	Scanner sc = new Scanner(System.in);
	String fname, lname, address, String, city, state, zip, pno, email;

	public void addContact() {

		System.out.println("Enter First Name");
		this.fname = sc.next();
		System.out.println("Enter Last Name");
		this.lname = sc.next();
		System.out.println("Enter Address");
		this.address = sc.next();
		System.out.println("Enter city");
		this.city = sc.next();
		System.out.println("Enter state");
		this.state = sc.next();
		System.out.println("Enter zip code");
		this.zip = sc.next();
		System.out.println("Enter phone number");
		this.pno = sc.next();
		System.out.println("Enter email");
		this.email = sc.next();
	}

	public void editContact() {
		System.out.println("Enter Address");
		this.address = sc.next();
		System.out.println("Enter city");
		this.city = sc.next();
		System.out.println("Enter state");
		this.state = sc.next();
		System.out.println("Enter zip code");
		this.zip = sc.next();
		System.out.println("Enter phone number");
		this.pno = sc.next();
		System.out.println("Enter email");
		this.email = sc.next();
	}

	public void viewContact() {
		System.out.println("ADDRESS = " + this.address);
		System.out.println("CITY = " + this.city);
		System.out.println("STATE = " + this.state);
		System.out.println("ZIP = " + this.zip);
		System.out.println("PHONE NUMBER =" + this.pno);
		System.out.println("EMAIL =" + this.email);
	}
}

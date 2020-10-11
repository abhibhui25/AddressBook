import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class AddressBook {
	String bName;
	ArrayList<Contact> array = new ArrayList<Contact>();

}

class Contact {
	Scanner sc = new Scanner(System.in);
	String fName, lName, address, city, state, zip, pNo, email;

	public boolean equals(Contact c) {
		if (c.fName.equalsIgnoreCase(this.fName) && c.lName.equalsIgnoreCase(this.lName)) {
			return true;
		} else {
			return false;
		}
	}

	public void addContact() {

		System.out.println("Enter the first name:");
		this.fName = sc.next();
		System.out.println("Enter the last name:");
		this.lName = sc.next();
		System.out.println("Enter the address:");
		this.address = sc.next();
		System.out.println("Enter the city:");
		this.city = sc.next();
		System.out.println("Enter the state:");
		this.state = sc.next();
		System.out.println("Enter the zip code:");
		this.zip = sc.next();
		System.out.println("Enter the phone number:");
		this.pNo = sc.next();
		System.out.println("Enter the email:");
		this.email = sc.next();
	}

	public void editContact() {
		System.out.println("Enter the address:");
		this.address = sc.next();
		System.out.println("Enter the city:");
		this.city = sc.next();
		System.out.println("Enter the state:");
		this.state = sc.next();
		System.out.println("Enter the zip code:");
		this.zip = sc.next();
		System.out.println("Enter the phone number:");
		this.pNo = sc.next();
		System.out.println("Enter the email:");
		this.email = sc.next();
	}

	public void viewContact() {
		System.out.println("address:" + this.address);
		System.out.println("city:" + this.city);
		System.out.println("state:" + this.state);
		System.out.println("zip:" + this.zip);
		System.out.println("phone no. :" + this.pNo);
		System.out.println("email:" + this.email);
	}
}

public class Address {

	static boolean duplicateCheck(AddressBook ab, Contact contact) {
		return (ab.array.stream().anyMatch(c -> c.equals(contact)));
	}
	static List<Contact> searchNameByCity(AddressBook adbook, String cityString) {
		return adbook.array.stream().filter(c -> c.city.equals(cityString)).collect(Collectors.toList());
	}

	static List<Contact> searchNameByState(AddressBook adbook, String stateString) {
		return adbook.array.stream().filter(c -> c.state.equals(stateString)).collect(Collectors.toList());
	}
	static ArrayList<AddressBook> createAddressBook(ArrayList<AddressBook> abook) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter name of address book you want to create:");
		String n = scanner.next();
		int key = 0;
		for (int i = 0; i < abook.size(); i++) {
			if (abook.get(i).bName.equalsIgnoreCase(n)) {
				key = 1;
				break;
			}
		}
		if (key == 0) {
			AddressBook book = new AddressBook();
			book.bName = n;
			book.array = new ArrayList<Contact>();
			abook.add(book);
			return abook;
		} else {
			System.out.println("Address Book Already present!!!");
			return createAddressBook(abook);
		}
	}

	static ArrayList<AddressBook> accessAddressBook(ArrayList<AddressBook> book) {
		Scanner scanner = new Scanner(System.in);
		int temp = 0;
		System.out.println("Enter the address book name to be accessed");
		String b = scanner.next();
		for (int j = 0; j < book.size(); j++) {
			if (book.get(j).bName.equalsIgnoreCase(b)) {
				temp = 1;
				int temp1 = 0;
				while (temp1 != 5) {
					System.out.println("1.Add contact");
					System.out.println("2.Edit contact by name");
					System.out.println("3.View contact by name");
					System.out.println("4.Delete contact");
					System.out.println("5.Exit the present book");
					temp1 = scanner.nextInt();
					Contact a;
					if (temp1 == 1) {
						a = new Contact();
						a.addContact();
						if (duplicateCheck(book.get(j), a)) {
							System.out.println("contact already present!!!");
						} else {
							book.get(j).array.add(a);
						}
					} else if (temp1 == 2) {
						System.out.println("Enter first name:");
						String f = scanner.next();
						System.out.println("Enter last name:");
						String l = scanner.next();
						int k = 0, i = 0;
						for (i = 0; i < book.get(j).array.size(); i++) {
							if (book.get(j).array.get(i).fName.equalsIgnoreCase(f)
									&& book.get(j).array.get(i).lName.equalsIgnoreCase(l)) {
								k = 1;
								break;
							}
						}
						if (k == 0) {
							System.out.println("not found");
						} else {
							book.get(j).array.get(i).editContact();
						}
					} else if (temp1 == 3) {
						System.out.println("Enter first name:");
						String f = scanner.next();
						System.out.println("Enter last name");
						String l = scanner.next();
						int k = 0, i = 0;
						for (i = 0; i < book.get(j).array.size(); i++) {
							if (book.get(j).array.get(i).fName.equalsIgnoreCase(f)
									&& book.get(j).array.get(i).lName.equalsIgnoreCase(l)) {
								k = 1;
								break;
							}
						}
						if (k == 0) {
							System.out.println("not found");
						} else {
							book.get(j).array.get(i).viewContact();
						}
					} else if (temp1 == 4) {
						System.out.println("Enter first name:");
						String f = scanner.next();
						System.out.println("Enter last name:");
						String l = scanner.next();
						int k = 0;
						for (int i = 0; i < book.get(j).array.size(); i++) {
							if (book.get(j).array.get(i).fName.equalsIgnoreCase(f)
									&& book.get(j).array.get(i).lName.equalsIgnoreCase(l)) {
								k = 1;
								book.get(j).array.remove(i);
								System.out.println("Contact deleted");
								break;
							}
						}
						if (k == 0) {
							System.out.println("not found");

						}
					} else if (temp1 == 5) {
						break;
					}
				}
			}
		}
		if (temp == 0) {
			System.out.println("address book not present!!!");
		}
		return book;
	}
	static void accessByCity(ArrayList<AddressBook> book) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the city: ");
		String city = sc.next();
		List<Contact> list = new ArrayList();
		for (int k = 0; k < book.size(); k++) {
			list.addAll(searchNameByCity(book.get(k), city));
		}
		if (list.size() == 0) {
			System.out.println("No contact found");
		} else {
			for (int k = 0; k < book.size(); k++) {
				System.out.println(list.get(k).fName + " " + list.get(k).lName);
			}
			
		}
	}

	static void accessByState(ArrayList<AddressBook> book) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the State ");
		String state = scanner.next();
		List<Contact> list = new ArrayList();
		for (int k = 0; k < book.size(); k++) {
			list.addAll(searchNameByState(book.get(k), state));
		}
		if (list.size() == 0) {
			System.out.println("No Contacts Found");
		} else {
			for (int k = 0; k < book.size(); k++) {
				System.out.println(list.get(k).fName + " " + list.get(k).lName);
			}
			
		}
	}
	public static void main(String args[]) {
		System.out.println("Welcome to the address book program");
		Scanner scanner = new Scanner(System.in);
		ArrayList<AddressBook> adbook = new ArrayList<AddressBook>();
		int r = 0;
		while (r != 5) {
			System.out.println("1.Create AddressBook");
			System.out.println("2.Access AddressBook");
			System.out.println("3.Exit");
			System.out.println("4.Check contacts by city");
			System.out.println("5.Check contacts by state");
			r = scanner.nextInt();
			AddressBook book;
			switch (r) {
			case 1: {
				adbook = createAddressBook(adbook);
				break;
			}
			case 2: {
				adbook = accessAddressBook(adbook);
				break;
			}
			case 3: {
				accessByCity(adbook);
				break;
			}
			case 4: {
				accessByState(adbook);
				break;
			}
			}
		}
	}
}
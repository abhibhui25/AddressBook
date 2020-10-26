package com.cg.addressbook;

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

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    public String getpNo() {
        return pNo;
    }

    public String getEmail() {
        return email;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setpNo(String pNo) {
        this.pNo = pNo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean equals(Contact c) {
        if (c.fName.equalsIgnoreCase(this.fName) && c.lName.equalsIgnoreCase(this.lName)) {
            return true;
        } else {
            return false;
        }
    }
    @Override
    public String toString() {
        return this.fName + ", " + this.lName;
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
    static void sortByName(AddressBook adbook) {
        adbook.array.stream().sorted((c1, c2) -> c1.fName.concat(c1.lName).compareTo(c2.fName.concat(c2.lName))).forEach(System.out::println);

    }
    static void sortByCity(AddressBook adbook) {
        adbook.array.stream().sorted((c1, c2) -> c1.city.compareTo(c2.city))
                .forEach(c -> System.out.println(c.fName + ", " + c.lName + "belongs to city " + c.city));

    }

    static void sortByState(AddressBook adbook) {
        adbook.array.stream().sorted((c1, c2) -> c1.state.compareTo(c2.state))
                .forEach(c -> System.out.println(c.fName + ", " + c.lName + " belongs to state " + c.state));

    }

    static void sortByZip(AddressBook adbook) {
        adbook.array.stream().sorted((c1, c2) -> c1.zip.compareTo(c2.zip))
                .forEach(c -> System.out.println(c.fName + ", " + c.lName + " belongs to zip " + c.zip));

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
    public void readFromFile() throws FileNotFoundException {
        File f=new File("F:\\contacts.txt");
        Scanner myFile = new Scanner(f);
        while(myFile.hasNextLine()){
            try
            {
                Contact c= new Contact();
                String data=myFile.nextLine();
                String[] str=data.split(" ");
                c.setfName(str[0]);
                c.setlName(str[1]);
                c.setAddress(str[2]);
                c.setCity(str[3]);
                c.setState(str[4]);
                c.setZip(str[5]);
                c.setpNo(str[6]);
                c.setEmail(str[7]);
                addContact();
            }catch (Exception e){
                System.out.println("Invalid contact");
            }
        }

    }

    public void writeInFile() {
        try {
            FileWriter fileWriter = new FileWriter("F:\\AddressBook.txt",true);
            for (Contact c:address_book){
                fileWriter.write(c.getfName()+" "+c.getlName()+" "
                        +c.getAddress()+" "+c.getCity()+" "+c.getState()+" "
                        +c.getpNo()+" "+c.getEmail()+"\n");
            }
            fileWriter.close();
        }
        catch (IOException e){
            System.out.println("File not exists.");
        }
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
                while (temp1 != 11) {
                    System.out.println("1.Add contact");
                    System.out.println("2.Edit contact by name");
                    System.out.println("3.View contact by name");
                    System.out.println("4.Delete contact");
                    System.out.println("5.Sort based on name");
                    System.out.println("6.Sort based on city");
                    System.out.println("7.Sort based on state");
                    System.out.println("8.Sort based on zip");
                    System.out.println("9.Read from file");
                    System.out.println("10.Write to file");
                    System.out.println("11.Exit the present book");
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
                    }
                    else if(temp1==5){
                        sortByName(book.get(j));
                    }
                    else if(temp1==6){
                        sortByCity(book.get(j));
                    }
                    else if(temp1==7){
                        sortByState(book.get(j));
                    }
                    else if(temp1==8){
                        sortByZip(book.get(j));
                    }
                    if(temp1==9){
                        try{
                            book.readFromFile();
                        }catch (FileNotFoundException e){
                            System.out.println("File not found");
                        }
                        break;
                    }
                    else if(temp1==10){
                        book.writeInFile();
                        break;
                    }
                    else if (temp1 == 11) {
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
            System.out.println("The number of persons living in " + city + " city are " + list.size());
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
            System.out.println("The number of persons living in " + state + " state are " + list.size());
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
            System.out.println("3.Check contacts by city");
            System.out.println("4.Check contacts by state");
            System.out.println("5.Exit");

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
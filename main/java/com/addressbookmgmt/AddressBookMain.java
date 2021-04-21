package com.addressbookmgmt;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookMain {
    static ArrayList<Contact> addressBook = new ArrayList<>();

//This method takes contact object and into addressBook
    public static  boolean addContact(Contact contact) {
        return addressBook.add(contact);
    }

    public static boolean editContact(String pName) {
        Scanner userInput = new Scanner(System.in);
        for (int i = 0 ; i < addressBook.size(); i++) {
            String fName = addressBook.get(i).getFirstName();
            String lName =  addressBook.get(i).getLastName();
            String fullName =fName+" "+lName;
            if(fullName.equalsIgnoreCase(pName))
            {
                System.out.println("What would you like to edit");
                System.out.println("1.First Name");
                System.out.println("2.Last Name");
                System.out.println("3. Address");
                System.out.println("4.State Name");
                System.out.println("5.City Name");
                System.out.println("6. Zip");
                System.out.println("7.Mobile No");
                System.out.println("8.Email");
                int option = userInput.nextInt();
                switch(option) {
                    case 1:
                        System.out.println("Enter new First Name");
                        String newFirstName = userInput.next();
                        addressBook.get(i).setFirstName(newFirstName);
                        return true;
                    case 2:
                        System.out.println("Enter new Last Name");
                        String newLastName = userInput.next();
                        addressBook.get(i).setLastName(newLastName);
                        return true;
                    case 3:
                        System.out.println("Enter new Address");
                        String newAddress = userInput.next();
                        addressBook.get(i).setAddress(newAddress);
                        return true;
                    case 4:
                        System.out.println("Enter new State Name");
                        String newState = userInput.next();
                        addressBook.get(i).setState(newState);
                        return true;
                    case 5:
                        System.out.println("Enter new City Name");
                        String newCity = userInput.next();
                        addressBook.get(i).setCity(newCity);
                        return true;
                    case 6:
                        System.out.println("Enter new zip");
                        String newZip = userInput.next();
                        addressBook.get(i).setZip(newZip);
                        return true;
                    case 7:
                        System.out.println("Enter New Mobile No");
                        String newMobileNo = userInput.next();
                        addressBook.get(i).setMobNo(newMobileNo);
                        return true;
                    case 8:
                        System.out.println("Enter new email id:");
                        String newEmail = userInput.next();
                        addressBook.get(i).setEmail(newEmail);
                        return true;
                }

            }

        }
        return false;

    }

    public static void main(String[] args) {
        addContact(new Contact("murari","kumar","mokama","patna","bihar","4566755","8709628464","murari05@gmail.com"));
        editContact("murari kumar");
        displayContact();
    }

    private static void displayContact() {
        System.out.println(addressBook);
    }
}

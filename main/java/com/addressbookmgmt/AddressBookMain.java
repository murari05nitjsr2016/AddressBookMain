package com.addressbookmgmt;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookMain {
    static ArrayList<Contact> addressBook = new ArrayList<>();

//This method takes contact object and into addressBook
    public static  boolean addContact(Contact contact) {
        return addressBook.add(contact);
    }

    // This method delets the contact on person name
    public static boolean  deleteContactByPersonName(String name) {
        for (int i = 0; i < addressBook.size(); i++) {
            String fName = addressBook.get(i).getFirstName();
            String lName = addressBook.get(i).getLastName();
            String fullName = fName + " " + lName;
            if (fullName.equals(name)) {
                System.out.println("Contact is present");
                addressBook.remove(i);
                return true;

            } else return false;

        }
        return false;
    }

    public static void main(String[] args) {
        addContact(new Contact("murari","kumar","mokama","patna","bihar","4566755","8709628464","murari05@gmail.com"));
        addContact(new Contact("neeraj","kumar","mokama","patna","bihar","4566755","8709628465","murari05@gmail.com"));
        addContact(new Contact("manish","kumar","mokama","patna","bihar","4566755","8709628464","murari05@gmail.com"));
        addContact(new Contact("nitish","kumar","mokama","patna","bihar","4566755","8709628464","murari05@gmail.com"));
        deleteContactByPersonName("murari kumar");
        displayContact();
    }

    private static void displayContact() {
        System.out.println(addressBook);
    }
}

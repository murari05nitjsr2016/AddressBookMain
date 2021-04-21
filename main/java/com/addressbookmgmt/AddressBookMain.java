package com.addressbookmgmt;

import java.util.ArrayList;

public class AddressBookMain {
    static ArrayList<Contact> addressBook = new ArrayList<>();

//This method takes contact object and into addressBook
    public static  boolean addContact(Contact contact) {
        return addressBook.add(contact);
    }
    public static void main(String[] args) {
        System.out.println("Welcome in address book management");
        Contact contact = new Contact("murari","kumar","mokama","patna","bihar","4566755","8709628464","murari05@gmail.com");
        addContact(new Contact("murari","kumar","mokama","patna","bihar","4566755","8709628464","murari05@gmail.com"));
    }
}

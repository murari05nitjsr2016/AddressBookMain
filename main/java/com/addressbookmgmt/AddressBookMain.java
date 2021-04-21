package com.addressbookmgmt;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookMain {
    static ArrayList<Contact> addressBook = new ArrayList<>();

//This method takes contact object and into addressBook
    public static  boolean addContact(Contact contact) {

        return addressBook.add(contact);
    }

/*This method write the contect object into a file.
using IO stream we acheive Data persistence.
 */
    public static void writeContactObjectToFile() {
        try {
            FileOutputStream writData = new FileOutputStream("AddressBook");
            ObjectOutputStream writeStream = new ObjectOutputStream(writData);
            writeStream.writeObject(addressBook);
            writeStream.flush();
            writeStream.close();
            System.out.println("sucessfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        /*
        This method we retrive persistence object data
        from a File to our program.
         */

        public static void readObjectDataFromAFile(){
            try
            {
                FileInputStream readData = new FileInputStream("AddressBook");
                ObjectInputStream readStream = new ObjectInputStream(readData);

                addressBook = (ArrayList) readStream.readObject();

                readStream.close();
                readData.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
                return;
            }
            catch (ClassNotFoundException c)
            {
                System.out.println("Class not found");
                c.printStackTrace();
                return;
            }
            for (Contact contact : addressBook) {
                System.out.println(contact);
            }
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
        writeContactObjectToFile();
        readObjectDataFromAFile();

    }

    private static void displayContact() {
        System.out.println(addressBook);
    }
}

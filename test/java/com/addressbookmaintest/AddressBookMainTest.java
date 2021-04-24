package com.addressbookmaintest;

import com.addressbookmgmt.AddressBookMain;
import com.addressbookmgmt.Contact;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Scanner;

public class AddressBookMainTest {
    

//This test case checks on given name contact is edited or not
    @Test
    public void givenContactShouldEditOnPersonNameInAddressBookShouldReturnTrue(){
        AddressBookMain addressBookMain = new AddressBookMain();
        Contact contact = new Contact("murari","kumar","mokama","patna","bihar","4566755","8709628464","murari05@gmail.com");
        Scanner userInput = new Scanner(System.in);
        addressBookMain.addContact(contact);
        boolean result =   addressBookMain.editContact("murari kumar",userInput);
        Assertions.assertTrue(result);
    }

    @Test
    public void given3EmployeesWhenWrittenToFileShouldMatchEmployeeEntries(){
        Contact[] arrayOfContact = {
                new Contact("murari","kumar","mokama","patna","bihar","4566755","8709628464","murari05@gmail.com"),
                new Contact("murari","kumar","mokama","patna","bihar","4566755","8709628464","murari05@gmail.com"),
                new Contact("murari","kumar","mokama","patna","bihar","4566755","8709628464","murari05@gmail.com")
        };
        AddressBookMain addressBookMain;
        addressBookMain = new AddressBookMain(Arrays.asList(arrayOfContact));
        addressBookMain.writeContactData(AddressBookMain.IOService.FILE_IO);
        addressBookMain.printData(AddressBookMain.IOService.FILE_IO);
        long entries = addressBookMain.countEntries(AddressBookMain.IOService.FILE_IO);
        Assertions.assertEquals(3,entries);
    }

}

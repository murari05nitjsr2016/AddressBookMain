package com.addressbookmaintest;

import com.addressbookmgmt.AddressBookMain;
import com.addressbookmgmt.Contact;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddressBookMainTest {
    

//This test case checks on given name contact is edited or not
    @Test
    public void givenContactShouldEditOnPersonNameInAddressBookShouldReturnTrue(){
        AddressBookMain addressBookMain = new AddressBookMain();
        Contact contact = new Contact("murari","kumar","mokama","patna","bihar","4566755","8709628464","murari05@gmail.com");
        addressBookMain.addContact(contact);
        boolean result =   addressBookMain.editContact("murari kumar");
        Assertions.assertTrue(result);
    }

}

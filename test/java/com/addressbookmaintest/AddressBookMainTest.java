package com.addressbookmaintest;

import com.addressbookmgmt.AddressBookMain;
import com.addressbookmgmt.Contact;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddressBookMainTest {
    //This  method cheks either contact object is added or not
    @Test
    public void givenContactObjectWhenAddedIntoAddressBookShouldReturnTrue()
    {
        AddressBookMain addressBookMain = new AddressBookMain();
        Contact contact = new Contact("murari","kumar","mokama","patna","bihar","4566755","8709628464","murari05@gmail.com");
        boolean result =  addressBookMain.addContact(new Contact("murari","kumar","mokama","patna","bihar","4566755","8709628464","murari05@gmail.com"));
        Assertions.assertTrue(result);
    }
}

package com.addressbookmgmt;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class AddressBookFileIOService {
    public static String ADDRESS_BOOK_FILE_NAME ="addressbook.txt";

    public void writeData(ArrayList<Contact> addressBook2) {
        StringBuffer contBuffer = new StringBuffer();
        addressBook2.forEach(contact ->{
            String contactDataString = contact.toString().concat("\n");
            contBuffer.append(contactDataString);
        });
        try{
            Files.write(Paths.get(ADDRESS_BOOK_FILE_NAME),contBuffer.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void printData() {
        try{
            Files.lines(new File(ADDRESS_BOOK_FILE_NAME).toPath())
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public long countEntries() {
        long entries = 0;
        try{
            entries = Files.lines(new File(ADDRESS_BOOK_FILE_NAME).toPath()).count();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return entries;
    }


}

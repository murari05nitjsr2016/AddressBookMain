package com.addressbookmgmt;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBookMain {

    static ArrayList<Contact> addressBook = new ArrayList<>();
    List<Contact> addressBook2;
    public enum IOService{CONSOLE_IO,FILE_IO,REST_IO}
    private static String filePath = "C:\\Users\\MURARI\\IdeaProjects\\contact.csv";

    public AddressBookMain() {

    }

    public AddressBookMain(  List<Contact> addressBook2)
     {
          this.addressBook2 = addressBook2;

    }


    //This method takes contact object and into addressBook
    public static  boolean addContact(Contact contact) {

        return addressBook.add(contact);
    }

    public static boolean editContact(String pName,Scanner userInput) {
      //  Scanner userInput = new Scanner(System.in);
        for (int i = 0 ; i < addressBook.size(); i++) {
            String fName = addressBook.get(i).getFirstName();
            String lName =  addressBook.get(i).getLastName();
            String personName =fName+" "+lName;
            if(personName.equalsIgnoreCase(pName))
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
                    case 2:
                        System.out.println("Enter new Last Name");
                        String newLastName = userInput.next();
                        addressBook.get(i).setLastName(newLastName);
                    case 3:
                        System.out.println("Enter new Address");
                        String newAddress = userInput.next();
                        addressBook.get(i).setAddress(newAddress);
                    case 4:
                        System.out.println("Enter new State Name");
                        String newState = userInput.next();
                        addressBook.get(i).setState(newState);
                    case 5:
                        System.out.println("Enter new City Name");
                        String newCity = userInput.next();
                        addressBook.get(i).setCity(newCity);
                    case 6:
                        System.out.println("Enter new zip");
                        String newZip = userInput.next();
                        addressBook.get(i).setZip(newZip);
                    case 7:
                        System.out.println("Enter New Mobile No");
                        String newMobileNo = userInput.next();
                        addressBook.get(i).setMobNo(newMobileNo);
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
            System.out.println("sucessfully written");
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

    public static void main(String[] args) throws CsvRequiredFieldEmptyException, IOException, CsvDataTypeMismatchException {
        addContact(new Contact("murari","kumar","mokama","patna","bihar","4566755","8709628464","murari05@gmail.com"));
        addContact(new Contact("neeraj","kumar","mokama","patna","bihar","4566755","8709628465","murari05@gmail.com"));
        addContact(new Contact("manish","kumar","mokama","patna","bihar","4566755","8709628464","murari05@gmail.com"));
        addContact(new Contact("nitish","kumar","mokama","patna","bihar","4566755","8709628464","murari05@gmail.com"));
        deleteContactByPersonName("murari kumar");
        displayContact();
        writeContactObjectToFile();
        readObjectDataFromAFile();
        System.out.println("Welcome in IO Stream Concept");
        ArrayList<Contact> addressBook2 = new ArrayList<>();
        AddressBookMain addressBookMain = new AddressBookMain(addressBook2);
        Scanner consoleInputReader = new Scanner(System.in);
        addressBookMain.readContactData(consoleInputReader);
        addressBookMain.writeContactData(IOService.CONSOLE_IO);
        System.out.println("writing  contact object data to csv");
        writeObjectToCsv(filePath);
        System.out.println("reading  contact object data to csv");
        readCsv(filePath);
    }

    public void writeContactData(AddressBookMain.IOService ioService) {
        if(ioService.equals(AddressBookMain.IOService.CONSOLE_IO))
            System.out.println("\n Writing Contact Data to console\n" +addressBook2);
        else if(ioService.equals(IOService.FILE_IO))
            new AddressBookFileIOService().writeData((ArrayList<Contact>) addressBook2);
    }

    public void readContactData(Scanner consoleInputReader) {
        System.out.println("Enter  First Name");
        String firstName = consoleInputReader.next();
        System.out.println("Enter  Last Name");
        String lastName = consoleInputReader.next();
        System.out.println("Enter  Address");
        String address = consoleInputReader.next();
        System.out.println("Enter City");
        String city = consoleInputReader.next();
        System.out.println("Enter State");
        String state = consoleInputReader.next();
        System.out.println("Enter Zip");
        String zip = consoleInputReader.next();
        System.out.println("Enter MobNo");
        String mobNo = consoleInputReader.next();
        System.out.println("Enter Email");
        String email = consoleInputReader.next();
        addressBook2.add(new Contact(firstName,lastName,address,city,state,zip,mobNo,email));
    }
    public void printData(IOService ioService) {
        if(ioService.equals(IOService.FILE_IO))
            new AddressBookFileIOService().printData();
    }
    public long countEntries(IOService ioService) {
        if(ioService.equals(IOService.FILE_IO))
            return new AddressBookFileIOService().countEntries();
        return 0;

    }

    public static void writeObjectToCsv(String filepath) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
            try(Writer writer = Files.newBufferedWriter(Paths.get(filepath));)
        {
            StatefulBeanToCsv<Contact>  csv = new StatefulBeanToCsvBuilder<Contact>(writer).withQuotechar(CSVWriter.NO_QUOTE_CHARACTER).build();
            List<Contact>  contact = new ArrayList<>();
            contact.add(new Contact("murari","kumar","mokama","patna","bihar","4566755","8709628464","murari05@gmail.com"));
            contact.add(new Contact("kumar","murari","mokama","patna","bihar","4566755","8709628464","murari05@gmail.com"));
            csv.write(contact);
        }

    }

    public static void readCsv(String filePath) {
        BufferedReader reader = null;
        try {
            List<Contact> contact = new ArrayList<Contact>();
            String line = "";
            reader = new BufferedReader(new FileReader(filePath));
            reader.readLine();
            while (( reader.readLine() != null)) {
                String[] field = line.split(",");
                if (field.length > 0) {
                    Contact contacts = new Contact();
                    contacts.setFirstName("Murari");
                    contacts.setLastName("Kumar");
                    contacts.setAddress("Nauranga");
                    contacts.setCity("Patna");
                    contacts.setState("Bihar");
                    contacts.setZip("811302");
                    contacts.setMobNo("8709628464");
                    contacts.setEmail("murari05nitjsr@gmail.com");
                    contact.add(contacts);
                }
            }
            for (Contact ad : contact) {
                System.out.printf(
                        "[First Name = %s,Last Name = s, Address = %s, City = %s, State = %s,Zip = %s,Phone Number = %s,Email = %s]\n",
                        ad.getFirstName(), ad.getLastName(), ad.getAddress(), ad.getCity(), ad.getState(), ad.getZip(),
                        ad.getMobNo(), ad.getEmail());
            }
        } catch (Exception e) {
            e.fillInStackTrace();
        } finally {
            try {
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    private static void displayContact() {
        System.out.println(addressBook);
    }
}

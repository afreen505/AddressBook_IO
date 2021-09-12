package service;


import java.util.*;
import java.util.stream.Collectors;

import model.*;

public class AddressBookMain {
    public AddressBook addressBook = new AddressBook();
    public static Map<String, AddressBook> addressBookListMap = new HashMap<>();
    private static Scanner sc = new Scanner(System.in);

    /**
     * This method is used to add name of address book in the list of address book
     *
     * @param addressBookName : name of address book as first argument of method
     */
    public void addAddressBook(String addressBookName) {

        boolean flag = true;

        while (flag) {

            System.out.println("1.Add Contact");
            System.out.println("2.Edit Contact");
            System.out.println("3.Delete");
            System.out.println("4.Exit");
            System.out.println("Enter Choice: ");

            int option = sc.nextInt();

            switch (option) {
                case 1:
                    addressBook.addContactDetails();
                    break;

                case 2:
                    System.out.println("Enter the Person First name to edit details: ");
                    String personName = sc.next();

                    boolean listEdited = addressBook.editContactDetails(personName);
                    if (listEdited) {
                        System.out.println("List Edited Successfully");
                    } else {
                        System.out.println("List Cannot be Edited");
                    }
                    break;

                case 3:
                    System.out.println("Enter the Contact to be deleted:");
                    String firstName = sc.next();
                    boolean listDeleted = addressBook.deleteContact(firstName);
                    if (listDeleted) {
                        System.out.println("Deleted Contact from the List");
                    } else {
                        System.out.println("List Cannot be Deleted");
                    }
                    break;

                case 4:
                    flag = false;
                    break;

            }
        }
        addressBookListMap.put(addressBookName, addressBook);
        System.out.println("Address Book Added Successfully");
    }

    /**
     * to find person by state name
     *
     * @param stateName : first argument of method
     */
    public void searchPersonByState(String stateName) {
        for (Map.Entry<String, AddressBook> entry : addressBookListMap.entrySet()) {
            AddressBook value = entry.getValue();
            System.out.println("The Address Book: " + entry.getKey());
            value.getPersonNameByState(stateName);
        }
    }

    /**
     * to find person by city name
     *
     * @param cityName : name of city given by user
     */
    public void searchPersonByCity(String cityName) {
        for (Map.Entry<String, AddressBook> entry : addressBookListMap.entrySet()) {
            AddressBook value = entry.getValue();
            System.out.println("The Address Book: " + entry.getKey());
            value.getPersonNameByCity(cityName);
        }
    }

    /**
     * display the person state wise
     *
     * @param stateName : name of the state given by the user
     */
    public void viewPersonByStateUsingHashmap(String stateName) {
        for (Map.Entry<String, AddressBook> entry : addressBookListMap.entrySet()) {
            AddressBook value = entry.getValue();
            ArrayList<Persons> contacts = value.personByState.entrySet().stream()
                    .filter(findState -> findState.getKey().equals(stateName)).map(Map.Entry::getValue).findFirst()
                    .orElse(null);
            for (Persons contact : contacts) {
                System.out.println("First Name: " + contact.getFirstName() + " Last Name: " + contact.getLastName());
            }
        }
    }

    /**
     * display the person city wise
     *
     * @param cityName : name of the city given by the user
     */
    public void viewPersonByCityUsingHashMap(String cityName) {
        for (Map.Entry<String, AddressBook> entry : addressBookListMap.entrySet()) {
            AddressBook value = entry.getValue();
            ArrayList<Persons> contacts = value.personByCity.entrySet().stream()
                    .filter(findCity -> findCity.getKey().equals(cityName)).map(Map.Entry::getValue).findFirst()
                    .orElse(null);
            for (Persons contact : contacts) {
                System.out.println("First Name: " + contact.getFirstName() + " Last Name: " + contact.getLastName());
            }
        }
    }

    /**
     * This method count the number of person present in the state
     *
     * @param state : name of the state given by user
     */
    public void CountByState(String state) {
        int count = 0;
        for (Map.Entry<String, AddressBook> entry : addressBookListMap.entrySet()) {
            for (int i = 0; i < (entry.getValue()).contactList.size(); i++) {
                Persons contact = entry.getValue().contactList.get(i);

                if (state.equals(contact.getState())) {
                    count++;
                }

            }
        }
        System.out.println("Total Person Count in state " + state + ": " + count);
    }

    /**
     * This method count the number of person present in the city
     *
     * @param city : name of the city given by user
     */
    public void CountByCity(String city) {
        int countPersonInCity = 0;
        for (Map.Entry<String, AddressBook> entry : addressBookListMap.entrySet()) {
            for (int i = 0; i < (entry.getValue()).contactList.size(); i++) {
                Persons d = entry.getValue().contactList.get(i);

                if (city.equals(d.getCity())) {
                    countPersonInCity++;
                }

            }
        }
        System.out.println("Total number of people in this city " + city + ": " + countPersonInCity);
    }

    /**
     * This method is use to sort the contact list
     * according to person name
     */
    public void sortContactByName() {
        for (Map.Entry<String, AddressBook> entry : addressBookListMap.entrySet()) {
            AddressBook value = entry.getValue();
            List<Persons> sortedList = value.contactList.stream()
                    .sorted(Comparator.comparing(Persons::getFirstName)).collect(Collectors.toList());

            for (Persons contact : sortedList) {
                System.out.println("First Name: " + contact.getFirstName());
                System.out.println("Last Name: " + contact.getLastName());
                System.out.println("-------------------------");
            }
        }
    }

    /**
     * This method is use to sort the contact list
     * according to state name
     */
    public void sortContactByState() {
        for (Map.Entry<String, AddressBook> entry : addressBookListMap.entrySet()) {
            AddressBook value = entry.getValue();
            List<Persons> sortedList = AddressBook.contactList.stream()
                    .sorted(Comparator.comparing(Persons::getState)).collect(Collectors.toList());

            for (Persons contact : sortedList) {
                System.out.println("First Name: " + contact.getFirstName());
                System.out.println("Last Name: " + contact.getLastName());
                System.out.println("-------------------------------");
            }
        }
    }

    /**
     * This method is use to sort the contact list
     * according to city name
     */
    public void sortContactByCity() {
        for (Map.Entry<String, AddressBook> entry : addressBookListMap.entrySet()) {
            AddressBook value = entry.getValue();
            List<Persons> sortedList = AddressBook.contactList.stream()
                    .sorted(Comparator.comparing(Persons::getCity)).collect(Collectors.toList());

            for (Persons contact : sortedList) {
                System.out.println("First Name: " + contact.getFirstName());
                System.out.println("Last Name: " + contact.getLastName());
                System.out.println("-------------------------------");
            }
        }
    }

}

package service;

import java.util.Scanner;

public class AddressBookSimulator {
    public static void main(String args[]) {

        System.out.println("****Welcome to the Address Book System****");
        AddressBookMain addressBookMain = new AddressBookMain();
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("1. Add New Address Book");
            System.out.println("2. Search Contact from a city");
            System.out.println("3. Search Contact from a State");
            System.out.println("4. View contact By State ");
            System.out.println("5. View Contact by city ");
            System.out.println("6. Count Contact By State");
            System.out.println("7. Count Contact By City");
            System.out.println("8. Sort Contact By Name");
            System.out.println("9. Sort Contact By City");
            System.out.println("10. Sort Contact By State");
            System.out.println("11. Write data");
            System.out.println("12. Read data");
            System.out.println("13. Exit");

            System.out.println("Enter choice: ");
            int option = sc.nextInt();
            switch (option) {
                case 1: {
                    System.out.println("Enter the Name of Address Book: ");
                    String addressBookName = sc.next();
                    sc.nextLine();
                    if (AddressBookMain.addressBookListMap.containsKey(addressBookName)) {
                        System.out.println("The Address book Already Exists");
                        addressBookMain.addAddressBook(addressBookName);
                        break;
                    } else {
                        addressBookMain.addAddressBook(addressBookName);
                        break;
                    }
                }

                case 2:
                    System.out.println("Enter Name of City: ");
                    String cityName = sc.next();
                    sc.nextLine();
                    addressBookMain.searchPersonByCity(cityName);
                    break;

                case 3:
                    System.out.println("Enter Name of State: ");
                    String stateName = sc.next();
                    sc.nextLine();
                    addressBookMain.searchPersonByState(stateName);
                    break;

                case 4:
                    System.out.println("Enter Name of State: ");
                    String stateName1 = sc.next();
                    sc.nextLine();
                    addressBookMain.viewPersonByStateUsingHashmap(stateName1);
                    break;

                case 5:
                    System.out.println("Enter Name of City: ");
                    String cityName1 = sc.next();
                    sc.nextLine();
                    addressBookMain.viewPersonByCityUsingHashMap(cityName1);
                    break;
                case 6:
                    System.out.println("Enter Name of State: ");
                    String stateName2 = sc.next();
                    sc.nextLine();
                    addressBookMain.CountByState(stateName2);
                    break;

                case 7:
                    System.out.println("Enter Name of City: ");
                    String cityName2 = sc.next();
                    sc.nextLine();
                    addressBookMain.CountByCity(cityName2);
                    break;
                case 8:
                    System.out.println("Sort Contact");
                    addressBookMain.sortContactByName();
                case 9:
                    System.out.println("Sort Contact");
                    addressBookMain.sortContactByCity();
                    break;

                case 10:
                    System.out.println("Sort Contact");
                    addressBookMain.sortContactByState();
                    break;

                case 11:
                    AddressBook.writeData(addressBookMain);
                    break;
                case 12:
                    AddressBook.readData(addressBookMain);
                    break;
                case 13:
                    flag = false;
                    break;
            }
        }
        sc.close();
    }

}
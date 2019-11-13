package ui;

import logic.Person;
import logic.PhoneBook;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Scanner reader;
    private PhoneBook phoneBook = new PhoneBook();

    public UserInterface(Scanner reader) {
        this.reader = reader;
    }

    public void start() {
        System.out.println("phone search\n" +
                "available operations:\n" +
                " 1 add a number\n" +
                " 2 search for a number\n" +
                " 3 search for a person by phone number\n" +
                " 4 add an address\n" +
                " 5 search for personal information\n" +
                " 6 delete personal information\n" +
                " 7 filtered listing\n" +
                " x quit\n");
        askForCommand();
    }

    public void askForCommand() {
        String command;
        while (true) {
            System.out.print("command: ");
            command = this.reader.nextLine();
            if (command.length() > 1) {
                continue;
            }
            if ("1".equals(command)) {
                addNumber();
                continue;
            } else if ("2".equals(command)) {
                searchNumber();
                continue;
            } else if ("3".equals(command)) {
                searchPersonByNumber();
                continue;
            } else if ("4".equals(command)) {
                addAddress();
                continue;
            } else if ("5".equals(command)) {
                searchPersonalInfo();
                continue;
            } else if ("6".equals(command)) {
                deletePersonalInfo();
                continue;
            } else if ("7".equals(command)) {
                filteredListing();
                continue;
            }
            if (command.equals("x")) {
                break;
            }
        }
    }

    public void addNumber() {
        System.out.print("whose number: ");
        String name = this.reader.nextLine();
        System.out.println("number: ");
        String number = this.reader.nextLine();

        this.phoneBook.addNumber(name, number);
    }

    private void searchNumber() {
        System.out.print("whose number: ");
        String name = this.reader.nextLine();

        if (this.phoneBook.containsPersonByName(name)) {
            this.phoneBook.getPersonByName(name).printNumbers();
        } else {
            System.out.println("  not found");
        }
    }

    private void searchPersonByNumber() {
        System.out.println("number: ");
        String number = this.reader.nextLine();

        System.out.println(" " + this.phoneBook.getNameByNumber(number));
    }

    private void addAddress() {
        System.out.println("whose address: ");
        String name = this.reader.nextLine();
        System.out.println("street: ");
        String street = this.reader.nextLine();
        System.out.println("city ");
        String city = this.reader.nextLine();

        this.phoneBook.addAddress(name, street, city);
    }

    private void searchPersonalInfo() {
        System.out.println("whose information: ");
        String name = this.reader.nextLine();

        if (this.phoneBook.containsPersonByName(name)) {
            this.phoneBook.getPersonByName(name).printDetails();
        } else {
            System.out.println("  not found");
        }
    }

    private void deletePersonalInfo() {
        System.out.println("whose information: ");
        String name = this.reader.nextLine();

        if (this.phoneBook.containsPersonByName(name)) {
            this.phoneBook.deleteInfoByName(name);
        } else {
            System.out.println(" not found");
        }
    }

    private void filteredListing() {
        System.out.println("keyword (if empty, all listed): ");
        String keyword = this.reader.nextLine();

        List<Person> personList = this.phoneBook.searchByKeyword(keyword);
        Collections.sort(personList);

        if (personList.isEmpty()) {
            System.out.println(" not found");
        } else {
            for (Person p : personList) {
                p.printNameAndDetails();
            }
        }
    }
}

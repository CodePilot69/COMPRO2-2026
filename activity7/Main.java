package com.phonebook;

import com.phonebook.models.Contact;
import com.phonebook.services.PhonebookService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PhonebookService service = new PhonebookService();
        Scanner sc = new Scanner(System.in);
        String file = "contacts.csv";

        service.loadFromCSV(file);

        while (true) {
            System.out.println("\n1. Add | 2. Search | 3. Remove | 4. Display | 5. Save | 0. Exit");
            System.out.print("Enter choice: ");
            int choice = Integer.parseInt(sc.nextLine());

            if (choice == 0) break;

            switch (choice) {
                case 1:
                    System.out.print("Name: "); String name = sc.nextLine();
                    System.out.print("Phone: "); String phone = sc.nextLine();
                    System.out.print("Email: "); String email = sc.nextLine();
                    service.addContact(new Contact(name, phone, email));
                    break;
                case 2:
                    System.out.print("Search name: ");
                    Contact found = service.searchContact(sc.nextLine());
                    System.out.println(found != null ? found : "Contact not found.");
                    break;
                case 3:
                    System.out.print("Remove name: ");
                    if (service.removeContact(sc.nextLine())) {
                        System.out.println("Removed successfully.");
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;
                case 4:
                    if (service.getAllContacts().isEmpty()) {
                        System.out.println("Phonebook is empty.");
                    } else {
                        service.getAllContacts().values().forEach(System.out::println);
                    }
                    break;
                case 5:
                    service.saveToCSV(file);
                    System.out.println("Data saved to " + file);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
        sc.close();
    }
}
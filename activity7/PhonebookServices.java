package com.phonebook.services;

import com.phonebook.models.Contact;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class PhonebookService {
    private HashMap<String, Contact> contacts = new HashMap<>();

    public void addContact(Contact c) {
        contacts.put(c.getName(), c);
    }

    public Contact searchContact(String name) {
        return contacts.get(name);
    }

    public boolean removeContact(String name) {
        return contacts.remove(name) != null;
    }

    public Map<String, Contact> getAllContacts() {
        return contacts;
    }

    public void saveToCSV(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Contact c : contacts.values()) {
                writer.println(c.toCsvString());
            }
        } catch (IOException e) {
            System.out.println("Save error: " + e.getMessage());
        }
    }

    public void loadFromCSV(String filename) {
        File file = new File(filename);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 3) {
                    addContact(new Contact(data[0], data[1], data[2]));
                }
            }
        } catch (IOException e) {
            System.out.println("Load error: " + e.getMessage());
        }
    }
}
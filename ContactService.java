/*
 * Author: Melissa Combs
 * Course: CS 320 - Software Test Automation
 * Project One - Contact Service
 *
 * Stores contacts in memory and supports adding, deleting, finding,
 * and updating contacts by their unique contact ID.
 */

import java.util.HashMap;
import java.util.Map;

public class ContactService {

    // HashMap provides direct lookup by the unique contact ID.
    private final Map<String, Contact> contacts = new HashMap<>();

    public void addContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("Contact cannot be null.");
        }

        if (contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException(
                    "A contact with this ID already exists.");
        }

        contacts.put(contact.getContactId(), contact);
    }

    public void deleteContact(String contactId) {
        if (contactId == null || !contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID was not found.");
        }

        contacts.remove(contactId);
    }

    public void updateFirstName(String contactId, String firstName) {
        getContact(contactId).setFirstName(firstName);
    }

    public void updateLastName(String contactId, String lastName) {
        getContact(contactId).setLastName(lastName);
    }

    public void updatePhone(String contactId, String phone) {
        getContact(contactId).setPhone(phone);
    }

    public void updateAddress(String contactId, String address) {
        getContact(contactId).setAddress(address);
    }

    // Centralized lookup prevents update methods from duplicating ID checks.
    public Contact getContact(String contactId) {
        if (contactId == null || !contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID was not found.");
        }

        return contacts.get(contactId);
    }
}

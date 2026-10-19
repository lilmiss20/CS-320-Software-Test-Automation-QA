/*
 * Author: Melissa Combs
 * Course: CS 320 - Software Test Automation
 * Project One - Contact Service Tests
 *
 * JUnit 5 verifies unique IDs, adding, deletion, lookup,
 * all permitted field updates, and invalid service operations.
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    private ContactService service;
    private Contact contact;

    @BeforeEach
    void setUp() {
        // A new service for every test keeps tests independent.
        service = new ContactService();
        contact = new Contact(
                "C001", "Melissa", "Combs", "4195551212", "123 Main St");
    }

    @Test
    void testAddContact() {
        service.addContact(contact);
        assertSame(contact, service.getContact("C001"));
    }

    @Test
    void testNullContactCannotBeAdded() {
        assertThrows(IllegalArgumentException.class,
                () -> service.addContact(null));
    }

    @Test
    void testDuplicateIdRejected() {
        service.addContact(contact);
        Contact duplicate = new Contact(
                "C001", "John", "Smith", "5678901234", "456 Oak Ave");

        assertThrows(IllegalArgumentException.class,
                () -> service.addContact(duplicate));
        assertSame(contact, service.getContact("C001"));
    }

    @Test
    void testDeleteContact() {
        service.addContact(contact);
        service.deleteContact("C001");

        assertThrows(IllegalArgumentException.class,
                () -> service.getContact("C001"));
    }

    @Test
    void testDeleteUnknownContact() {
        assertThrows(IllegalArgumentException.class,
                () -> service.deleteContact("NOID"));
    }

    @Test
    void testDeleteNullContactId() {
        assertThrows(IllegalArgumentException.class,
                () -> service.deleteContact(null));
    }

    @Test
    void testUpdateFirstName() {
        service.addContact(contact);
        service.updateFirstName("C001", "Mel");
        assertEquals("Mel", service.getContact("C001").getFirstName());
    }

    @Test
    void testUpdateLastName() {
        service.addContact(contact);
        service.updateLastName("C001", "Smith");
        assertEquals("Smith", service.getContact("C001").getLastName());
    }

    @Test
    void testUpdatePhone() {
        service.addContact(contact);
        service.updatePhone("C001", "5678901234");
        assertEquals("5678901234", service.getContact("C001").getPhone());
    }

    @Test
    void testUpdateAddress() {
        service.addContact(contact);
        service.updateAddress("C001", "456 Oak Ave");
        assertEquals("456 Oak Ave", service.getContact("C001").getAddress());
    }

    @Test
    void testUnknownContactUpdate() {
        assertThrows(IllegalArgumentException.class,
                () -> service.updateFirstName("NOID", "John"));
    }

    @Test
    void testInvalidUpdateRejectedWithoutChangingValue() {
        service.addContact(contact);

        assertThrows(IllegalArgumentException.class,
                () -> service.updatePhone("C001", "12345"));
        assertEquals("4195551212", service.getContact("C001").getPhone());
    }
}

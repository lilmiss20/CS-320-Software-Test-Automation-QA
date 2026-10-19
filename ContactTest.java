/*
 * Author: Melissa Combs
 * Course: CS 320 - Software Test Automation
 * Project One - Contact Object Tests
 *
 * JUnit 5 verifies valid contact creation, required fields,
 * field-length boundaries, phone formatting, and allowed updates.
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactTest {

    @Test
    void testContactCreation() {
        Contact contact = new Contact(
                "C001", "Melissa", "Combs", "4195551212", "123 Main St");

        assertEquals("C001", contact.getContactId());
        assertEquals("Melissa", contact.getFirstName());
        assertEquals("Combs", contact.getLastName());
        assertEquals("4195551212", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }

    @Test
    void testInvalidContactId() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact(
                        null, "Melissa", "Combs", "4195551212", "123 Main St"));
        assertThrows(IllegalArgumentException.class,
                () -> new Contact(
                        "12345678901", "Melissa", "Combs", "4195551212", "123 Main St"));
    }

    @Test
    void testTenCharacterContactIdIsAllowed() {
        Contact contact = new Contact(
                "1234567890", "Melissa", "Combs", "4195551212", "123 Main St");
        assertEquals("1234567890", contact.getContactId());
    }

    @Test
    void testInvalidFirstName() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact(
                        "C001", null, "Combs", "4195551212", "123 Main St"));
        assertThrows(IllegalArgumentException.class,
                () -> new Contact(
                        "C001", "LongFirstNm", "Combs", "4195551212", "123 Main St"));
    }

    @Test
    void testInvalidLastName() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact(
                        "C001", "Melissa", null, "4195551212", "123 Main St"));
        assertThrows(IllegalArgumentException.class,
                () -> new Contact(
                        "C001", "Melissa", "LongLastName", "4195551212", "123 Main St"));
    }

    @Test
    void testInvalidPhone() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact(
                        "C001", "Melissa", "Combs", null, "123 Main St"));
        assertThrows(IllegalArgumentException.class,
                () -> new Contact(
                        "C001", "Melissa", "Combs", "12345", "123 Main St"));
        assertThrows(IllegalArgumentException.class,
                () -> new Contact(
                        "C001", "Melissa", "Combs", "41955512AB", "123 Main St"));
    }

    @Test
    void testInvalidAddress() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact(
                        "C001", "Melissa", "Combs", "4195551212", null));
        assertThrows(IllegalArgumentException.class,
                () -> new Contact(
                        "C001", "Melissa", "Combs", "4195551212",
                        "1234567890123456789012345678901"));
    }

    @Test
    void testThirtyCharacterAddressIsAllowed() {
        String address = "123456789012345678901234567890";
        Contact contact = new Contact(
                "C002", "Melissa", "Combs", "4195551212", address);
        assertEquals(address, contact.getAddress());
    }

    @Test
    void testSetters() {
        Contact contact = new Contact(
                "C001", "Melissa", "Combs", "4195551212", "123 Main St");

        contact.setFirstName("Mel");
        contact.setLastName("Smith");
        contact.setPhone("5678901234");
        contact.setAddress("456 Oak Ave");

        assertEquals("Mel", contact.getFirstName());
        assertEquals("Smith", contact.getLastName());
        assertEquals("5678901234", contact.getPhone());
        assertEquals("456 Oak Ave", contact.getAddress());
    }

    @Test
    void testContactIdHasNoPublicSetter() {
        assertThrows(NoSuchMethodException.class,
                () -> Contact.class.getMethod("setContactId", String.class));
    }
}

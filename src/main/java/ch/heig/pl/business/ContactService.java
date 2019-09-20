package ch.heig.pl.business;

import ch.heig.pl.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactService {
    private List<Contact>  contacts;

    public ContactService() {
        contacts = new ArrayList<>();
        contacts.add(new Contact("Pierre",1234));
        contacts.add(new Contact("Sylvie",1111));
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void add(Contact contact) {
        contacts.add(contact);
    }
}

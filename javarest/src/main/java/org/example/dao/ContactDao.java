package org.example.dao;

import org.example.domain.Contact;

import java.util.Arrays;
import java.util.List;

public class ContactDao {
    private final List<Contact> contacts = Arrays.asList(
            Contact.builder().firstName("Sammie").surname("Smith").email("sam.smith@music.com").build(),
            Contact.builder().firstName("Frank").surname("Muscles").email("frank@muscles.com").build(),
            Contact.builder().firstName("Eddy").surname("Valentino").email("eddy@valfam.co.uk").build()
    );

    public List<Contact> getAll() {
        return contacts;
    }


}


package org.example.dao;

import org.example.domain.Contact;

import java.util.Collection;


public interface IContactDao {

    Collection<Contact> getAll();

    Collection<Contact> get(String q);

    boolean add(Contact c);

}

package org.example.dao;

import org.example.domain.Contact;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.List;

@Stateless
public class ContactDaoDb implements IContactDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Contact> getAll() {
        return em.createNamedQuery("Contact.findAll", Contact.class).getResultList();
    }

    @Override public Collection<Contact> get(String q) {
        return null;
    }

    @Override public boolean add(Contact c) {
        return false;
    }
}
